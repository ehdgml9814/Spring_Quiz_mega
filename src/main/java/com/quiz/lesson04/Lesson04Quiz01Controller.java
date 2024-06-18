package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// http://localhost/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String assSellerView() {
		return "lesson04/addSeller";
	}
	
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname, 
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl, 
			@RequestParam(value = "temperature", required = false) Double temperature) {
		
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	@GetMapping("/seller-info-view")
	public String latestSellerView(Model model) {
		Seller seller = sellerBO.getLatestSeller();
		
		model.addAttribute("select", seller);
		
		return "lesson04/latestSeller";
	}
}
