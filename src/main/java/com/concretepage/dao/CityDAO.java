package com.concretepage.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.City;;

@Transactional
@Repository
public class CityDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	//@Override
	public City getCityById(Integer ID) {
		return entityManager.find(City.class, ID);
	}
	@SuppressWarnings("unchecked")
	//@Override
	public List<City> getAllCitys() {
		String hql = "FROM City as tb ORDER BY tb.ID";
		return (List<City>) entityManager.createQuery(hql).getResultList();
	}	
	//@Override
	public void addCity(City City) {
		entityManager.persist(City);
	}
	//@Override
	public void updateCity(City City) {
		City cnt = getCityById(City.getID());
		cnt.setName(City.getName());
		cnt.setCountryCode(City.getCountryCode());
		cnt.setDistrict(City.getDistrict());
		cnt.setPopulation(City.getPopulation());
		entityManager.flush();
	}
	//@Override
	public void deleteCity(Integer CityID) {
		entityManager.remove(getCityById(CityID));
	}
	//@Override
	public boolean CityExists(Integer CityID) {
		String hql = "FROM City as tb WHERE tb.ID = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, CityID)
		             .getResultList().size();
		return count > 0 ? true : false;
	}
	@SuppressWarnings("unchecked")
	//@Override
	public List<City> getCityBySearch(String search) {
		if(search != null && search.length() > 0) {
		String hql = "FROM City as tb where tb.CountryCode LIKE '"+search+"%' or tb.Name LIKE '"+search+"%' ORDER BY tb.ID";  
		return (List<City>) entityManager.createQuery(hql).getResultList();
		} else {
		return getAllCitys() ;
		}
	}
}
