package iba.group.diplomAppStore.repository;

import iba.group.diplomAppStore.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
