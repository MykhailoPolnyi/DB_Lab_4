package ua.lviv.iot.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.models.domain.address.City;


@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
