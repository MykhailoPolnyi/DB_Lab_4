package ua.lviv.iot.controller.entites;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.entities.CityDao;
import ua.lviv.iot.models.entity.address.City;
import ua.lviv.iot.models.entity.address.Country;

public class CityController extends GeneralController<City, Integer> {
    public CityController() {
        super(new CityDao());
    }

    @Override
    public City createNewEntity() {
        City newCity = new City();
        System.out.println("Enter City name:");
        newCity.setName(input.nextLine());
        System.out.println("Enter City region:");
        newCity.setRegion(input.nextLine());
        System.out.println("Enter City country id:");
        String id = input.nextLine();
        try {
            CountryController countryController = new CountryController();
            Country attachedCountry = countryController.getById(id);
            newCity.setCountry(attachedCountry);
        }
        catch (Exception e) {
            System.out.println("An error occurred during setting city id: " + e.getMessage());
            return null;
        }
        return newCity;
    }

    @Override
    public City createUpdEntity(String stringId) {
        Integer id = Integer.parseInt(stringId);
        City updatedCity =  createNewEntity();
        if (updatedCity != null) {
            updatedCity.setId(id);
            return updatedCity;
        }
        return null;
    }
}
