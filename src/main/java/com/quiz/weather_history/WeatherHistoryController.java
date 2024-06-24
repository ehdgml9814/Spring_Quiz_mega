package com.quiz.weather_history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/weather-histroty")
@Controller
public class WeatherHistoryController {

	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		
	}
	
	@PostMapping("/weather-list-view")
	public String weatherListView() {
		
	}
}
