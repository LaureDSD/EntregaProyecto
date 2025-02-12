package ProyectoFinalLaureano.ProyectoFinalLaureano.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

@Entity(name = "facturas")
public class Factura {

    @Schema(description = "Identificador único de la factura.", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Cliente asociado a la factura.", example = "1")
    @NotNull(message = "El cliente no puede estar vacío")
    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    @Schema(description = "Fecha de la factura.", example = "2025-01-10T14:30:00")
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fecha;

    @Schema(description = "Total de la factura.", example = "250.00")
    @Column(columnDefinition = "DECIMAL(10, 2) DEFAULT 0")
    private Double total;

    /*
    @Schema(description = "Estado de la factura.", example = "PAGADA")
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('PAGADA', 'PENDIENTE', 'CANCELADA') DEFAULT 'PENDIENTE'")
    private EstadoFactura estado;

    @Schema(description = "Forma de pago de la factura.", example = "TARJETA")
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('TARJETA', 'TRANSFERENCIA', 'EFECTIVO') DEFAULT 'EFECTIVO'")
    private FormaPago formapago;
*/
    @Schema(description = "Detalles del pago.", example = "4111111111111111")
    @Size(max = 255, message = "Los detalles del pago no pueden exceder los 255 caracteres")
    private String detallespago;
/*
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DetalleFactura> detalles;
*/

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    /*
    public EstadoFactura getEstado() { return estado; }
    public void setEstado(EstadoFactura estado) { this.estado = estado; }
    public FormaPago getFormapago() { return formapago; }
    public void setFormapago(FormaPago formapago) { this.formapago = formapago; }
    */
    public String getDetallespago() { return detallespago; }
    public void setDetallespago(String detallespago) { this.detallespago = detallespago; }
    /*
    public List<DetalleFactura> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleFactura> detalles) { this.detalles = detalles; }
    */

}