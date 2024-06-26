package com.quiz.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {

	@Autowired
	private WeatherHistoryMapper weatherhistoryMapper;
	
	// input: X
	// output: 날짜 리스트
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherhistoryMapper.selectWeatherHistoryList();
	}
}
