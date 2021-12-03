package iba.group.diplomAppStore.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Data
@Component
@SessionScope
@NoArgsConstructor
public class Cart {
    Set<Stamp> stamps = new HashSet<>();

}
