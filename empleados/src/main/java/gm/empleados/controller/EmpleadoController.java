package gm.empleados.controller;

import gm.empleados.entidad.Empleado;
import gm.empleados.service.EmpleadoService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
