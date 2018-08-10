package com.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BithumbMain2 {

	public static void main(String[] args) {

		HttpURLConnection huc = null;
		StringBuilder sb = null;
		try {
			huc = (HttpURLConnection) new URL("https://api.upbit.com/v1/market/all").openConnection();
			huc.setRequestMethod("GET");
			huc.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			huc.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");     
			huc.connect();
			InputStream in = null;
			if( huc.getResponseCode() != 200 ){
				in = huc.getErrorStream();
			}else{
				in = huc.getInputStream();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(  in , "UTF-8"));
			String line = null;
			sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
//			System.out.println(sb.toString());	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// json parsing
		JSONParser parser = new JSONParser();
		Object obj = null;
		
		try {
			obj = parser.parse(sb.toString());

		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		JSONArray array = (JSONArray)obj;
		int i = 0;
		for (Object object : array) {
			JSONObject jsonObj = (JSONObject)object;
//			String jsonObj.get("")
			String market = (String)jsonObj.get("market");
			String korean_name = (String)jsonObj.get("korean_name");
			String english_name = (String)jsonObj.get("english_name");
			
			if(market.contains("KRW")) {
				System.out.println(market + ", " + korean_name + ", " + english_name);
				i++;
			}
		}
		System.out.println(i);
	}
}
