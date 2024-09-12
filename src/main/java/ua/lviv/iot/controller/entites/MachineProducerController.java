package ua.lviv.iot.controller.entites;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.entities.MachineProducerDao;
import ua.lviv.iot.models.entity.address.City;
import ua.lviv.iot.models.entity.address.Country;
import ua.lviv.iot.models.entity.address.FullAddress;
import ua.lviv.iot.models.entity.snackmachine.MachineProducer;

public class MachineProducerController extends GeneralController<MachineProducer, Integer> {
    public MachineProducerController() {
        super(new MachineProducerDao());
    }

    @Override
    public MachineProducer createNewEntity() {
        MachineProducer newMachineProducer = new MachineProducer();
        System.out.println("Enter Machine producer name:");
        newMachineProducer.setName(input.nextLine());
        System.out.println("Enter Machine producer email:");
        newMachineProducer.setEmail(input.nextLine());
        System.out.println("Enter Machine producer mobile phone:");
        newMachineProducer.setMobilePhone(input.nextLine());
        System.out.println("Enter Machine producer address id:");
        String id = input.nextLine();
        try {
            FullAddressController fullAddressController = new FullAddressController();
            FullAddress attachedFullAddress = fullAddressController.getById(id);
            newMachineProducer.setFullAddress(attachedFullAddress);
        }
        catch (Exception e) {
            System.out.println("An error occurred during setting city id: " + e.getMessage());
            return null;
        }
        return newMachineProducer;
    }

    @Override
    public MachineProducer createUpdEntity(String stringId) {
        Integer id = Integer.parseInt(stringId);
        MachineProducer updatedMachineProducer =  createNewEntity();
        if (updatedMachineProducer != null) {
            updatedMachineProducer.setId(id);
            return updatedMachineProducer;
        }
        return null;
    }
}
