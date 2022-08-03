package org.Carlos.Alexis.Martinez.Rodriguez.model;

// @author carlo

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "vacantes")
public class Vacante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "[a-zA-Z\\s]+$", message = "Este campo sólo puede contener letras")
    @NotBlank(message = "Este campo no puede dejarse en blanco")
    private String nombre;
    @Pattern(regexp = "[a-zA-Zá-ú0-9\\s\\.\\,]+$", message = "Este campo sólo puede contener letras")
    @NotBlank(message = "Este campo no puede dejarse en blanco")
    private String descripcion;
    private LocalDate fecha;
    @Min(value = 0, message = "El salario no puede ser un número negativo")
    @Max(value = 1000000, message = "El salario no es válido")
    @NotNull(message = "Este campo no puede dejarse en blanco")
    private Double salario = 0.0;
    private String status;
    private Integer destacado;
    @Pattern(regexp = "[a-zA-Zá-ú0-9\\s\\.\\,]+$", message = "El campo detalles sólo puede contener letras y números")
    @NotBlank(message = "Este campo no puede dejarse en blanco")
    private String detalles;
    private String imagen="no-image.png";
    
    @OneToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getSalario() {
        return salario;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDestacado(Integer destacado) {
        this.destacado = destacado;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    

    public String getStatus() {
        return status;
    }

    public Integer getDestacado() {
        return destacado;
    }

    public String getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        return "Vacante{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", salario=" + salario + ", status=" + status + ", destacado=" + destacado + ", detalles=" + detalles + ", imagen=" + imagen + ", categoria=" + categoria + '}';
    }

    
    
    

}
