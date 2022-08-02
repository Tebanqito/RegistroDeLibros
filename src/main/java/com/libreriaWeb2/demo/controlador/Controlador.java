package com.libreriaWeb2.demo.controlador;

import com.libreriaWeb2.demo.entidad.Libro;
import com.libreriaWeb2.demo.servicio.LibroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private LibroServicio libroServicio;

    @GetMapping({"/listar", "/"})
    public String listarLibros(Model modelo) throws Exception {
        try {
            List<Libro> libros = libroServicio.listar();
            modelo.addAttribute("libros", libros);
            return "index";
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/listar/agregar")
    public String mostrarFormulario(Model model) throws Exception {
        try {
            model.addAttribute("libro", new Libro());
            return "formulario";
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("libro") Libro libro) throws Exception {
        try {
            libroServicio.save(libro);
            return "redirect:/listar";
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/listar/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model modelo) throws Exception {
        try {
            Libro libro = libroServicio.listarId(id).get();
            modelo.addAttribute("libro", libro);
            return "editarLibro";
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/listar/{id}")
    public String edit(@PathVariable String id, @ModelAttribute("libro") Libro libro, Model modelo) throws Exception {
        try {
            Libro libroExistente = libroServicio.listarId(id).get();

            libroExistente.setId(id);
            libroExistente.setIsbn(libro.getIsbn());
            libroExistente.setTitulo(libro.getTitulo());
            libroExistente.setEjemplares(libro.getEjemplares());
            libroExistente.setEjemplaresPrestados(libro.getEjemplaresPrestados());
            libroExistente.setEjemplaresRestantes(libro.getEjemplaresRestantes());
            libroExistente.setNombreAutor(libro.getNombreAutor());
            libroExistente.setNombreEditorial(libro.getNombreEditorial());

            libroServicio.edit(libroExistente);
            return "redirect:/listar";
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Model modelo, @PathVariable String id) throws Exception {
        try {
            libroServicio.delete(id);
            return "redirect:/listar";
        } catch (Exception e) {
            throw e;
        }
    }

}
