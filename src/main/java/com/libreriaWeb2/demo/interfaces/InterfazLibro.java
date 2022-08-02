package com.libreriaWeb2.demo.interfaces;

import com.libreriaWeb2.demo.entidad.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazLibro extends CrudRepository<Libro, String>{
    
}
