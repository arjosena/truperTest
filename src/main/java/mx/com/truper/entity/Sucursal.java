package mx.com.truper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SUCURSALES")
@Data
public class Sucursal {

	public Sucursal(Long sucursalId) {
		this.id = sucursalId;
	}

	@Id
	@Column(name = "SUCURSAL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	
	public Sucursal() {
		// TODO Auto-generated constructor stub
	}

}
