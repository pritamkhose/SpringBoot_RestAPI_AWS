package com.concretepage.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Country;;

@Transactional
@Repository
public class CountryDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	//@Override
	public Country getCountryById(String CountryCode) {
		return entityManager.find(Country.class, CountryCode);
	}
	@SuppressWarnings("unchecked")
	//@Override
	public List<Country> getAllCountrys() {
		String hql = "FROM Country as atcl ORDER BY atcl.Code";
		return (List<Country>) entityManager.createQuery(hql).getResultList();
	}	
	//@Override
	public void addCountry(Country Country) {
		String s = Country.getCode();
		if(!(s != null && s.length() > 0)) {
			Country.setCode(Country.getName());
		}
		entityManager.persist(Country);
	}
	//@Override
	public void updateCountry(Country Country) {
		Country cnt = getCountryById(Country.getCode());
		cnt.setName(Country.getName());
		cnt.setContinent(Country.getContinent());
		cnt.setRegion(Country.getRegion());
		cnt.setSurfaceArea(Country.getSurfaceArea());
		cnt.setIndepYear(Country.getIndepYear());
		cnt.setPopulation(Country.getPopulation());
		cnt.setLifeExpectancy(Country.getLifeExpectancy());
		cnt.setGNP(Country.getGNP());
		cnt.setGNPOld(Country.getGNPOld());
		cnt.setLocalName(Country.getLocalName());
		cnt.setGovernmentForm(Country.getGovernmentForm());
		cnt.setHeadOfState(Country.getHeadOfState());
		cnt.setCapital(Country.getCapital());
		cnt.setCode2(Country.getCode2());
		entityManager.flush();
	}
	//@Override
	public void deleteCountry(String CountryCode) {
		entityManager.remove(getCountryById(CountryCode));
	}
	//@Override
	public boolean CountryExists(String Code) {
		String hql = "FROM Country as atcl WHERE atcl.Code = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, Code)
		             .getResultList().size();
		return count > 0 ? true : false;
	}
	@SuppressWarnings("unchecked")
	//@Override
	public List<Country> getCountryBySearch(String search) {
		if(search != null && search.length() > 0) {
		String hql = "FROM Country as atcl where atcl.Code LIKE '"+search+"%' or atcl.Name LIKE '"+search+"%' ORDER BY atcl.Code";  
		return (List<Country>) entityManager.createQuery(hql).getResultList();
		} else {
		return getAllCountrys() ;
		}
	}
}
