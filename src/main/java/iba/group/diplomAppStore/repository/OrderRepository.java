package iba.group.diplomAppStore.repository;

import iba.group.diplomAppStore.domain.StampOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<StampOrder, Long> {
    List<StampOrder> findByUserId(Long userId);

}
