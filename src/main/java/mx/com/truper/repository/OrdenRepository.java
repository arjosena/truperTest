package mx.com.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.truper.entity.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

}
