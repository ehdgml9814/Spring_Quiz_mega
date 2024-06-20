package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;
	
	// 공인중개사 추가 화면
	// localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor, 
			Model model) {
		// insert
		realtorBO.addRealtor(realtor);
		
		// select
		int id = realtor.getId();
		Realtor latestRealtor = realtorBO.getRealtorById(id);
	  	
		//model
		model.addAttribute("realtor", latestRealtor);
		
		// 공인중개사 정보 화면
		// localhost:8080/lesson04/quiz02/afterAddRealtor
		return "lesson04/afterAddRealtor";
	}
}
