package ua.lviv.iot.controller.entites;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.entities.CountryDao;
import ua.lviv.iot.models.entity.address.Country;

public class CountryController extends GeneralController<Country, Integer> {
    public CountryController() {
        super(new CountryDao());
    }
}
