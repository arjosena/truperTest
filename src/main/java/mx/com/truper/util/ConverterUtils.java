package mx.com.truper.util;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import mx.com.truper.entity.Orden;
import mx.com.truper.entity.Producto;
import mx.com.truper.entity.Sucursal;
import mx.com.truper.model.OrdenModel;
import mx.com.truper.model.ProductoModel;

@Component
public class ConverterUtils {

	public Orden ordenToEntity(OrdenModel ordenModel) {
		Orden orden=new Orden();
		
		orden.setSucursal(new Sucursal(ordenModel.getSucursalId()));
		orden.setTotal(ordenModel.getTotal());
		
		List<Producto> productos = ordenModel.getProductos().stream().map(ps->{
			Producto producto=new Producto();
			producto.setCodigo(ps.getCodigo());
			producto.setOrden(orden);
			producto.setPrecio(ps.getPrecio());
			producto.setDescripcion(ps.getDescripcion());
			return producto;
		}).collect(Collectors.toList());
		
		orden.setProductos(productos);
		
		return orden;
	}
	
	
	public OrdenModel ordenToDto(Orden orden) {
		OrdenModel ordenModel=new OrdenModel();
		
		ordenModel.setSucursalId(orden.getSucursal().getId());
		ordenModel.setTotal(orden.getTotal());
		
		List<ProductoModel> productosModel = orden.getProductos().stream().map(ps->{
			ProductoModel productoModel=new ProductoModel();
			productoModel.setCodigo(ps.getCodigo());
			productoModel.setDescripcion(ps.getDescripcion());
			productoModel.setPrecio(ps.getPrecio());
			return productoModel;
			
		}).collect(Collectors.toList());
		
		ordenModel.setProductos(productosModel);
		
		return ordenModel;
	}


}
