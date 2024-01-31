package oop1;

import java.util.HashMap;

//a) Generic Book class
public class Book<T, U> {
 // i) Properties
 private T bookTitle;
 private U bookISBN;

 // ii) Overloaded Constructor
 public Book(T bookTitle, U bookISBN) {
     this.bookTitle = bookTitle;
     this.bookISBN = bookISBN;
 }

 // iii) Getter method for ISBN
 public U getISBN() {
     return bookISBN;
 }
}

//b) Library class
class Library {
 public static void main(String[] args) {
     // i) Create a HashMap object called bookList
     HashMap<Integer, Book<String, Object>> bookList = new HashMap<>();

     // ii) Create and add the first Book object
     Book<String, Object> book1 = new Book<>("Harry Potter", "ISBN12345");
     bookList.put(1, book1);

     // iii) Create and add the second Book object
     Book<String, Object> book2 = new Book<>("Rings of Power", 123456);
     bookList.put(2, book2);

     // Iterate through the HashMap and display Book information
     for (int id : bookList.keySet()) {
         Book<String, Object> value = bookList.get(id);
         System.out.println("Book ID is: " + id + " and the ISBN is: " + value.getISBN());
     }
 }
}
