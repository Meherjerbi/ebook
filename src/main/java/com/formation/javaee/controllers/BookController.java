package com.formation.javaee.controllers;

import com.formation.javaee.entities.Book;
import com.formation.javaee.repositories.BookRepository;
import com.formation.javaee.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRep;

    //Ajouter un livre
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ResponseEntity<Book> ajoutBook(@RequestBody Book book) {
        return new ResponseEntity<Book>(bookRep.save(book), HttpStatus.OK);
    }

    // supprimer un livre
    @RequestMapping(value = "/suppression-livre/{id-livre}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable Long idBook) {
        Book b=bookRep.getById(idBook);
        bookRep.delete(b);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // rechercher un livre
    @GetMapping(value="/searchBook/{id}")
    public Book rechercheBook(@PathVariable(name = "id")Long id) {
        return bookRep.findById(id).get();
    }

    // modifier un livre
    @RequestMapping(value = "/updateBook", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable(name = "id") Long id,@RequestBody Book book) {
        bookRep.getById(id);
        return new ResponseEntity<Book>(bookRep.save(book), HttpStatus.OK);
    }

    // obtention de la liste des livres
    @GetMapping(value = "/allBooks")
    public List<Book> getBooks() {
        return bookRep.findAll();
    }

}
