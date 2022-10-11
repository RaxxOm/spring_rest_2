package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class Suscrito {
	
	@Id
	@GeneratedValue
	
			private Long codigo; 
			private String nombre;
			private String correo; 
			
			//cuando la lista no es importante
			@JsonIgnore
			@OneToMany(mappedBy = "suscrito")		//Uno a muchos. Relacion de asociación bidirecional
			private List<Comentario> comentarios;

			public Long getCodigo() {
				return codigo;
			}

			public void setCodigo(int codigo) {
				this.codigo = (long) codigo;
			}

			public String getNombre() {
				return nombre;
			}

			public void setNombre(String nombre) {
				this.nombre = nombre;
			}

			public String getCorreo() {
				return correo;
			}

			public void setCorreo(String correo) {
				this.correo = correo;
			}

			public List<Comentario> getComentarios() {
				return comentarios;
			}

			public void setComentarios(List<Comentario> comentarios) {
				this.comentarios = comentarios;
			}

			@Override
			public String toString() {
				return "Suscrito [codigo=" + codigo + ", nombre=" + nombre + ", correo=" + correo + ", comentarios="
						+ comentarios + "]";
			} 
			
			
			

}
