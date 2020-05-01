import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Book } from '../common/book';
import { BookCategory } from '../common/book-category';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = "http://localhost:8080/api/v1/books";
  private categoryUrl = "http://localhost:8080/api/v1/book_category";

  constructor(private httpClient: HttpClient) { }

  getBooks(theCategoryId: number): Observable<Book[]> {
    const searchUrl: string = `${this.baseUrl}/search/categoryId?id=${theCategoryId}`;

    return this.getBookList(searchUrl);
  }

  getBookCategories(): Observable<BookCategory[]> {
    return this.httpClient.get<GetResponseBookCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.bookCategories)
    );
  }

  searchBooks(keyword: string): Observable<Book[]> {
    const searchUrl: string = `${this.baseUrl}/search/searchbykeyword?name=${keyword}`;

    return this.getBookList(searchUrl);
  }

  private getBookList(searchUrl: string): Observable<Book[]> {
    return this.httpClient.get<GetResponseBooks>(searchUrl).pipe(map(response => response._embedded.books));
  }

}

//This interface will help extract 'books' property from '_embedded' properties of 'baseUrl'
interface GetResponseBooks {
  _embedded: {
    books: Book[];
  }
}

//This interface will help extract 'bookCategory' property from '_embedded' properties of 'categoryUrl'
interface GetResponseBookCategory {
  _embedded: {
    bookCategories: BookCategory[];
  }
}
