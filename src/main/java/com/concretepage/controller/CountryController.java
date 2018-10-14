package com.concretepage.controller;
import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.Country;
import com.concretepage.service.CountryService;

@Controller
@RequestMapping("api")
public class CountryController {
	@Autowired
	private CountryService CountryService;
	//http://localhost:5000/api/country/ind
	@GetMapping("country/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable("id") String Code) {
		Country Country = CountryService.getCountryById(Code);
		return new ResponseEntity<Country>(Country, HttpStatus.OK);
	}
	//http://localhost:5000/api/countrys/
	@GetMapping("countrys")
	public ResponseEntity<List<Country>> getAllCountrys() {
		List<Country> list = CountryService.getAllCountrys();
		return new ResponseEntity<List<Country>>(list, HttpStatus.OK);
	}
	@PostMapping("country")
	public ResponseEntity<Void> addCountry(@RequestBody Country Country, UriComponentsBuilder builder) {
        boolean flag = CountryService.addCountry(Country);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/country/{id}").buildAndExpand(Country.getCode()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("country")
	public ResponseEntity<Country> updateCountry(@RequestBody Country Country) {
		CountryService.updateCountry(Country);
		return new ResponseEntity<Country>(Country, HttpStatus.OK);
	}
	@DeleteMapping("country/{id}")
	public ResponseEntity<Void> deleteCountry(@PathVariable("id") String id) {
		CountryService.deleteCountry(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("countrys/{search}")
	public ResponseEntity<List<Country>> getCountryBySearch(@PathVariable("search") String search) {
		List<Country> list = CountryService.getCountryBySearch(search);
		return new ResponseEntity<List<Country>>(list, HttpStatus.OK);
	}
} 