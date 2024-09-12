package ua.lviv.iot.models.entity.snackmachine;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name = "machine_model")
public class MachineModel {
    @Id
    @Column(name = "model", length = 50)
    private String model;

    @Column(name = "max_capacity", nullable = false)
    @NotNull
    private Integer capacity;

    @Column(name = "electricity_consumption_wh", nullable = false)
    @NotNull
    private Integer electricityConsumption;

    @ManyToMany(mappedBy = "producedMachineModels")
    private Set<MachineProducer> machineProducers;

    @Override
    public String toString() {
        return String.format("Model: %s, capacity: %s, electricity consumption: %s wh",
                model,
                capacity,
                electricityConsumption
        );
    }
}
