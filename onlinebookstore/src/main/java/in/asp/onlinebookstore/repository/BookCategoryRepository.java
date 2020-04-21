package in.asp.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import in.asp.onlinebookstore.entity.BookCategory;

//This annotation is used to override the path of the rest URL: 'bookCategories'
// 'collectionResourceRel' is to identify the JSON property, i.e. 'bookCategories'
@RepositoryRestResource(collectionResourceRel = "bookCategories", path = "book_category")
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long >{

}
