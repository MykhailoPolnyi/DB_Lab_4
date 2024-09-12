package ua.lviv.iot.models.entity.snack;

import lombok.Data;
import ua.lviv.iot.models.entity.address.FullAddress;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name = "snack_producer")
public class SnackProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    @NotNull
    private String name;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "mobile_phone", length = 12)
    private String mobilePhone;

    @ManyToOne
    @JoinColumn(name = "full_adress_id", referencedColumnName = "id", nullable = false)
    private FullAddress fullAddress;

    @OneToMany(mappedBy = "snackProducer")
    private Set<Snack> producedSnacks;

    @Override
    public String toString() {
        return String.format("Id: %2d, Producer: %s, email: %s, mobile phone: %s, %s",
                id,
                name,
                email,
                mobilePhone,
                fullAddress.toString()
        );
    }
}
