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

import py.edu.facitec.model.Post;
import py.edu.facitec.repository.PostRepository;

@RestController					//se indica la arquitectura rest 
@RequestMapping("/posts")	//servidor

public class PostController {
	
								
			@Autowired				//INICIALIZA DENTRO DEL CONTEXTO SPRING
			private PostRepository postRepository;
			
			//realizamos la consulta y cargamos el obejto posts
								
			//Responderá al verbo Get
			//URL /post
			
			@GetMapping	
			public ResponseEntity<List<Post>> getAll(){
				List<Post> posts = postRepository.findAll();
				
				//retornamos la lista con el status 
				return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
				
			}
												//Indicar que los datos viajan dentro del request
												//Datos que vienen del cliente es el objeto request
			//verbo Post
			@PostMapping
			public ResponseEntity<Post> create(@RequestBody Post postLlega){
				
				System.out.println(postLlega.toString());
				
				try {
						Post postRegistrado = postRepository.save(postLlega);
						
						System.out.println(postRegistrado.toString());
						
						return new  ResponseEntity<Post>(postRegistrado, HttpStatus.OK);
					
				} catch (Exception e) {
					
					return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
					
				}
				
			}
			
											//recibimos el codigo
			@GetMapping(value="/{codigo}")
			
			//cargamos la variable
			public ResponseEntity<Post> getOne(@PathVariable Long codigo){
				
				Optional<Post> postConsulta=postRepository.findById(codigo);
				
				if(postConsulta.isPresent()) {
					
					return new ResponseEntity<Post>(postConsulta.get(), HttpStatus.OK);	
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
				}
				
			}
			
										//verbo DELETE
			@DeleteMapping("/{codigo}")
			
			public ResponseEntity<Post> deleteById(@PathVariable Long codigo){
					
			//logica para eliminar atraves de una tabla precargada 
				try {
					postRepository.deleteById(codigo);
					
					return new ResponseEntity<>(HttpStatus.OK);
				
				} catch (Exception e) {
					
					e.printStackTrace();
					
					return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
				}
				
			}
			
			
			
			
			
			
			
			
			

}
