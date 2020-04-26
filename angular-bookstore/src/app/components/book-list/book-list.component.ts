import { Book } from './../../common/book';
import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/services/book.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-list',
  // templateUrl: './book-list.component.html',
  templateUrl: './book-grid.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[];
  currentCategoryId: number;

  constructor(private _bookService: BookService, 
              private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {

    this._activatedRoute.paramMap.subscribe(() => {
      this.listBooks();
    })

  }

  listBooks() {
    // making use of 'snapshot' approach
    const hasCategoryId: boolean = this._activatedRoute.snapshot.paramMap.has('id');

    if(hasCategoryId) {
      // '+' operator is to convert the value to 'number' type
      this.currentCategoryId = +this._activatedRoute.snapshot.paramMap.get('id');
    }
    else {
      this.currentCategoryId = 1;
    }

    this._bookService.getBooks(this.currentCategoryId).subscribe(
      data => this.books = data
    )
  }

}
