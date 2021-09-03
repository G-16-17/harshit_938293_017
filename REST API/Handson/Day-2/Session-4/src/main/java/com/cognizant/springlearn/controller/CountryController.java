package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

//	@RequestMapping(value = "/country", method = RequestMethod.GET)
//	public Country getCountryIndia() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//		return context.getBean("in", Country.class);
//	}
//
	@GetMapping
	public List<Country> getAllCountry() {
		LOGGER.info("Start");

		LOGGER.info("End");
		return countryService.getAllCountries();
	}

	@GetMapping("/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		return countryService.getCountry(code);
	}

	@PostMapping
	public void addCountry(@Valid @RequestBody Country country) {
		LOGGER.info("Start");
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		Set<ConstraintViolation<Country>> violations = validator.validate(country);
//		List<String> errors = new ArrayList<String>();
//		for (ConstraintViolation<Country> violation : violations) {
//			errors.add(violation.getMessage());
//		}
//		if (violations.size() > 0) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
//		}
		countryService.addCountry(country);
		LOGGER.info("End");
	}

}
