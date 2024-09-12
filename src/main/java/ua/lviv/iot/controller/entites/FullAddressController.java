package ua.lviv.iot.controller.entites;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.entities.FullAddressDao;
import ua.lviv.iot.models.entity.address.City;
import ua.lviv.iot.models.entity.address.FullAddress;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class FullAddressController extends GeneralController<FullAddress, Integer> {
    public FullAddressController() {
        super(new FullAddressDao());
    }

    @Override
    public FullAddress createNewEntity() {
        FullAddress newFullAddress = new FullAddress();
        System.out.println("Enter Street name:");
        newFullAddress.setStreet(input.nextLine());
        System.out.println("Enter Street number:");
        newFullAddress.setNumber(input.nextLine());
        System.out.println("Enter City id:");
        String cityId = input.nextLine();
        try {
            CityController cityController = new CityController();
            City attachedCity = cityController.getById(cityId);
            newFullAddress.setCity(attachedCity);
        }
        catch (Exception e) {
            System.out.println("An error occurred during setting City id: " + e.getMessage());
            return null;
        }
        return newFullAddress;
    }

    @Override
    public FullAddress createUpdEntity(String stringId){
        Integer id = Integer.parseInt(stringId);
        FullAddress updatedAddress = createNewEntity();
        if (updatedAddress != null) {
            updatedAddress.setId(id);
            return updatedAddress;
        }
        return null;
    }
}
