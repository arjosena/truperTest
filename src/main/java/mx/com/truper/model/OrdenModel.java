package mx.com.truper.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class OrdenModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1964416621938634653L;
	private Long sucursalId;
	private Double total;
	private List<ProductoModel> productos;
	
	

}
