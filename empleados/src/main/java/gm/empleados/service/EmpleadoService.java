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


    public List<Empleado> listarEmpleados() {
        List<Empleado> listaEmpleados = empleadoRepository.findAll();
        if(listaEmpleados.isEmpty()) {
            System.out.println("No se han encontrado empleados");
        }else{
            System.out.println("Empleados encontrados "+ listaEmpleados.size() + " empleados");
        }
        return listaEmpleados;
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
