package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.CityDAO;
import com.concretepage.entity.City;
@Service
public class CityService {
	@Autowired
	private CityDAO CityDAO;
	//@Override
	public City getCityById(Integer CityId) {
		City obj = CityDAO.getCityById(CityId);
		return obj;
	}	
	//@Override
	public List<City> getAllCitys(){
		return CityDAO.getAllCitys();
	}
	//@Override
	public synchronized boolean addCity(City City){
       if (CityDAO.CityExists(City.getID())) {
    	   return false;
       } else {
    	   CityDAO.addCity(City);
    	   return true;
       }
	}
	//@Override
	public void updateCity(City City) {
		CityDAO.updateCity(City);
	}
	//@Override
	public void deleteCity(Integer CityId) {
		CityDAO.deleteCity(CityId);
	}
	//@Override
	public List<City> getCityBySearch(String search){
		return CityDAO.getCityBySearch(search);
	}
}
