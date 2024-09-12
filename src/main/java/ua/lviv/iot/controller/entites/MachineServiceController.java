package ua.lviv.iot.controller.entites;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.entities.MachineServiceDao;
import ua.lviv.iot.models.entity.snack.Snack;
import ua.lviv.iot.models.entity.snack.SnackProducer;
import ua.lviv.iot.models.entity.snackmachine.MachineProducer;
import ua.lviv.iot.models.entity.snackmachine.MachineService;
import ua.lviv.iot.models.entity.snackmachine.SnackMachine;

import java.time.LocalDate;

public class MachineServiceController extends GeneralController<MachineService, Integer> {
    public MachineServiceController() {
        super(new MachineServiceDao());
    }

    @Override
    public MachineService createNewEntity() {
        MachineService newMachineService = new MachineService();
        System.out.println("Enter Snack machine id:");
        Integer id = Integer.parseInt(input.nextLine());
        newMachineService.setMachineId(id);
        try {
            SnackMachineController snackMachineController = new SnackMachineController();
            SnackMachine attachedSnackMachine = snackMachineController.getById(id.toString());
            newMachineService.setSnackMachine(attachedSnackMachine);
        }
        catch (Exception e) {
            System.out.println("An error occurred during setting snack machine id: " + e.getMessage());
            return null;
        }
        return newMachineService;
    }

    @Override
    public MachineService createUpdEntity(String stringId) {
        MachineService updatedMachineService = new MachineService();
        Integer id = Integer.parseInt(stringId);
        try {
            SnackMachineController snackMachineController = new SnackMachineController();
            SnackMachine attachedSnackMachine = snackMachineController.getById(id.toString());
            updatedMachineService.setSnackMachine(attachedSnackMachine);
        }
        catch (Exception e) {
            System.out.println("An error occurred during setting snack machine id: " + e.getMessage());
            updatedMachineService = null;
        }
        if (updatedMachineService != null) {
            updatedMachineService.setMachineId(id);
            System.out.println("Enter last load date");
            updatedMachineService.setLastLoad(LocalDate.parse(input.nextLine()));
            System.out.println("Enter last cash gathering date");
            updatedMachineService.setLastCashGathering(LocalDate.parse(input.nextLine()));
            System.out.println("Enter gathered cash:");
            updatedMachineService.setGatheredCash(Integer.parseInt(input.nextLine()));
        }
        return null;
    }
}
