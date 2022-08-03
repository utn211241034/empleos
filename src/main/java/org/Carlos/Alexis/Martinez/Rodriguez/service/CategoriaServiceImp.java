package org.Carlos.Alexis.Martinez.Rodriguez.service;

// @author carlo
import java.util.LinkedList;
import java.util.List;
import org.Carlos.Alexis.Martinez.Rodriguez.model.Categoria;

import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImp implements IntCategorias {

    private List<Categoria> lista = null;

    public CategoriaServiceImp() {
        lista = new LinkedList<Categoria>();
        Categoria c1 = new Categoria();
        c1.setId(1);
        c1.setNombre("Tics");
        c1.setDescripcion("Relacionado con informatica, telecomunicaciones, IOT. etc...");

        Categoria c2 = new Categoria();
        c2.setId(2);
        c2.setNombre("Contaduría");
        c2.setDescripcion("Relacionado con la contaduría");

        Categoria c3 = new Categoria();
        c3.setId(3);
        c3.setNombre("Ingeniería");
        c3.setDescripcion("Relacionado con todas las ramas de la ingenieria");

        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
    }

    @Override
    public List<Categoria> ObtenerTodas() {

        return lista;
    }

    @Override
    public void agregar(Categoria categoria) {

        lista.add(categoria);

    }

    @Override
    public Categoria buscarporId(Integer idCategoria) {
        Categoria aux;
        for(Categoria c : lista){
            if(c.getId().equals(idCategoria)){
                return c;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer idCategoria) {

        lista.remove(buscarporId(idCategoria));
    }

    @Override
    public int totalCategorias() {

        return lista.size();
    }

	@Override
	public void modificar(Integer posicion, Categoria categoria) {

		lista.set(posicion, categoria);
		
	}

	@Override
	public int buscarPosicion(Categoria categoria) {
		
		int index =0; int posicion = -1;
		Categoria aux = null;
		
		while(index < lista.size()) {
			aux = lista.get(index);
			
			if(aux.getId() == categoria.getId()) {
				posicion = index;
				break;
			}
			index++;
			
		}
		
		return posicion;
		
	}

}
