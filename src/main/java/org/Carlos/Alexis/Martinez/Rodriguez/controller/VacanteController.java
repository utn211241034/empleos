package org.Carlos.Alexis.Martinez.Rodriguez.controller;

// @author carlo
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.validation.Valid;
import org.Carlos.Alexis.Martinez.Rodriguez.model.Vacante;
import org.Carlos.Alexis.Martinez.Rodriguez.service.CategoriaServiceImp;
import org.Carlos.Alexis.Martinez.Rodriguez.service.IntCategorias;
import org.Carlos.Alexis.Martinez.Rodriguez.service.IntVacantes;
import org.Carlos.Alexis.Martinez.Rodriguez.service.VacanteServiceImp;
import org.carlos.martinez.rodriguez.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/vacante")
public class VacanteController {

    private Integer id = 4;

    @Autowired
    private IntVacantes service;
    @Autowired
    private IntCategorias serviceCategoria;

    @GetMapping("/index")
    public String index(Model model, Pageable page) {

        Page<Vacante> lista = service.buscarTodas(page);
        model.addAttribute("vacantes", lista);
        model.addAttribute("total", service.obtenerTodos().size());
        model.addAttribute("trabajos", lista);

        return "vacantes/listaVacantes";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(@RequestParam("id") int id, Model model) {
        Vacante v = service.buscarPorId(id);
        model.addAttribute("vacante", v);

        return "vacantes/detalle";
    }

    @GetMapping("/consultar")
    public String consultar(@RequestParam("id") int idVacante, Model model) {
        Vacante v = service.buscarPorId(idVacante);
        model.addAttribute("vacante", v);
        return "vacantes/formVacante";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int id) {
        service.eliminar(id);

        return "redirect:/vacante/index";
    }

    @GetMapping("/crear")
    public String mostrarFormulario(Vacante vacante) {

        return "vacantes/formVacante";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam("archivoImagen") MultipartFile multiPart,
            @Valid Vacante vacante, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> System.out.println(e));

            return "vacantes/formVacante";
        } else {
            if (!multiPart.isEmpty()) {
                String ruta = "c:/empleos/img-vacantes/";
                String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
                if (nombreImagen != null) { // La imagen si se subio
                    // Procesamos la variable nombreImagen
                    vacante.setImagen(nombreImagen);
                }
            }

            vacante.setId(++id);
            vacante.setCategoria(serviceCategoria.buscarporId(vacante.getCategoria().getId()));
            service.agregar(vacante);
            System.out.println(vacante.getCategoria().getId());
            System.out.println(vacante);

        }
        return "redirect:/vacante/index";

    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }

            @Override
            public String getAsText() throws IllegalArgumentException {
                return DateTimeFormatter.ofPattern("dd-MM-yyyy").format((LocalDate) getValue());
            }

        });
    }

    @ModelAttribute
    public void setGenericos(Model model) {
        model.addAttribute("categorias", serviceCategoria.ObtenerTodas());
    }

}
