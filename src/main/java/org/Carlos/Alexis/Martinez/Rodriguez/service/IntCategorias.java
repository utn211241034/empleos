package org.Carlos.Alexis.Martinez.Rodriguez.service;

import java.util.List;
import org.Carlos.Alexis.Martinez.Rodriguez.model.Categoria;

public interface IntCategorias {

    public List<Categoria> ObtenerTodas();

    public void agregar(Categoria categoria);

    public Categoria buscarporId(Integer idCategoria);

    public void eliminar(Integer idCategoria);

    public int totalCategorias();

    public void modificar(Integer posicion, Categoria categoria);

    public int buscarPosicion(Categoria categoria);


}
