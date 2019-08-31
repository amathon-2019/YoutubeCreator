package com.owen.www.springtest.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class HttpGetMethod {
	
	
    public static String sendGet(String url) throws IOException{
    	
    	String result = null;
    	HttpURLConnection conn=null;

        URL urlObject = new URL(url);
        
        conn = (HttpURLConnection)urlObject.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Connection","Keep-Alive");
        conn.setRequestProperty("Accept-Charset","UTF-8");
        conn.setRequestProperty("Cache-Control","no-cache"); //캐시된 데이터를 사용하지 않고 매번 서버로부터 다시 받음
        conn.setRequestProperty("Accept-Charset","application/json");
		conn.setConnectTimeout(10000);
		conn.setReadTimeout(5000);
		conn.setDoInput(true);  // Server 통신에서 입력 가능한 상태로 만듬
		//conn.setDoOutput(true); // Server 통신에서 입력 가능한 상태로 만듬 405에러
		
        conn.connect();

        // Status Code Definitions Http상태코드 상태코드에 따른
        // https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
        int status = conn.getResponseCode();
        if(status == HttpURLConnection.HTTP_OK || status == HttpURLConnection.HTTP_CREATED || status == HttpURLConnection.HTTP_ACCEPTED){
            BufferedReader br = null;
            StringBuilder sb = null;

			Charset charset = Charset.forName("UTF-8");
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			sb = new StringBuilder();
            String line;
			while((line =br.readLine())!=null){
			    sb.append(line+"\n");
			}
			br.close();
		    conn.disconnect();
			result = sb.toString();
            
        }
		conn.disconnect();
    	
    	return result;
    	
    }

}

