package webapi.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Country")
public class Country {
	@Id
	@Column(name = "CountryId")
	private String countryId;
	@Column(name = "CountrName")
	private String countryName;
	
	@OneToMany(mappedBy = "countryId", fetch = FetchType.EAGER)
	private List<City> listCity;
	
	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(String countryId, String countryName, List<City> listCity) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.listCity = listCity;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<City> getListCity() {
		return listCity;
	}

	public void setListCity(List<City> listCity) {
		this.listCity = listCity;
	}
	
}
