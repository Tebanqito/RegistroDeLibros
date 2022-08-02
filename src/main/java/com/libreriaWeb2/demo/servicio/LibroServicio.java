package com.libreriaWeb2.demo.servicio;

import com.libreriaWeb2.demo.entidad.Libro;
import com.libreriaWeb2.demo.interfaceService.ILibroServicio;
import com.libreriaWeb2.demo.interfaces.InterfazLibro;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio implements ILibroServicio {

    @Autowired
    private InterfazLibro interfazLibro;


    @Override
    public List<Libro> listar() {
        return (List<Libro>) interfazLibro.findAll();
    }

    @Override
    public Optional<Libro> listarId(String id) {
        return interfazLibro.findById(id);
    }

    @Override
    public int save(Libro l) {
        int res = 0;
        // persisto el libro l en la base de datos y se lo asigno al objeto libro
        Libro libro = interfazLibro.save(l);
        // compruebo que el libro se haya persistido en la base de datos
        if(!libro.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(String id) {
        interfazLibro.deleteById(id);
    }

    @Override
    public int edit(Libro l) {
        return save(l);
    }
    

}
