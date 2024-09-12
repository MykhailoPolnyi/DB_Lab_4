package ua.lviv.iot.models.entity.address;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "full_adress")
public class FullAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "street", length = 45)
    private String street;

    @Column(name = "number", length = 45)
    private String number;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City city;

    @Override
    public String toString() {
        return String.format(
                "Address id: %2d, Street: %s, %s, %s",
                id,
                (street != null ? street : "unknown"),
                (number != null ? number : "-"),
                city.toString()
        );
    }
}
