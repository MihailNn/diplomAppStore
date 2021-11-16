package iba.group.diplomAppStore.repository;

import iba.group.diplomAppStore.domain.StampOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<StampOrder, Long> {
}
