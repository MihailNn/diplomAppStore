package iba.group.diplomAppStore.repository;

import iba.group.diplomAppStore.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
