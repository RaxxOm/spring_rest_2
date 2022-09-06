package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;

@RestController					//se indica la arquitectura rest 
@RequestMapping("/suscritos")	//servidor

public class SuscritoController {
	
								
			@Autowired				//INICIALIZA DENTRO DEL CONTEXTO SPRING
			private SuscritoRepository suscritoRepository;
			
			//realizamos la consulta y cargamos el obejto suscritos
								
			
			//Responderá al verbo Get
			//URL /suscrito
			@GetMapping	
			public ResponseEntity<List<Suscrito>> getAll(){
				List<Suscrito> suscritos = suscritoRepository.findAll();
				
				//retornamos la lista con el status 
				return new ResponseEntity<List<Suscrito>>(suscritos, HttpStatus.OK);
				
			}
												//Indicar que los datos viajan dentro del request
												//Datos que vienen del cliente es el objeto request
			//verbo Post
			@PostMapping
			public ResponseEntity<Suscrito> create(@RequestBody Suscrito suscritoLlega){
				
				System.out.println(suscritoLlega.toString());
				
				try {
						Suscrito suscritoRegistrado = suscritoRepository.save(suscritoLlega);
						
						System.out.println(suscritoRegistrado.toString());
						
						return new  ResponseEntity<Suscrito>(suscritoRegistrado, HttpStatus.OK);
					
				} catch (Exception e) {
					
					return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
					
				}
				//POSTMAN
			}
			
											//recibimos el codigo
			@GetMapping(value="/{codigo}")
			
			//cargamos la variable
			public ResponseEntity<Suscrito> getOne(@PathVariable Long codigo){
				
				Optional<Suscrito> suscritoConsulta=suscritoRepository.findById(codigo);
				
				if(suscritoConsulta.isPresent()) {
					
					return new ResponseEntity<Suscrito>(suscritoConsulta.get(), HttpStatus.OK);	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
				}
				
			}
			
			
			//verbo DELETE
			
			@DeleteMapping("/{codigo}")
			
			public ResponseEntity<Suscrito> deleteById(@PathVariable Long codigo){
					
			//logica para eliminar atraves de una tabla precargada 
				try {
					suscritoRepository.deleteById(codigo);
					
					return new ResponseEntity<>(HttpStatus.OK);
				
				} catch (Exception e) {
					
					e.printStackTrace();
					
					return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
				}
				
			}
			
			
			
			
			
			
			
			
			

}
