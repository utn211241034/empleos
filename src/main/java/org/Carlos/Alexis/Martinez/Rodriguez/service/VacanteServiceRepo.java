package org.Carlos.Alexis.Martinez.Rodriguez.service;

// @author carlo

import java.util.List;
import java.util.Optional;
import org.Carlos.Alexis.Martinez.Rodriguez.model.Vacante;
import org.Carlos.Alexis.Martinez.Rodriguez.repository.VacanteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class VacanteServiceRepo implements IntVacantes{

    @Autowired
    private VacanteRepositorio repo;
    
    @Override
    public void agregar(Vacante vacante) {
        repo.save(vacante);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Vacante> obtenerTodos() {

        return repo.findAll();
    }

    @Override
    public Vacante buscarPorId(Integer id) {
        Optional <Vacante> aux = repo.findById(id);
        if (aux.isPresent()) {
                    return aux.get();
        }
        
        return null;
    }

    @Override
    public int totalVacantes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<Vacante> buscarTodas(Pageable page) {
        return repo.findAll(page);
    }

}
