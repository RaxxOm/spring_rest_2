package py.edu.facitec.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
	
	//Recibir una URL como configuración 
		@RequestMapping("/")
		
		public String home() {
			
			System.out.println("Ingrese a la página de inicio");
			
			//Retornar una página 
			return "index";
		}

}
