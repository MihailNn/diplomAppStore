package iba.group.diplomAppStore.model;

import lombok.Data;
//import javax.persistence.Entity;
//import javax.persistence.Id;


@Data
public class Stamp {
//    @Id
    private String id;
    private String country;
    private String theme;
    private String description;
    private String code;
    private int year;
    private double price;
}
