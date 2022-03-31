package mx.com.truper.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PRODUCTOS")
@Data
public class Producto {

	@Id
	@Column(name = "PRODUCTO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codigo;
	private String descripcion;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ORDEN_ID")
	private Orden orden;
	
	private Double precio;
	
	

}
