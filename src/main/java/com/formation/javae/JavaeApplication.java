package com.formation.javae;

import com.formation.javaee.entities.Book;
import com.formation.javaee.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("com.formation.javaee.entities")
@EnableJpaRepositories("com.formation.javaee.repositories")
@ComponentScan("com.formation.javaee")


public class JavaeApplication implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
   // private RepositoryRestConfiguration controllerConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(JavaeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //controllerConfiguration.exposeIdsFor(Book.class);
        bookRepository.save(new Book(null, "nameBook", "isbn", "auteur", "description", 16, "photo", 15));
        bookRepository.findById(1L);


    }
}
