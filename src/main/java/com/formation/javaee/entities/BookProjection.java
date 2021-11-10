package com.formation.javaee.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "b1",types = Book.class)
public interface BookProjection {
    public double getPrix();

}
