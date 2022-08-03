package org.Carlos.Alexis.Martinez.Rodriguez.service;

//@author carlo

import java.util.List;
import org.Carlos.Alexis.Martinez.Rodriguez.model.Categoria;
import org.Carlos.Alexis.Martinez.Rodriguez.model.Vacante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IntVacantes {
    
    public void agregar(Vacante vacante);
    public void eliminar(Integer id);
    public List<Vacante> obtenerTodos();
    public Vacante buscarPorId(Integer id);
    public int totalVacantes();
    public Page<Vacante> buscarTodas(Pageable page);


}
