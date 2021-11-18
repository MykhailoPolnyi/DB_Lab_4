package ua.lviv.iot.models.entity.snackmachine;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "machine_service")
public class MachineService {

    @Id
    @Column(name = "snack_machine_id")
    private Integer machineId;

    @Column(name = "last_load")
    private LocalDate lastLoad;

    @Column(name = "last_cash_gathering")
    private LocalDate lastCashGathering;

    @Column(name = "gathered_cash")
    private Integer gatheredCash;

    @Column(name = "last_coint_load")
    private LocalDate lastCoinLoad;

    @Column(name = "loaded_coins")
    private Integer loadedCoins;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "snack_machine_id", referencedColumnName = "id")
    private SnackMachine snackMachine;

    @Override
    public String toString() {
        return String.format(
                "Machine id: %s, last load: %s, cash gathering: %s, gathered: %s c, coins load: %s, loaded: %s c",
                machineId,
                (lastLoad != null ? lastLoad.toString() : "-"),
                (lastCashGathering != null ? lastCashGathering.toString() : "-"),
                (gatheredCash != null ? gatheredCash : "0"),
                (lastCoinLoad != null ? lastCoinLoad : "-"),
                (loadedCoins != null ? loadedCoins : "0")

        );
    }
}
