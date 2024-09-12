package ua.lviv.iot.controller.entites;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.entities.LoaderDao;
import ua.lviv.iot.models.entity.address.FullAddress;
import ua.lviv.iot.models.entity.loader.Loader;

public class LoaderController extends GeneralController<Loader, Integer> {
    public LoaderController() {
        super(new LoaderDao());
    }

    @Override
    public Loader createNewEntity() {
        Loader newLoader = new Loader();
        System.out.println("Enter Loader name:");
        newLoader.setName(input.nextLine());
        System.out.println("Enter Loader surname:");
        newLoader.setSurname(input.nextLine());
        System.out.println("Enter Loader mobile phone:");
        newLoader.setMobilePhone(input.nextLine());
        System.out.println("Enter Loader email:");
        newLoader.setEmail(input.nextLine());
        System.out.println("Enter Loader company:");
        newLoader.setCompany(input.nextLine());
        System.out.println("Enter Loader address id:");
        String id = input.nextLine();
        try {
            FullAddressController fullAddressController= new FullAddressController();
            FullAddress attachedAddress = fullAddressController.getById(id);
            newLoader.setFullAddress(attachedAddress);
        }
        catch (Exception e) {
            System.out.println("An error occurred during setting address id: " + e.getMessage());
            return null;
        }
        return newLoader;
    }

    @Override
    public Loader createUpdEntity(String stringId) {
        Integer id = Integer.parseInt(stringId);
        Loader updatedLoader =  createNewEntity();
        if (updatedLoader != null) {
            updatedLoader.setId(id);
            return updatedLoader;
        }
        return null;
    }
}
