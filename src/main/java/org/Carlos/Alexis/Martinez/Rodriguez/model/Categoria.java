package org.Carlos.Alexis.Martinez.Rodriguez.model;

// @author carlo

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "[a-zA-Zá-ú\\s]+$", message = "El campo nombre sólo puede contener letras")
    @NotBlank(message = "Este campo no puede dejarse en blanco")
    private String nombre;
    @Pattern(regexp = "[a-zA-Zá-ú\\s\\.\\,]+$", message = "El campo descripción sólo puede contener letras")
    @NotBlank(message = "Este campo no puede dejarse en blanco")
    private String descripcion;

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }

}
