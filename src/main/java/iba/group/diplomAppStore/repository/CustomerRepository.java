package iba.group.diplomAppStore.repository;

import iba.group.diplomAppStore.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<User, Long> {
}
