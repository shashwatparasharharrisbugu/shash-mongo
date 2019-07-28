package com.drkiettran.mongodb.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class WeatherService {

	public String WeatherDetails(String location) {

		String appID = "&APPID=1a04352f0ec31c577b81fba02b4f7003";
		String apiEndPoint = "http://api.openweathermap.org/data/2.5/weather?q=";
		String fullApiRequest = apiEndPoint + location + appID;
		System.out.println("fullApiRequest" + fullApiRequest);
		//Sample correct request
		//String url = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=1a04352f0ec31c577b81fba02b4f7003";
		HttpURLConnection con = null;

		try {

			URL myurl = new URL(fullApiRequest);
			con = (HttpURLConnection) myurl.openConnection();

			con.setRequestMethod("GET");

			StringBuilder content;

			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

				String line;
				content = new StringBuilder();

				while ((line = in.readLine()) != null) {
					content.append(line);
					content.append(System.lineSeparator());
				}
			}

			System.out.println(content.toString());
			return content.toString();

		} catch (Exception e) {
			System.out.println("Error" + e);
		} finally {
			con.disconnect();
		}

		return "Could not process the request";
	}

}
