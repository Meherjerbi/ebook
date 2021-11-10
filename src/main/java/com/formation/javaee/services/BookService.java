package com.formation.javaee.services;

import com.formation.javaee.entities.Book;
import com.formation.javaee.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class BookService {
    @Autowired
    BookRepository bookRepository;
    public Book addBook(Book b){
        return bookRepository.save(b);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(long id){
        return  bookRepository.findById(id).get();
    }
    public Book getBookByNom(String nom){
        return  bookRepository.findByNameBook(nom);
    }
    public Book updateBook(Book b){
       Book book=getBookById(b.getId());
       book.setAuteur(b.getAuteur());
       book.setDescription(b.getDescription());
       book.setIsbn(b.getIsbn());
       book.setNameBook(b.getNameBook());
       book.setPrix(b.getPrix());
       book.setPhoto(b.getPhoto());
       book.setNote(b.getNote());
       return bookRepository.save(book);
    }
    public void deletBook(long id){
        Book b=getBookById(id);
        bookRepository.delete(b);
    }

}
