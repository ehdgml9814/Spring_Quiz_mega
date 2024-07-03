package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public List<RecruitEntity> quiz1() {
		return recruitRepository.findById(8);
	}
	@GetMapping("/2")
	public List<RecruitEntity> quiz2() {
		return recruitRepository.findByCompanyId(1);
	}
	@GetMapping("/3")
	public List<RecruitEntity> quiz3() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	@GetMapping("/4")
	public List<RecruitEntity> quiz4() {
		return recruitRepository.findByTypeOrSalaryGreaterThan("정규직", 9000);
	}
	@GetMapping("/5")
	public List<RecruitEntity> quiz5() {
		return recruitRepository.findByTypeByOrderBySalaryDesc("계약직");
	}
	@GetMapping("/6")
	public List<RecruitEntity> quiz6() {
		return recruitRepository.findById(8);
	}
	
}
