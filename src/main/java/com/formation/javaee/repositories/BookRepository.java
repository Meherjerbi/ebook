package com.formation.javaee.repositories;

import com.formation.javaee.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book,Long> {
    @RestResource(path="/byName")
    public Book findByNameBook(@Param("nom") String nom);
    @RestResource(path="/byNameAuth")
    public List<Book> findByAuteur(@Param("nomAuteur")String nom);
    @RestResource(path="/byNameAuteur")
    public Page<Book> findByAuteur(@Param("nomAuteurP")String nom,Pageable pageable);

}
