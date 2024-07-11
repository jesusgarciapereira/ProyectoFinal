package com.ejemplo.proyectofinal.app.controller;

import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/loto")
@Controller
public class LotoController {

	@GetMapping("/menu")
	public String menu(Model model) {
		model.addAttribute("titulo", "Menú Loto");
		model.addAttribute("cabecera", "Loto");
		return "loto/index";
	}

	@GetMapping("/genera/49/6/spain")
	public String generateSpain(Model model) {

		model.addAttribute("titulo", "Loto España");
		model.addAttribute("cabecera", "Combinación de Loto para España");
		model.addAttribute("combinacion", generaCombinacion(6, 49));
		
		return "loto/genera";
	}

	@GetMapping("/genera/49/6/germany")
	public String generateGermany(Model model) {
		
		model.addAttribute("titulo", "Loto Alemania");
		model.addAttribute("cabecera", "Combinación de Loto para Alemania");
		model.addAttribute("combinacion", generaCombinacion(6, 49));
		
		return "loto/genera";
	}

	@GetMapping("/genera/90/6/france")
	public String generateFrance(Model model) {
		
		model.addAttribute("titulo", "Loto Francia");
		model.addAttribute("cabecera", "Combinación de Loto para Francia");
		model.addAttribute("combinacion", generaCombinacion(6, 90));

		return "loto/genera";
	}

	@GetMapping("/genera/59/5/italy")
	public String generateItaly(Model model) {
		
		model.addAttribute("titulo", "Loto Italia");
		model.addAttribute("cabecera", "Combinación de Loto para Italia");
		model.addAttribute("combinacion", generaCombinacion(5, 59));
		
		return "loto/genera";
	}

	private String generaCombinacion(int cantNumeros, int numMax) {

		Random r = new Random();
		int[] tablaNumeros = new int[cantNumeros];
		int numeroIntroducido = 0;
		String texto = "";

		while (tablaNumeros[0] == 0) {
			while (Arrays.binarySearch(tablaNumeros, numeroIntroducido) > 0) {
				numeroIntroducido = r.nextInt(numMax + 1);
			}
			tablaNumeros[0] = numeroIntroducido;

			Arrays.sort(tablaNumeros);
		}
		
		for (int i = 0; i < tablaNumeros.length; i++) {
			texto += tablaNumeros[i] + " ";
		}

		return texto;
	}
}
