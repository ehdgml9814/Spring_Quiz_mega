package com.quiz.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {

	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	// input: X
	// output: 날짜 리스트
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	
//	@RequestParam("date") String date, 
//	@RequestParam("weather") String weather, 
//	@RequestParam("microDust") String microDust, 
//	@RequestParam("temperatures") double temperatures, 
//	@RequestParam("precipitation") double precipitation, 
//	@RequestParam("windSpeed") double windSpeed)
	public void addWeatherHistory(String date, String weather, 
			String microDust, double temperatures, double precipitation, double windSpeed) {
		weatherHistoryMapper.insertWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
}
