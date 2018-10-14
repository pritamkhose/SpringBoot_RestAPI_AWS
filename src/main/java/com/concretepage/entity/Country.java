package com.concretepage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="country")
public class Country {
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="code")
    private String Code;  
	@Column(name="name")
    private String Name;
	@Column(name="continent")	
	private String Continent;
	
	@Column(name="region")	
	private String Region;
	@Column(name="surfacearea")
    private Float SurfaceArea;  
	//@Column(name="indepyear" ,nullable = false)
	@Column(name = "indepyear", unique = true, nullable = false)
    private Integer IndepYear;  
	
	@Column(name="population")	
	private double Population;
	@Column(name="lifeexpectancy")
    private Float LifeExpectancy;  
	@Column(name="gnp")
    private Float GNP;  
	@Column(name="gnpold")
    private Float GNPOld;  

	@Column(name="localname")	
	private String LocalName;
	
	@Column(name="govform")	
	private String GovernmentForm; 
	@Column(name="headofstate")	
	private String HeadOfState;
	@Column(name="capital")
    private Integer Capital;  
	@Column(name="code2")	
	private String Code2;
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContinent() {
		return Continent;
	}
	public void setContinent(String continent) {
		Continent = continent;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public Float getSurfaceArea() {
		return SurfaceArea;
	}
	public void setSurfaceArea(Float surfaceArea) {
		SurfaceArea = surfaceArea;
	}
	public Integer getIndepYear() {
		 return IndepYear;
	}
	public void setIndepYear(Object indepYear) {
		if (indepYear != null) {
			IndepYear = (Integer) indepYear;
		}
		else {
			IndepYear = 0;
		}
	}
	public double getPopulation() {
		return Population;
	}
	public void setPopulation(double population) {
		Population = population;
	}
	public Float getLifeExpectancy() {
		return LifeExpectancy;
	}
	public void setLifeExpectancy(Float lifeExpectancy) {
		LifeExpectancy = lifeExpectancy;
	}
	public Float getGNP() {
		return GNP;
	}
	public void setGNP(Float gNP) {
		GNP = gNP;
	}
	public Float getGNPOld() {
		return GNPOld;
	}
	public void setGNPOld(Float gNPOld) {
		GNPOld = gNPOld;
	}
	public String getLocalName() {
		return LocalName;
	}
	public void setLocalName(String localName) {
		LocalName = localName;
	}
	public String getGovernmentForm() {
		return GovernmentForm;
	}
	public void setGovernmentForm(String governmentForm) {
		GovernmentForm = governmentForm;
	}
	public String getHeadOfState() {
		return HeadOfState;
	}
	public void setHeadOfState(String headOfState) {
		HeadOfState = headOfState;
	}
	public Integer getCapital() {
		return Capital;
	}
	public void setCapital(Integer capital) {
		Capital = capital;
	}
	public String getCode2() {
		return Code2;
	}
	public void setCode2(String code2) {
		Code2 = code2;
	}
}
