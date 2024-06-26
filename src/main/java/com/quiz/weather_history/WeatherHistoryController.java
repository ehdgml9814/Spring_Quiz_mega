package com.quiz.weather_history;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/weather-list-view")
	public String addWeatherView(Model model) {
		// select DB
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		// model 담기
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		return "weather_history/weatherList";
	}
	
	@GetMapping("/add-weather-view")
	public String weatherListView() {
		return "weather_history/addWeather";
	}
	
	// 날씨 추가 기능 /weather-history/add-weather
	@PostMapping("/add-weather")
	public String addWeather(
			// @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
			// 또는 객체로 받아올 때는 객체 클래스 위에 @어노테이션 추가
			// LocalDate도 가능
			@RequestParam("date") String date, 
			@RequestParam("weather") String weather, 
			@RequestParam("microDust") String microDust, 
			@RequestParam("temperatures") double temperatures, 
			@RequestParam("precipitation") double precipitation, 
			@RequestParam("windSpeed") double windSpeed) {
		// DB insert
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		// redirect => 날씨 목록
		return "redirect:/weather-history/weather-list-view";
	}
}
