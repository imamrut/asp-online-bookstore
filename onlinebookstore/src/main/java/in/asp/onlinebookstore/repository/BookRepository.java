 package in.asp.onlinebookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import in.asp.onlinebookstore.entity.Book;

/* This annotation is used to fix the error created by CORS policy. 
 * If the request is from different host then you will get CORS error.
 * For our current requirement we have only one different host so we are specifying the URl, 
 * but in real time project we will have multiple. That is maintained by ',' separator or just '*'.
 * @CrossOrigin("http://localhost:4200"), for now we are not using as we have configured for common CORS policy in 'RepositoryConfig' class*/
public interface BookRepository extends JpaRepository<Book, Long>{
	
	// To change the segment of the URL under which this query method is exposed, you can use the '@RestResource' annotation.
	@RestResource(path = "categoryId")
	Page<Book> findByCategoryId(@Param("id") Long id, Pageable pageable);

}
