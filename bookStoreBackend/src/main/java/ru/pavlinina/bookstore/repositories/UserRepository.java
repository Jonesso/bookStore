package ru.pavlinina.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pavlinina.bookstore.models.User;

/**
 * @author Sofia Pavlinina
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
