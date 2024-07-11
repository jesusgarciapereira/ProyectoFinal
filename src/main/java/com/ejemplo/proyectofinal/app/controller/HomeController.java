package com.ejemplo.proyectofinal.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Value("Home")
	private String tituloHome;

	@GetMapping({ "/", "/home", "/home/", "" })
	public String home(Model model) {
		
		 Map<String, String> proverbiosLista = new HashMap<>();
	        proverbiosLista.put("玉不琢，不成器", "El jade necesita ser tallado para convertirse en una gema");
	        proverbiosLista.put("千里之行，始于足下", "Un viaje de mil millas comienza con un solo paso");
	        proverbiosLista.put("流水不腐", "El agua corriente no se pudre");
	        proverbiosLista.put("父亲的教导可以持续十年", "La enseñanza de un padre puede durar diez años");
	        proverbiosLista.put("与其诅咒黑暗，不如点燃蜡烛", "Es mejor encender una vela que maldecir la oscuridad");
	        proverbiosLista.put("坚持不懈胜过一切", "La perseverancia prevalece cuando todo lo demás falla");
	        proverbiosLista.put("时间是条不回头的河", "El tiempo es un río que no regresa");
	        proverbiosLista.put("搬动山的人，始于搬小石块", "El hombre que mueve montañas comienza por pequeñas piedras");
	        proverbiosLista.put("耐心是苦涩的根，但其果实是甜的", "La paciencia es un árbol de raíz amarga pero de frutos muy dulces");
	        proverbiosLista.put("机会只敲一次门", "La oportunidad toca la puerta solo una vez");

	        Random r = new Random();
	        String[] claves = proverbiosLista.keySet().toArray(new String[0]);
	        String proverbioChino = claves[r.nextInt(claves.length)];
	        String proverbioEsp = proverbiosLista.get(proverbioChino);



		model.addAttribute("titulo", tituloHome);
		model.addAttribute("cabecera", "Inicio");
		model.addAttribute("loren",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque sit amet velit vel elit posuere feugiat. Aliquam fermentum placerat est, et blandit mi porta ac. Integer consectetur, enim sed lobortis luctus, lorem massa fringilla enim, blandit pharetra enim libero vitae felis. Pellentesque et purus sed quam consequat varius. In eget euismod elit. Duis et tincidunt dolor, a viverra metus. In hendrerit eu orci a blandit. In quis viverra augue. Maecenas feugiat arcu sed magna tincidunt, eget ultrices nisi porta. Vestibulum et mollis sem, a vehicula elit. Phasellus sed quam commodo, dapibus risus ac, vulputate justo. Nulla facilisi. Nunc quis tortor.");
		model.addAttribute("proverbioEsp", proverbioEsp);
        model.addAttribute("proverbioChino", proverbioChino);
		
		return "home/index";
	}
}
