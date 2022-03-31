package mx.com.truper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.truper.model.OrdenModel;
import mx.com.truper.model.ProductoModel;
import mx.com.truper.service.OrdenesService;

@RestController
@RequestMapping("/truper/v1")
public class OrdenController {
	@Autowired
	OrdenesService ordenesService;

	@GetMapping("/ordenes/{id}")
	public ResponseEntity<Object> findAll(@PathVariable Long id) {

		return new ResponseEntity<>(ordenesService.findById(id), HttpStatus.OK);
	}

	
	@PutMapping("/ordenes/productos")
	public ResponseEntity<Object> findAll(@RequestBody ProductoModel productoModel) {

		return new ResponseEntity<>(ordenesService.update(productoModel), HttpStatus.ACCEPTED);
	}

	
	@PostMapping("/ordenes")
	public ResponseEntity<Object> save(@RequestBody OrdenModel ordenModel) {

		return new ResponseEntity<>(ordenesService.save(ordenModel), HttpStatus.CREATED);
	}

}
