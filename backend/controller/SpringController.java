package com.owen.www.springtest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.owen.www.data.Token;

@RestController("SpringController")
public class SpringController {
	
	@RequestMapping(value = "getData", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> getLoginToken(Token googleToken) throws IOException {
		
		String client_id="client_id=269359817808-0lp0p1bm0epj4sdqv49omsdq98astj2a.apps.googleusercontent.com&";
		String client_secret="client_secret=vO2EUH4pybFCq3d596GKn_Dd&";
		String redirect_uri = "redirect_uri=http://ec2-13-124-116-59.ap-northeast-2.compute.amazonaws.com/login&";
		String grant_type = "grant_type=authorization_code";
		String postData = "code=" + googleToken.getCode() + "&" + client_id + client_secret + redirect_uri + grant_type;
		String url = "https://accounts.google.com/o/oauth2/token";	
		
		String accessToken = _getAccessToken(HttpPostMethod.sendPost(url, postData));
		
		String channelId = "https://www.googleapis.com/youtube/v3/channels?part=id&mine=true&access_token=" + accessToken;
		String youtube = "https://www.googleapis.com/youtube/v3/search?access_token="+accessToken+"&part=snippet&order=date&type=video&maxResults=50&channelId="+_getChanelId(HttpGetMethod.sendGet(channelId));

		return _getVideos(HttpGetMethod.sendGet(youtube));
	}
	
	public String _getAccessToken(String json) throws IOException {
		return new ObjectMapper().readTree(json).get("access_token").textValue();
	}
	
	public String _getChanelId(String json) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(json);
		
		String getChannelId="";
		if(node.get("items").isArray()==true) {
			getChannelId = node.get("items").get(0).get("id").asText();
		}
		
		return getChannelId;
	}
	
	public List<Map<String,String>> _getVideos(String json) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Map<String,String>> list = new ArrayList<>();
		JsonNode items = mapper.readTree(json).get("items");

		if(items.isArray()==true) {
			
			for(int i=0;i<items.size();i++) {
				Map<String,String> map = new HashMap<>();
				map.put("videoId", items.get(i).get("id").get("videoId").asText());
				list.add(map);
			}
		
		}
	
		return list;
	}
	
}