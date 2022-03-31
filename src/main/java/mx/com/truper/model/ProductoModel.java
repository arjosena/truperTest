package mx.com.truper.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6668431904476083500L;
	private String codigo;

	private String descripcion;

	private Double precio;

}
