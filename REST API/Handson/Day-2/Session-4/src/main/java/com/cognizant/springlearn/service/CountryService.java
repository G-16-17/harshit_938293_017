package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	List<Country> countryList = context.getBean("countryList", List.class);

	public List<Country> getAllCountries() {
		return countryList;
	}

	public Country getCountry(String code) throws CountryNotFoundException {
		for (Country country : countryList) {
			if (country.getCode().equalsIgnoreCase(code)) {
				return country;
			}
		}
		throw new CountryNotFoundException();
	}

	public void addCountry(Country country) {
		boolean bool = true;
		for (Country cntry : countryList) {
			if (cntry.getCode().equals(country.getCode())) {
				bool = false;
				break;
			}
		}
		if (bool) {
			countryList.add(country);
		} else {
			System.out.println("Already exist");
		}
	}
}
