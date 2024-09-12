package ua.lviv.iot.models.entity.address;

import lombok.Data;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    @NotNull
    private String name;

    @Column(name = "region", nullable = false, length = 45)
    @NotNull
    private String region;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;

    @Override
    public String toString() {
        return String.format("City id: %2d, City: %s, Region: %s, %s", id, name, region, country.toString());
    }
}
