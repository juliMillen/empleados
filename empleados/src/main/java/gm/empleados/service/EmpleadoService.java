package gm.empleados.service;

import gm.empleados.entidad.Empleado;
import gm.empleados.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private IEmpleadoRepository empleadoRepository;


    public List<Empleado> listarEmpleados(){
        return empleadoRepository.findAll();
    }

    public Empleado buscarEmpleadoPorId(Integer id){
        Empleado buscado = empleadoRepository.findById(id).orElse(null);
        return buscado;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    public void eliminarEmpleadoPorId(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
