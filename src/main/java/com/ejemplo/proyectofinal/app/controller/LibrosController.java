package com.ejemplo.proyectofinal.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.proyectofinal.app.model.GeneroLibro;
import com.ejemplo.proyectofinal.app.model.Libro;

@Controller
@RequestMapping("/libros")
public class LibrosController {
	
	@Value("Libros")
	private String titulo;

	@ModelAttribute("libros")
	public List<Libro> listadoCompletoLibros() {
		List<Libro> libros = new ArrayList<>();
		libros.add(new Libro(1, "Cien años de soledad", "Gabriel García Márquez", 10, "Novela"));
		libros.add(new Libro(2, "El principito", "Antoine de Saint-Exupéry", 15, "Infantil"));
		libros.add(new Libro(3, "Harry Potter y la piedra filosofal", "J.K. Rowling", 20, "Ficcion"));
		libros.add(new Libro(4, "Don Quijote de la Mancha", "Miguel de Cervantes", 12, "Clasico"));
		libros.add(new Libro(5, "1984", "George Orwell", 8, "Ciencia Ficcion"));
		libros.add(new Libro(6, "Orgullo y prejuicio", "Jane Austen", 18, "Romance"));
		libros.add(new Libro(7, "El señor de los anillos", "J.R.R. Tolkien", 25, "Fantasia"));
		libros.add(new Libro(8, "Crónica de una muerte anunciada", "Gabriel García Márquez", 11,"Novela"));
		libros.add(new Libro(9, "La Odisea", "Homero", 14, "Clasico"));
		libros.add(new Libro(10, "Moby Dick", "Herman Melville", 9, "Aventura"));
		libros.add(new Libro(11, "La metamorfosis", "Franz Kafka", 16, "Ficcion"));
		libros.add(new Libro(12, "El gran Gatsby", "F. Scott Fitzgerald", 7, "Drama"));
		libros.add(new Libro(13, "Rayuela", "Julio Cortázar", 13,"Novela"));
		libros.add(new Libro(14, "El retrato de Dorian Gray", "Oscar Wilde", 21,"Terror"));
		libros.add(new Libro(15, "El código Da Vinci", "Dan Brown", 17,"Thriller"));
		libros.add(new Libro(16, "Mujercitas", "Louisa May Alcott", 19,"Infantil"));
		libros.add(new Libro(17, "La iliada", "Homero", 23, "Clasico"));
		libros.add(new Libro(18, "Anna Karenina", "Lev Tolstoi", 6, "Romance"));
		libros.add(new Libro(19, "Drácula", "Bram Stoker", 22, "Terror"));
		libros.add(new Libro(20, "El alquimista", "Paulo Coelho", 24, "Autoayuda"));
		libros.add(new Libro(21, "El retrato de Dorian Gray", "Oscar Wilde", 21, "Terror"));
		libros.add(new Libro(22, "El conde de Montecristo", "Alexandre Dumas", 14, "Drama"));
		libros.add(new Libro(23, "La naranja mecánica", "Anthony Burgess", 10, "Ciencia Ficcion"));
		libros.add(new Libro(24, "Crimen y castigo", "Fyodor Dostoyevsky", 18, "Drama"));
		libros.add(new Libro(25, "El hobbit", "J.R.R. Tolkien", 25, "Fantasia"));

		return libros;
	}

	@GetMapping("/menu")
	public String menuLibros(Model model) {
		model.addAttribute("titulo", titulo);
		model.addAttribute("cabecera", "Listado completo de libros");
		model.addAttribute("libros", listadoCompletoLibros());
		return "libros/listado";
	}
	
	@GetMapping("/listado")
	public String listadoMixto(@RequestParam(value = "genero", required = false) String genero,
			Model model) {

		List<Libro> listaCompleta = listadoCompletoLibros();
		List<Libro> listaFiltrada = new ArrayList<>();

		for (int i = 0; i < listaCompleta.size(); i++) {
			if (genero == null)
				break;
			if (genero.equals(listaCompleta.get(i).getGenero())) {
				listaFiltrada.add(listaCompleta.get(i));
			}
		}	
		
		model.addAttribute("titulo", titulo);
		model.addAttribute("cabecera", "Lista de libros - Genero " + genero);
		model.addAttribute("libros", listaFiltrada);
	

		return "libros/listado";
	}


	@GetMapping("/{id}")
	public String detalleLibro(@PathVariable int id, Model model) {
		Libro libro = listadoCompletoLibros().stream().filter(l -> l.getId() == id).findFirst().orElse(null);
		model.addAttribute("titulo", "Detalle del Libro");
		model.addAttribute("libro", libro);
		return "libros/detalle";
	}
}
