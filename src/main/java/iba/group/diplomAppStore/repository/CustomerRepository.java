package iba.group.diplomAppStore.repository;

import iba.group.diplomAppStore.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
