package ua.lviv.iot.models.entity.address;

import lombok.Data;

import javax.persistence.*;


import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    @NotNull
    private String name;

    @Override
    public String toString() {
        return String.format("Country id: %2d, Country: %s", id, name);
    }
}
