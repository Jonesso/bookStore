import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from '../model/User';
import {Book} from '../model/Book';

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient: HttpClient
  ) {}

  // tslint:disable-next-line:typedef
  getUsers()
  {
    return this.httpClient.get<User[]>('http://localhost:8080/users/get');
  }

  // tslint:disable-next-line:typedef
  addUser(newUser: User) {
    return this.httpClient.post<User>('http://localhost:8080/users/add', newUser);
  }

  // tslint:disable-next-line:typedef
  deleteUser(id) {
    return this.httpClient.delete<User>('http://localhost:8080/users/' + id);
  }

  // tslint:disable-next-line:typedef
  getBooks() {
    return this.httpClient.get<Book[]>('http://localhost:8080/books/get');
  }

  // tslint:disable-next-line:typedef
  addBook(newBook: Book) {
    return this.httpClient.post<Book>('http://localhost:8080/books/add', newBook);
  }

  // tslint:disable-next-line:typedef
  deleteBook(id) {
    return this.httpClient.delete<Book>('http://localhost:8080/books/' + id);
  }

  // tslint:disable-next-line:typedef
  updateBook(updatedBook: Book) {
    return this.httpClient.put<Book>('http://localhost:8080/books/update', updatedBook);
  }
}
