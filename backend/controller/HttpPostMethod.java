package com.owen.www.springtest.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class HttpPostMethod {

	public static String sendPost(String url, String body) throws IOException{
    	
    	String result = null;
    	HttpURLConnection conn=null;
    
		URL urlObject = new URL(url);
		
		conn = (HttpURLConnection)urlObject.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("User-Agent", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		conn.setConnectTimeout(10000);
		conn.setReadTimeout(5000);
		//conn.setDoInput(true);  // Server 통신에서 입력 가능한 상태 (default = true)
		conn.setDoOutput(true); // Server 통신에서 출력 가능한 상태 (default = true) 사용시 405에러
        
		DataOutputStream wr=null;
		
        wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(body);
        wr.flush();
        wr.close();
        
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
			result = sb.toString();
			br.close();
			
        }
		conn.disconnect();
    	
    	return result;
    	
    }

}
