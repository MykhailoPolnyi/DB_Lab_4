package ua.lviv.iot.controller.entites;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.entities.SnackMachineDao;
import ua.lviv.iot.models.entity.address.City;
import ua.lviv.iot.models.entity.address.Country;
import ua.lviv.iot.models.entity.snackmachine.MachineModel;
import ua.lviv.iot.models.entity.snackmachine.MachineProducer;
import ua.lviv.iot.models.entity.snackmachine.SnackMachine;

public class SnackMachineController extends GeneralController<SnackMachine, Integer> {
    public SnackMachineController() {
        super(new SnackMachineDao());
    }

    @Override
    public SnackMachine createNewEntity() {
        SnackMachine newSnackMachine = new SnackMachine();
        System.out.println("Enter machine producer id:");
        String stringProducerId = input.nextLine();
        try {
            MachineProducerController machineProducerController = new MachineProducerController();
            MachineProducer attachedMachineProducer = machineProducerController.getById(stringProducerId);
            newSnackMachine.setMachineProducer(attachedMachineProducer);
        }
        catch (Exception e) {
            System.out.println("An error occurred during setting producer id: " + e.getMessage());
            return null;
        }
        System.out.println("Enter machine model id:");
        String stringModelId = input.nextLine();
        try {
            MachineModelController machineModelController = new MachineModelController();
            MachineModel attachedMachineModel = machineModelController.getById(stringModelId);
            newSnackMachine.setMachineModel(attachedMachineModel);
        }
        catch (Exception e) {
            System.out.println("An error occurred during setting model id: " + e.getMessage());
            return null;
        }
        MachineServiceController machineServiceController = new MachineServiceController();
        newSnackMachine.setMachineService(machineServiceController.createNewEntity());

        return newSnackMachine;
    }

    @Override
    public SnackMachine createUpdEntity(String stringId) {
        Integer id = Integer.parseInt(stringId);
        SnackMachine updatedSnackMachine =  createNewEntity();
        if (updatedSnackMachine != null) {
            updatedSnackMachine.setId(id);
            return updatedSnackMachine;
        }
        return null;
    }
}
