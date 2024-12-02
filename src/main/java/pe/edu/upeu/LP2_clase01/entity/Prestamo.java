package pe.edu.upeu.LP2_clase01.entity;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="prestamos")
public class Prestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id=0L;	
	@Column(name = "FECHA_PRESTAMO")	
	@Temporal(TemporalType.TIMESTAMP)  
    private Date fechap;	
	@Column(name = "FECHA_ENTREGA")
	@Temporal(TemporalType.DATE)
    private Date fechae;	
	@Column(name = "ESTADO")
    private char estado;
	
	@ManyToOne
	@JoinColumn(name="lector_id", nullable = false)
	private Lector lector;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", nullable = false)
	private Usuario usuario;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "prestamo")
	@JsonIgnore
	private Set<DetallePrestamo> detalles;
	
}
