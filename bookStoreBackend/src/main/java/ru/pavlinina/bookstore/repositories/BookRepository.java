package ru.pavlinina.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavlinina.bookstore.models.Book;

/**
 * @author Sofia Pavlinina
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
