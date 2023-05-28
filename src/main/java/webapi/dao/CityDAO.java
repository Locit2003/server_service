package webapi.dao;

import java.util.List;

import webapi.entities.City;

public interface CityDAO {
	public List<City> getListCitites();
	public City getCityById(Integer cityId);
	public boolean insertCity(City city);
	public boolean updateCity(City city);
	public boolean deleteCity(Integer cityId);
	public List<City> getCitiesByCountryName(String countryName);
}
