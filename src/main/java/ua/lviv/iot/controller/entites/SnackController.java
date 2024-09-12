package ua.lviv.iot.controller.entites;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.entities.SnackDao;
import ua.lviv.iot.models.entity.address.City;
import ua.lviv.iot.models.entity.address.Country;
import ua.lviv.iot.models.entity.snack.Snack;
import ua.lviv.iot.models.entity.snack.SnackProducer;

public class SnackController extends GeneralController<Snack, Integer> {
    public SnackController() {
        super(new SnackDao());
    }

    @Override
    public Snack createNewEntity() {
        Snack newSnack = new Snack();
        System.out.println("Enter Snack trademark:");
        newSnack.setTrademark(input.nextLine());
        System.out.println("Enter Snack type:");
        newSnack.setType(input.nextLine());
        System.out.println("Enter Snack price:");
        newSnack.setPrice(Integer.parseInt(input.nextLine()));
        System.out.println("Enter Snack producer id:");
        String id = input.nextLine();
        try {
            SnackProducerController snackProducerController = new SnackProducerController();
            SnackProducer attachedSnackProducer = snackProducerController.getById(id);
            newSnack.setSnackProducer(attachedSnackProducer);
        }
        catch (Exception e) {
            System.out.println("An error occurred during setting city id: " + e.getMessage());
            return null;
        }
        return newSnack;
    }

    @Override
    public Snack createUpdEntity(String stringId) {
        Integer id = Integer.parseInt(stringId);
        Snack updatedSnack =  createNewEntity();
        if (updatedSnack != null) {
            updatedSnack.setId(id);
            return updatedSnack;
        }
        return null;
    }
}
