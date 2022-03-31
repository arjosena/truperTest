package mx.com.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.truper.entity.Orden;
import mx.com.truper.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	Producto findByCodigo(String codigo);

}
