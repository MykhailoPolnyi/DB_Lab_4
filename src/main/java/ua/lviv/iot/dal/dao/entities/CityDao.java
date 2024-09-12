package ua.lviv.iot.dal.dao.entities;

import ua.lviv.iot.dal.dao.GeneralDao;
import ua.lviv.iot.models.entity.address.City;

public class CityDao extends GeneralDao<City, Integer> {
    public CityDao() {
        super(City.class);
    }
}
