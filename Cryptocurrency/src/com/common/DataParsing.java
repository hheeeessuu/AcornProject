package com.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.dto.BithumbDTO;
import com.dto.UpbitDTO;

public class DataParsing {

	// url에 접속해 데이터를 얻어온다.
	public String connectURL(String url, String currency) {
		HttpURLConnection huc = null;
		StringBuilder sb = null;
		try {
			huc = (HttpURLConnection) new URL(url + currency).openConnection();
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
		return sb.toString();
	}
	
	public String objectToString(Object obj) {
		if(obj instanceof String) {
			return (String)obj;
		} else if(obj instanceof Double) {
			return Double.toString((Double)obj);
		} else if(obj instanceof Long) {
			return Long.toString((Long)obj);
		}
		return null;
	}
	
	public double objectToDouble(Object obj) {
		if(obj instanceof String) {
			return Double.parseDouble((String)obj);
		} else if(obj instanceof Double) {
			return (Double)obj;
		} else if(obj instanceof Long) {
			return ((Long)obj).doubleValue();
		}
		
		return 0;
	}

	// 얻어온 bithumb데이터를 BithumbDTO에 넣어준다.
	public BithumbDTO parseBithumbData(String bithumbData, String currency) {
//		System.out.println(bithumbData);
		BithumbDTO dto = null;

		// json parsing
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = null;

		try {
			jsonObj = (JSONObject)parser.parse(bithumbData);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}

		if(jsonObj.get("status").equals("0000")) {
			dto = new BithumbDTO();
			JSONObject data = (JSONObject)jsonObj.get("data");
			String date = objectToString(System.currentTimeMillis());

			dto.setBithumb_pk(date + currency);
			dto.setBithumb_date(date);
			dto.setCurrency(currency);
			dto.setOpening_price(objectToDouble(data.get("opening_price")));
			dto.setClosing_price(objectToDouble(data.get("closing_price")));
			dto.setMin_price(objectToDouble(data.get("min_price")));
			dto.setMax_price(objectToDouble(data.get("max_price")));
			dto.setAverage_price(objectToDouble(data.get("average_price")));
			dto.setUnits_traded(objectToDouble(data.get("units_traded")));
			dto.setVolume_1day(objectToDouble(data.get("volume_1day")));
			dto.setVolume_7day(objectToDouble(data.get("volume_7day")));
			dto.setBuy_price(objectToDouble(data.get("buy_price")));
			dto.setSell_price(objectToDouble(data.get("sell_price")));
			dto.setFluctate_24H(objectToDouble(data.get("24H_fluctate")));
			dto.setFluctate_rate_24H(objectToDouble(data.get("24H_fluctate_rate")));
		}
		return dto;
	}

	// 얻어온 upbit데이터를 UpbitDTO에 넣어준다.
	public UpbitDTO parseUpbitData(String upbitData) {
//		System.out.println(upbitData);
		
		// error를 가지고 있으면..
		if(upbitData.contains("error")) {
			return null;
		}
		UpbitDTO dto = null;

		// json parsing
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = null;
		
		try {
			// 앞뒤 []문자를 빼줘야한다...
			jsonObj = (JSONObject)parser.parse(upbitData.substring(1, upbitData.length() - 1));
			
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(jsonObj == null)
			return null;
		
		if(jsonObj.get("market") != null) {
			dto = new UpbitDTO();
			
			String timestamp = objectToString(System.currentTimeMillis());
			String market = (String)jsonObj.get("market");
			
			/*System.out.println(jsonObj.get("opening_price").getClass());
			System.out.println(jsonObj.get("high_price").getClass());
			System.out.println(jsonObj.get("low_price").getClass());
			System.out.println(jsonObj.get("trade_price").getClass());
			System.out.println(jsonObj.get("prev_closing_price").getClass());
			System.out.println(jsonObj.get("change").getClass());
			System.out.println(jsonObj.get("change_rate").getClass());
			System.out.println(jsonObj.get("signed_change_price").getClass());
			System.out.println(jsonObj.get("signed_change_rate").getClass());
			System.out.println(jsonObj.get("trade_volume").getClass());
			System.out.println(jsonObj.get("acc_trade_price").getClass());
			System.out.println(jsonObj.get("acc_trade_price_24h").getClass());
			System.out.println(jsonObj.get("acc_trade_volume").getClass());
			System.out.println(jsonObj.get("acc_trade_volume_24h").getClass());*/
			
			
			dto.setUpbit_pk(timestamp + market);
			dto.setUpbit_date(timestamp);
			dto.setMarket(market);
			dto.setOpening_price(objectToDouble(jsonObj.get("opening_price")));
			dto.setHigh_price(objectToDouble(jsonObj.get("high_price")));
			dto.setLow_price(objectToDouble(jsonObj.get("low_price")));
			dto.setTrade_price(objectToDouble(jsonObj.get("trade_price")));
			dto.setPrev_closing_price(objectToDouble(jsonObj.get("prev_closing_price")));
			dto.setChange(objectToString(jsonObj.get("change")));
			dto.setChange_price(objectToDouble(jsonObj.get("change_price")));
			dto.setChange_rate(objectToDouble(jsonObj.get("change_rate")));
			dto.setSigned_change_price(objectToDouble(jsonObj.get("signed_change_price")));
			dto.setSigned_change_rate(objectToDouble(jsonObj.get("signed_change_rate")));
			dto.setTrade_volume(objectToDouble(jsonObj.get("trade_volume")));
			dto.setAcc_trade_price(objectToDouble(jsonObj.get("acc_trade_price")));
			dto.setAcc_trade_price_24h(objectToDouble(jsonObj.get("acc_trade_price_24h")));
			dto.setAcc_trade_volume(objectToDouble(jsonObj.get("acc_trade_volume")));
			dto.setAcc_trade_volume_24h(objectToDouble(jsonObj.get("acc_trade_volume_24h")));
		}
		
		return dto;
	}
}
