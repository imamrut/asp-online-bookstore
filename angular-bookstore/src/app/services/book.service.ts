import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Book } from '../common/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = "http://localhost:8080/api/v1/books";

  constructor(private httpClient: HttpClient) { }

  getBooks(): Observable<Book[]> {
    return this.httpClient.get<GetResponseBooks>(this.baseUrl).pipe(
      map(response => response._embedded.books)
    );
  }

}

//This interface will help extract 'books' property from '_embedded' properties of 'baseUrl'
interface GetResponseBooks {
  _embedded: {
    books: Book[];
  }
}
