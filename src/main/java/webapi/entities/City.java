package webapi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CityId")
	private Integer cityId;
	@Column(name = "CityName")
	private String cityName;
	@Column(name = "FoundationDate")
	private Date foundationDate;
	@Column(name = "Area")
	private Double area;
	@Column(name = "Population")
	private Integer population;
	@ManyToOne
	@JoinColumn(name = "CountryId",referencedColumnName = "CountryId")
	private Country countryId;
	
	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(Integer cityId, String cityName, Date foundationDate, Double area, Integer population,
			Country countryId) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.foundationDate = foundationDate;
		this.area = area;
		this.population = population;
		this.countryId = countryId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Date getFoundationDate() {
		return foundationDate;
	}

	public void setFoundationDate(Date foundationDate) {
		this.foundationDate = foundationDate;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Country getCountryId() {
		return countryId;
	}

	public void setCountryId(Country countryId) {
		this.countryId = countryId;
	}
	
	
}
