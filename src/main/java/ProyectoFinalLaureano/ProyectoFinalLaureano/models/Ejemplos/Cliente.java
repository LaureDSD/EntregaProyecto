package ProyectoFinalLaureano.ProyectoFinalLaureano.models.Ejemplos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "clientes")
public class Cliente {

    @Schema(description = "Identificador único del cliente.", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Nombre del cliente.", example = "Laura")
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    @Column(length = 100, nullable = false)
    private String nombre;

    @Schema(description = "Apellidos del cliente.", example = "Fernández López")
    @NotBlank(message = "Los apellidos no pueden estar vacíos")
    @Size(max = 100, message = "Los apellidos no pueden exceder los 100 caracteres")
    @Column(length = 100, nullable = false)
    private String apellidos;

    @Schema(description = "Email único del cliente.", example = "laura.fernandez@example.com")
    @NotBlank(message = "El email no puede estar vacío")
    @Size(max = 100, message = "El email no puede exceder los 100 caracteres")
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Schema(description = "Teléfono del cliente.", example = "654321987")
    @Size(max = 15, message = "El teléfono no puede exceder los 15 caracteres")
    private String telefono;

    @Schema(description = "Dirección del cliente.", example = "Rúa do Castelo, 12, 32700 Maceda")
    @Size(max = 255, message = "La dirección no puede exceder los 255 caracteres")
    private String direccion;

    @Schema(description = "NIF del cliente.", example = "12345678A")
    @NotBlank(message = "El NIF no puede estar vacío")
    @Size(max = 20, message = "El NIF no puede exceder los 20 caracteres")
    @Column(length = 20, nullable = false, unique = true)
    private String nif;

    @Schema(description = "Fecha de creación del cliente.", example = "2025-01-10T14:30:00")
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechacreacion;

    @Schema(description = "Nombre de usuario del cliente.", example = "laura.fer")
    @Size(max = 50, message = "El nombre de usuario no puede exceder los 50 caracteres")
    private String usuario;

    @Schema(description = "Contraseña cifrada del cliente.", example = "hashed_password_1")
    @Size(max = 255, message = "La contraseña no puede exceder los 255 caracteres")
    private String contrasena;

    /*
    @Schema(description = "Categoría del cliente.", example = "VIP")
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('NORMAL', 'VIP', 'EMPRESA') DEFAULT 'NORMAL'")
    private CategoriaCliente categoria;
    */

    @Schema(description = "Información adicional del cliente.", example = "Cliente frecuente, descuento del 15%")
    @Size(max = 255, message = "La información adicional no puede exceder los 255 caracteres")
    private String informacion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Factura> facturas;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getNif() { return nif; }
    public void setNif(String nif) { this.nif = nif; }
    public LocalDateTime getFechacreacion() { return fechacreacion; }
    public void setFechacreacion(LocalDateTime fechacreacion) { this.fechacreacion = fechacreacion; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    /*
    public CategoriaCliente getCategoria() { return categoria; }
    public void setCategoria(CategoriaCliente categoria) { this.categoria = categoria; }
    */
    public String getInformacion() { return informacion; }
    public void setInformacion(String informacion) { this.informacion = informacion; }
    public List<Factura> getFacturas() { return facturas; }
    public void setFacturas(List<Factura> facturas) { this.facturas = facturas; }
}