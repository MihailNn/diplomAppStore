package iba.group.diplomAppStore.model;

import lombok.Data;

//import javax.persistence.Entity;
//import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
//    @Id
    private String id;
    private double sum;

    private List<Stamp> stamps = new ArrayList<>();

    public void addStamp(Stamp stamp) {
        this.stamps.add(stamp);
    }

}
