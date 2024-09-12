package ua.lviv.iot.models.entity.snack;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "snack")
public class Snack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "trademark", nullable = false, length = 45)
    @NotNull
    private String trademark;

    @Column(name = "snack_type", nullable = false, length = 45)
    @NotNull
    private String type;

    @Column(name = "price", nullable = false)
    @NotNull
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "snack_producer_id", referencedColumnName = "id", nullable = false)
    private SnackProducer snackProducer;

    @Override
    public String toString() {
        return String.format("Id: %2d, Snack: %s, type: %s, price: %sc, producer: %s",
                id,
                trademark,
                type,
                price,
                snackProducer.getName()
        );
    }
}
