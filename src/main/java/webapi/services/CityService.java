package webapi.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import webapi.dao.CityDAOImpl;
import webapi.dao.CountryDAOImpl;
import webapi.entities.City;
import webapi.entities.Country;
import webapi.entities.dto.CityDTO;
import webapi.entities.dto.CountryDTO;

@Path(value = "/cityService")
public class CityService {
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListCities() {
		List<City> listCitites = new CityDAOImpl().getListCitites();
		Gson son = new Gson();
		List<CityDTO> listData = new ArrayList<CityDTO>();
		for (City c : listCitites) {
			CityDTO cdto = new CityDTO(c.getCityId(), c.getCountryId().getCountryId(), c.getCityName(),
					c.getFoundationDate(), c.getArea(), c.getPopulation());
			listData.add(cdto);
		}
		String data = son.toJson(listData);
		return data;
	}
	
	@GET
	@Path("/getCountry")
	@Produces(MediaType.APPLICATION_JSON)
	public String getList() {
		List<Country> listDataCountry = new CountryDAOImpl().getList();
		Gson son = new Gson();
		List<CountryDTO> listData = new ArrayList<CountryDTO>();
		for (Country c : listDataCountry) {
			CountryDTO cdto = new CountryDTO(c.getCountryId(), c.getCountryName());
			listData.add(cdto);
		}
		String data = son.toJson(listData);
		return data;
	}
	
	@GET
	@Path("/{cityId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCityById(@PathParam("cityId")Integer cityId) {
		City city = new CityDAOImpl().getCityById(cityId);
		CityDTO listData = new CityDTO(city.getCityId(),city.getCountryId().getCountryId(), city.getCityName(),city.getFoundationDate(), city.getArea(), city.getPopulation());
		Gson son = new Gson();
		String data = son.toJson(listData);
		return data;
	}

	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertCity(String c) {
		Gson son = new Gson();
		CityDTO objDTO = son.fromJson(c, CityDTO.class);
		Country objCountry = new Country();
		objCountry.setCountryId(objDTO.getCountryId());
		City objCity = new City(0, objDTO.getCityName(), objDTO.getFoundationDate(), objDTO.getArea(),
				objDTO.getPopulation(), objCountry);
		boolean bl = new CityDAOImpl().insertCity(objCity);
		String data = son.toJson(bl);
		return data;
	}

	@PUT
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateCity(String c) {
		Gson son = new Gson();
		CityDTO objDTO = son.fromJson(c, CityDTO.class);
		Country objCountry = new Country();
		objCountry.setCountryId(objDTO.getCountryId());
		City objCity = new City(objDTO.getCityId(), objDTO.getCityName(), objDTO.getFoundationDate(), objDTO.getArea(),
				objDTO.getPopulation(), objCountry);
		boolean bl = new CityDAOImpl().updateCity(objCity);
		String data = son.toJson(bl);
		return data;
	}

	@DELETE
	@Path("/{cityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCity(@PathParam("cityId") Integer cityId) {
		Gson son = new Gson();
		boolean bl = new CityDAOImpl().deleteCity(cityId);
		String data = son.toJson(bl);
		return data;
	}

	@GET
	@Path("/getCitiesByCountryName/{countryName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCitiesByCountryName(@PathParam("countryName") String countryName) {
		List<City> listCitites = new CityDAOImpl().getCitiesByCountryName(countryName);
		Gson son = new Gson();
		List<CityDTO> listData = new ArrayList<CityDTO>();
		for (City c : listCitites) {
			CityDTO cdto = new CityDTO(c.getCityId(), c.getCountryId().getCountryId(), c.getCityName(),
					c.getFoundationDate(), c.getArea(), c.getPopulation());
			listData.add(cdto);
		}
		String data = son.toJson(listData);
		return data;
	}
}
