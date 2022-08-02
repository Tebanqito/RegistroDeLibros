package com.libreriaWeb2.demo.interfaceService;

import com.libreriaWeb2.demo.entidad.Libro;
import java.util.List;
import java.util.Optional;

public interface ILibroServicio {
    public List<Libro> listar();
    public Optional<Libro> listarId(String id);
    public int save(Libro l);
    public void  delete(String id);
    public int edit(Libro l);
}
