package com.ejemplo.proyectofinal.app.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imagenes")
public class ImagenesController {
	
	 private final String[] imagenesCapitales = {
	            "capitales/image1.jpg",
	            "capitales/image2.jpg",
	            "capitales/image3.jpg",
	            "capitales/image4.jpg",
	            "capitales/image5.jpg",
	            "capitales/image6.jpg",
	            "capitales/image7.jpg",
	            "capitales/image8.jpg",
	            "capitales/image9.jpg",
	            "capitales/image10.jpg"
	    };

	    @GetMapping("/menu")
	    public String menu(Model model) {
	        model.addAttribute("titulo", "Menú Imágenes");
	        model.addAttribute("cabecera", "Imágenes");
	        return "imagenes/index";
	    }

	    @GetMapping("/aleatorio")
	    public String mostrarImagenAleatoria(Model model) {
	    	
	        Random r = new Random();
	        int indice = r.nextInt(imagenesCapitales.length);
	        String imagenSeleccionada = imagenesCapitales[indice];
  
	        model.addAttribute("titulo", "Imagen aleatoria");
	        model.addAttribute("imagen", imagenSeleccionada);

	        return "imagenes/aleatorio";
	    }
}
