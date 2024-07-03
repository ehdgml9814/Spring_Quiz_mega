package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyEntity addCompany(String name, String business, 
			String scale, int headcount) {
//		CompanyEntity company = CompanyEntity.builder()
//				.name(name)
//				.business(business)
//				.scale(scale)
//				.headcount(headcount)
//				.build();
		
		return companyRepository.save(CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build());
	}
	
	public CompanyEntity updateCompanyById(int id, String scale, int headcount) {
		// 조회
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// update
		if (company != null) {
			company = companyRepository.save(company.toBuilder()
				.scale(scale)
				.headcount(headcount)
				.build());
		}
		
		// return
		return company;  
	}
	
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> company = companyRepository.findById(id);
		company.ifPresent(c -> companyRepository.delete(c));
	}
}
