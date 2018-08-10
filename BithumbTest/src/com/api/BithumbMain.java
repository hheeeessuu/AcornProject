package com.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bithumb.Util;
import com.dto.BithumbDTO;
import com.service.MyBatisService;

public class BithumbMain {

	public static void main(String[] args) {
		
		StringBuilder sb = null;
		URL url = null;
		
		// Bithumb데이터 얻어오기
		try {
			url = new URL(Util.BITHUMB_TICKER + Util.BITHUMB_ALL);
			String postSql = "&cont_no=0&count=20";
			URLConnection conn;
			conn = url.openConnection();
			
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(postSql);
			wr.flush();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			sb = new StringBuilder();
			String line = null;
			
			while((line=reader.readLine()) != null) {
				sb.append(line + "\n");
			}
//			System.out.println(sb);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// json parsing
		JSONParser parser = new JSONParser();
		Object obj = null;
		JSONObject data = null;
		String date = null;
		
		try {
			obj = parser.parse(sb.toString());
			
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		data = (JSONObject)((JSONObject)obj).get("data");
		// 시간 데이터
		date = (String)data.get("date");
		
		// 각 코인별로 데이터 얻기
		JSONObject jsonObj = null;
		ArrayList<BithumbDTO> list = new ArrayList<>();
		for(int i = 0 ; i < Util.BITHUMB_CURRENCY.length; ++i) {
			jsonObj = (JSONObject)data.get(Util.BITHUMB_CURRENCY[i]);
			
			list.add(new BithumbDTO(date + "/" + Util.BITHUMB_CURRENCY[i], date, Util.BITHUMB_CURRENCY[i], Long.parseLong((String)jsonObj.get("opening_price")), 
					Long.parseLong((String)jsonObj.get("closing_price")),Long.parseLong((String)jsonObj.get("min_price")), 
					Long.parseLong((String)jsonObj.get("max_price")), Double.parseDouble((String)jsonObj.get("average_price")), 
					Double.parseDouble((String)jsonObj.get("units_traded")), Double.parseDouble((String)jsonObj.get("volume_1day")),
					Double.parseDouble((String)jsonObj.get("volume_7day")), Long.parseLong((String)jsonObj.get("buy_price")), 
					Long.parseLong((String)jsonObj.get("sell_price")), (long)jsonObj.get("24H_fluctate"),
					Double.parseDouble((String)jsonObj.get("24H_fluctate_rate"))));
			System.out.println(list.get(i));
		}
		
		MyBatisService service = new MyBatisService();
		service.multiInsert(list);
		
		
		
		// 현재 시간 확인
		Date getDate = new Date(Long.parseLong(date));
//		System.out.println(getDate);
	}

}
