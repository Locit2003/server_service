package webapi.entities.dto;



public class CountryDTO {
	private String countryId;
	private String countryName;
	
	public CountryDTO() {
		// TODO Auto-generated constructor stub
	}

	public CountryDTO(String countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
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
	
	
}
