package gm.empleados.controller;

import gm.empleados.entidad.Empleado;
import gm.empleados.service.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class EmpleadoController {
    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoController.class);

    @Autowired
    private EmpleadoService empleadoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo) {
        List<Empleado> listaEmpleados = empleadoService.listarEmpleados();
        listaEmpleados.forEach((empleado) -> logger.info(empleado.toString()));
        modelo.put("empleado", listaEmpleados);
        return "index"; //index.jsp
    }
}
