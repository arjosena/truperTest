package mx.com.truper.service;

import mx.com.truper.model.OrdenModel;
import mx.com.truper.model.ProductoModel;

public interface OrdenesService {
	public OrdenModel save(OrdenModel ordenModel);

	public OrdenModel findById(Long ordenId);

	public ProductoModel update(ProductoModel productoModel);
}
