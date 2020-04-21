 package in.asp.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.asp.onlinebookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
