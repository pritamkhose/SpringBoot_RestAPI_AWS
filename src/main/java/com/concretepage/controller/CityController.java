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

import com.concretepage.entity.City;
import com.concretepage.service.CityService;

@Controller
@RequestMapping("api")
public class CityController {
	@Autowired
	private CityService CityService;
	//http://localhost:5000/api/city/ind
	@GetMapping("city/{id}")
	public ResponseEntity<City> getCityById(@PathVariable("id") Integer id) {
		City City = CityService.getCityById(id);
		return new ResponseEntity<City>(City, HttpStatus.OK);
	}
	//http://localhost:5000/api/citys/
	@GetMapping("citys")
	public ResponseEntity<List<City>> getAllCitys() {
		List<City> list = CityService.getAllCitys();
		return new ResponseEntity<List<City>>(list, HttpStatus.OK);
	}
	@PostMapping("city")
	public ResponseEntity<Void> addCity(@RequestBody City City, UriComponentsBuilder builder) {
        boolean flag = CityService.addCity(City);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/city/{id}").buildAndExpand(City.getID()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("city")
	public ResponseEntity<City> updateCity(@RequestBody City City) {
		CityService.updateCity(City);
		return new ResponseEntity<City>(City, HttpStatus.OK);
	}
	@DeleteMapping("city/{id}")
	public ResponseEntity<Void> deleteCity(@PathVariable("id") Integer id) {
		CityService.deleteCity(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("citys/{search}")
	public ResponseEntity<List<City>> getCityBySearch(@PathVariable("search") String search) {
		List<City> list = CityService.getCityBySearch(search);
		return new ResponseEntity<List<City>>(list, HttpStatus.OK);
	}
} 