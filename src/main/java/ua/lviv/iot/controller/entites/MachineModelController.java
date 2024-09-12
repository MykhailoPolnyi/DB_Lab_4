package ua.lviv.iot.controller.entites;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.entities.MachineModelDao;
import ua.lviv.iot.models.entity.address.FullAddress;
import ua.lviv.iot.models.entity.loader.Loader;
import ua.lviv.iot.models.entity.snackmachine.MachineModel;
import ua.lviv.iot.models.entity.snackmachine.MachineService;

public class MachineModelController extends GeneralController<MachineModel, String> {
    public MachineModelController() {
        super(new MachineModelDao());
    }

    @Override
    public MachineModel createNewEntity() {
        MachineModel newMachineModel = new MachineModel();
        System.out.println("Enter Machine model:");
        newMachineModel.setModel(input.nextLine());
        System.out.println("Enter Machine max capacity:");
        newMachineModel.setCapacity(Integer.parseInt(input.nextLine()));
        System.out.println("Enter Machine electricity consumption(in wh):");
        newMachineModel.setElectricityConsumption(Integer.parseInt(input.nextLine()));
        return newMachineModel;
    }

    @Override
    public MachineModel createUpdEntity(String stringId) {
        MachineModel newMachineModel = new MachineModel();
        newMachineModel.setModel(stringId);
        System.out.println("Enter Machine max capacity:");
        newMachineModel.setCapacity(Integer.parseInt(input.nextLine()));
        System.out.println("Enter Machine electricity consumption(in wh):");
        newMachineModel.setElectricityConsumption(Integer.parseInt(input.nextLine()));
        return newMachineModel;
    }
}
