 package in.asp.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import in.asp.onlinebookstore.entity.Book;

// This annotation is used to fix the error created by CORS policy. 
// If the request is from different host then you will get CORS error.
// For our current requirement we have only one different host so we are specifying the URl, 
// but in real time project we will have multiple. That is maintained by ',' separator or just '*'.
@CrossOrigin("http://localhost:4200")
public interface BookRepository extends JpaRepository<Book, Long>{

}
