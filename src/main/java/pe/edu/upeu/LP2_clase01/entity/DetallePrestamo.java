package pe.edu.upeu.LP2_clase01.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="detalle_prestamo")
public class DetallePrestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="observacion")
	private String observacion;
	@Column(name = "FECHA_ENTREGA")
	@Temporal(TemporalType.DATE)
    private Date fechaentrega;
	@Column(name="estado")
	private char estado;
	
	@ManyToOne
	@JoinColumn(name="libro_id", nullable = false)
	private Libro libro;
	
	@ManyToOne
	@JoinColumn(name="prestamo_id", nullable = false)
	private Prestamo prestamo;
	
}
