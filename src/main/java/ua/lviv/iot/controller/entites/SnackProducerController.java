package ua.lviv.iot.controller.entites;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.entities.SnackProducerDao;
import ua.lviv.iot.models.entity.address.City;
import ua.lviv.iot.models.entity.address.Country;
import ua.lviv.iot.models.entity.address.FullAddress;
import ua.lviv.iot.models.entity.snack.SnackProducer;

public class SnackProducerController extends GeneralController<SnackProducer, Integer> {
    public SnackProducerController() {
        super(new SnackProducerDao());
    }

    @Override
    public SnackProducer createNewEntity() {
        SnackProducer newSnackProducer = new SnackProducer();
        System.out.println("Enter Snack producer name:");
        newSnackProducer.setName(input.nextLine());
        System.out.println("Enter Snack producer email:");
        newSnackProducer.setEmail(input.nextLine());
        System.out.println("Enter Snack producer phone:");
        newSnackProducer.setMobilePhone(input.nextLine());
        System.out.println("Enter Snack producer address id:");
        String id = input.nextLine();
        try {
            FullAddressController fullAddressController = new FullAddressController();
            FullAddress attachedFullAddress = fullAddressController.getById(id);
            newSnackProducer.setFullAddress(attachedFullAddress);
        }
        catch (Exception e) {
            System.out.println("An error occurred during setting city id: " + e.getMessage());
            return null;
        }
        return newSnackProducer;
    }

    @Override
    public SnackProducer createUpdEntity(String stringId) {
        Integer id = Integer.parseInt(stringId);
        SnackProducer updatedSnackProducer =  createNewEntity();
        if (updatedSnackProducer != null) {
            updatedSnackProducer.setId(id);
            return updatedSnackProducer;
        }
        return null;
    }
}
