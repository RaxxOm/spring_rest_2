package py.edu.facitec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass		//Para indicar herencia

public abstract class General  {
	
	
	@Id						//recurre al auto incrementable de la bd
	@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id; 
			
			public General() {
				// TODO Auto-generated constructor stub
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			@Override
			public String toString() {
				return "General [id=" + id + "]";
			}

			

			
			

}
