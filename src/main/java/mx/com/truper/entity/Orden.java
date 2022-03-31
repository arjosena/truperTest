package mx.com.truper.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "ORDENES")
@Data
public class Orden {

	@Id
	@Column(name = "ORDEN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "SUCURSAL_ID")
	private Sucursal sucursal;
	
	@Column(name="FECHA")
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date fecha;
	
	@Column(name="TOTAL")
	private Double total;
	
	
	@OneToMany(mappedBy = "orden", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Producto> productos;
	
	
	

}
