package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.CountryDAO;
import com.concretepage.entity.Country;
@Service
public class CountryService {

	@Autowired
	private CountryDAO CountryDAO;
	//@Override
	public Country getCountryById(String CountryId) {
		Country obj = CountryDAO.getCountryById(CountryId);
		return obj;
	}	
	//@Override
	public List<Country> getAllCountrys(){
		return CountryDAO.getAllCountrys();
	}
	//@Override
	public synchronized boolean addCountry(Country Country){
       if (CountryDAO.CountryExists(Country.getCode())) {
    	   return false;
       } else {
    	   CountryDAO.addCountry(Country);
    	   return true;
       }
	}
	//@Override
	public void updateCountry(Country Country) {
		CountryDAO.updateCountry(Country);
	}
	//@Override
	public void deleteCountry(String CountryId) {
		CountryDAO.deleteCountry(CountryId);
	}
	//@Override
	public List<Country> getCountryBySearch(String search){
		return CountryDAO.getCountryBySearch(search);
	}
}
