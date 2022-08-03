package org.Carlos.Alexis.Martinez.Rodriguez.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.Carlos.Alexis.Martinez.Rodriguez.model.Categoria;
import org.Carlos.Alexis.Martinez.Rodriguez.model.Vacante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

// @author carlo
@Service
public class VacanteServiceImp implements IntVacantes {
    
    private CategoriaServiceImp serviceCat;

    private List<Vacante> lista;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public VacanteServiceImp() {
        lista = new LinkedList<Vacante>();
        try {
            
            serviceCat = new CategoriaServiceImp();
            Vacante v = new Vacante();
            Vacante v1 = new Vacante();
            Vacante v2 = new Vacante();

            v.setId(1);
            v.setNombre("Desarrollador Web");
            v.setDescripcion("Desarrolla apps");
            v.setSalario(300.0);
            v.setFecha(LocalDate.parse("21/01/2022", formato));
            v.setImagen("artesania.png");
            v.setStatus("Creada");
            v.setDestacado(1);
            v.setDetalles("<h2>Detalles</h2>"
                    + "<ul>"
                    + "<li>Echarle ganas</li>"
                    + "</ul>");
            Categoria c = new Categoria();
            v.setCategoria(serviceCat.buscarporId(1));

            v1.setId(2);
            v1.setNombre("Contador");
            v1.setDescripcion("Asustos de contabilidad");
            v1.setSalario(100.0);
            v1.setFecha(LocalDate.parse("01/04/2020", formato));
            v1.setImagen("artesania.png");
            v1.setStatus("Aprobada");
            v1.setDestacado(1);
            v1.setDetalles("<h2>Detalles</h2>"
                    + "<ul>"
                    + "<li>Echarle ganas</li>"
                    + "</ul>");
            v1.setCategoria(serviceCat.buscarporId(2));

            v2.setId(3);
            v2.setNombre("Ingeniero civíl");
            v2.setDescripcion("Realizar tareas que realiza un ingeniero civíl");
            v2.setSalario(200.0);
            v2.setFecha(LocalDate.parse("29/07/2022", formato));
            v2.setImagen("artesania.png");
            v2.setStatus("Eliminada");
            v2.setDestacado(0);
            v2.setDetalles("<h2>Detalles</h2>"
                    + "<ul>"
                    + "<li>Echarle ganas</li>"
                    + "</ul>");
            v2.setCategoria(serviceCat.buscarporId(3));

            lista.add(v);
            lista.add(v1);
            lista.add(v2);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void agregar(Vacante vacante) {
        lista.add(vacante);

    }

    @Override
    public void eliminar(Integer id) {

        for (Vacante vacante : lista) {
            if (vacante.getId() == id) {
                lista.remove(vacante);
                break;
            }
        }
    }

    @Override
    public List<Vacante> obtenerTodos() {

        return lista;
    }

    @Override
    public Vacante buscarPorId(Integer id) {

        for (Vacante vacante : lista) {
            if (vacante.getId() == id) {
                return vacante;
            }

        }

        return null;
    }

    @Override
    public int totalVacantes() {

        return lista.size();
    }

    @Override
    public Page<Vacante> buscarTodas(Pageable page) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
