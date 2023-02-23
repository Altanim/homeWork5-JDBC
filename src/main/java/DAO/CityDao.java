package DAO;

import model.City;

import java.util.List;

public interface CityDao {

    List<City> getAllCity();

    City getCityById(long id);

    void createCity(City city);

    void updateCity(City city);

    void deleteCityById(long id);
}
