package iba.group.diplomAppStore.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Data
public class Catalog {

    List <Stamp> stamps = new ArrayList<>();
}
