package iba.group.diplomAppStore.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;
@Data
public class Cart {
    List<Stamp> stamps;
}
