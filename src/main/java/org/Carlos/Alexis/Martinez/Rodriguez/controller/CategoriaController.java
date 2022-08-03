package org.Carlos.Alexis.Martinez.Rodriguez.controller;

// @author carlo
import java.util.List;
import javax.validation.Valid;

import org.Carlos.Alexis.Martinez.Rodriguez.model.Categoria;
import org.Carlos.Alexis.Martinez.Rodriguez.service.IntCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/categoria")
@Controller
public class CategoriaController {

    @Autowired
    private IntCategorias categoriaService;
    private static int id = 4;
//******************************************************************************

    @GetMapping("/index")
    public String mostrarIndex(Model model) {

        List<Categoria> lista = categoriaService.ObtenerTodas();
        for (Categoria categoria : lista) {
            //System.out.println(categoria);
        }
        model.addAttribute("categorias", lista);
        model.addAttribute("total", categoriaService.ObtenerTodas().size());
        return "categorias/listaCategorias";
    }
//******************************************************************************

    @GetMapping("/crear")
    public String nuevaCategoria(Categoria categoria) {

        return "categorias/formCategorias";
    }
//******************************************************************************

    /*@PostMapping("/guardar")
    public String guardarCategoria(@RequestParam("nombre") String nombre, 
            @RequestParam("descripcion") String descripcion){
        //Recibo datos
        Categoria c = new Categoria();
        c.setId(categoriaService.ObtenerTodas().size()+1);
        c.setNombre(nombre);
        c.setDescripcion(descripcion);
        categoriaService.agregar(c);
        //Guardar datos

        //Regreso a la vista de listCategorias
        return "redirect:/categoria/index";
    }*/
    //Igual que el método de arriba utilizando Data Binding
    @PostMapping("/guardar")
    public String guardarCategoria(RedirectAttributes redirect, @Valid Categoria categoria, BindingResult result) {
        
        if(result.hasErrors()){
            for (ObjectError allError : result.getAllErrors()) {
                System.out.println(allError);
            }
        }
        
        if(result.hasErrors()){
            
            return "categorias/formCategorias";
        }else{
            if (categoria.getId() == null) {
                categoria.setId(id++);
                categoriaService.agregar(categoria);
                redirect.addFlashAttribute("msg", "El registro se ha guardado");
            } else {
                int posicion = categoriaService.buscarPosicion(categoria);
                categoriaService.modificar(posicion, categoria);
                redirect.addFlashAttribute("msg", "El registro se ha editado");
            }
        
        return "redirect:/categoria/index";
        
        }
    }

//********************************************************************************
    @GetMapping("/eliminar")
    public String eliminarCategoria(@RequestParam("id") int idCategoria) {
        categoriaService.eliminar(idCategoria);
        return "redirect:/categoria/index";
    }

//********************************************************************************
    @GetMapping("/buscar")
    public String buscarCategoria(@RequestParam("id") int idCategoria, Model model) {

        Categoria categoria = categoriaService.buscarporId(idCategoria);
        model.addAttribute("categoria", categoria);

        return "categorias/formCategorias";

    }

}
