package gm.empleados.controller;

import gm.empleados.entidad.Empleado;
import gm.empleados.service.EmpleadoService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoController.class);

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping({"", "/"})
    public String iniciar(ModelMap modelo) {
        List<Empleado> listaEmpleados = empleadoService.listarEmpleados();
        listaEmpleados.forEach((empleado) -> logger.info(empleado.toString()));
        modelo.put("empleados", listaEmpleados);
        return "index"; //index.jsp
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String mostrarAgregar() {
        return "agregar"; //agregar.jsp
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado,
                          HttpServletRequest request) {
        logger.info("Empleado a agregar: " + empleado);
        empleadoService.agregarEmpleado(empleado);
        return "redirect:/"; //redirige al path
    }

    @RequestMapping(value="/modificar", method = RequestMethod.GET)
    public String modificar(@RequestParam int idEmpleado, ModelMap modelo) {
        Empleado empleado = empleadoService.buscarEmpleadoPorId(idEmpleado);
        logger.info("Empleado a modificar: " + empleado);
        modelo.put("empleado", empleado);
        return "modificar"; //mostrar modificar.jsp
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.POST)
    public String modificar(@ModelAttribute("empleadoForm") Empleado empleado){
        logger.info("Empleado a modificar: " + empleado);
        empleadoService.agregarEmpleado(empleado);
        return "redirect:/"; //redirigimos al controlador "/"

    }

    @RequestMapping(value="/eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado) {
        Empleado aEliminar = empleadoService.buscarEmpleadoPorId(idEmpleado);
        logger.info("Empleado buscado para eliminar: " + aEliminar);
        empleadoService.eliminarEmpleadoPorId(aEliminar.getIdEmpleado());
        return "redirect:/";
    }
}
