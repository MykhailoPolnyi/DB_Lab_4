package ua.lviv.iot.dal.dao.entities;

import ua.lviv.iot.dal.dao.GeneralDao;
import ua.lviv.iot.models.entity.address.Country;

public class CountryDao extends GeneralDao<Country, Integer> {
    public CountryDao() {
        super(Country.class);
    }
}
