package iba.group.diplomAppStore.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class OrderStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long CustomerId;
    private double sum;
    private Date placedAt = new Date();
    @OneToMany
    private List<Stamp> stamps = new ArrayList<>();

//    public void addStamp(Stamp stamp) {
//        this.stamps.add(stamp);
//    }

}
