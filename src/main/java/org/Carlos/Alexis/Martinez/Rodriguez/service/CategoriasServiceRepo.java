package org.Carlos.Alexis.Martinez.Rodriguez.service;

// @author carlo

import java.util.List;
import org.Carlos.Alexis.Martinez.Rodriguez.model.Categoria;
import org.Carlos.Alexis.Martinez.Rodriguez.repository.CategoriasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CategoriasServiceRepo implements IntCategorias{

    @Autowired
    private CategoriasRepositorio repo;
    
    @Override
    public List<Categoria> ObtenerTodas() {
        
        return repo.findAll();
    }

    @Override
    public void agregar(Categoria categoria) {
        repo.save(categoria);
    }

    @Override
    public Categoria buscarporId(Integer idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int totalCategorias() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(Integer posicion, Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int buscarPosicion(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
