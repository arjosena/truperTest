package mx.com.truper.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.truper.entity.Producto;
import mx.com.truper.model.OrdenModel;
import mx.com.truper.model.ProductoModel;
import mx.com.truper.repository.OrdenRepository;
import mx.com.truper.repository.ProductoRepository;
import mx.com.truper.service.OrdenesService;
import mx.com.truper.util.ConverterUtils;

@Service
public class OrdenesServiceImpl implements OrdenesService{
	
	
	@Autowired
	OrdenRepository ordenRepository;
	
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	ConverterUtils converterUtils;
	
	@Override
	public OrdenModel save(OrdenModel ordenModel) {
		return converterUtils.ordenToDto(ordenRepository.save(converterUtils.ordenToEntity(ordenModel)));
		
	}

	@Override
	public OrdenModel findById(Long ordenId) {
		return converterUtils.ordenToDto(ordenRepository.findById(ordenId).get());
		
	}

	@Override
	public ProductoModel update(ProductoModel productoModel) {
		Producto producto = productoRepository.findByCodigo(productoModel.getCodigo());
		producto.setPrecio(productoModel.getPrecio());
		productoRepository.save(producto);
		ProductoModel productoModelR = new ProductoModel();
		productoModelR.setCodigo(producto.getCodigo());
		productoModelR.setPrecio(productoModel.getPrecio());
		productoModelR.setDescripcion(producto.getDescripcion());
		return productoModelR;
	}

}
