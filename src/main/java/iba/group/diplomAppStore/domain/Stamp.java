package iba.group.diplomAppStore.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Stamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String theme;
    private String description;
    private String image;
    private Integer year;
    private Double price;
    private Integer quantity;
    private Integer orderedQuantity;
}
