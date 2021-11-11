package iba.group.diplomAppStore.repository;

import iba.group.diplomAppStore.domain.OrderStamp;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderStamp, Long> {
}
