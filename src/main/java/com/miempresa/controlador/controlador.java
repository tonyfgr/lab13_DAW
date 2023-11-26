package com.miempresa.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miempresa.interfaceServicio.IEmpleadoServicio;
import com.miempresa.interfaceServicio.ITareaServicio;
import com.miempresa.modelo.Empleado;
import com.miempresa.modelo.Tarea;

@Controller
@RequestMapping
public class controlador{
	@Autowired
	private IEmpleadoServicio servicio;
	
	@GetMapping("/listarEmpleados")
	public String listarEmpleados(Model model) {
		List<Empleado> empleados = servicio.listar();
		model.addAttribute("empleados",empleados);
		return "empleados";
	}
	
	//tareas
	@Autowired
	private ITareaServicio serv;
	
	@GetMapping("/listarTareas")
	public String listarTareas(Model model) {
		List<Tarea> tareas = serv.listar();
		model.addAttribute("tareas",tareas);
		return "tareas";
	}
	
	
	
	@GetMapping("/agregarEmpleado")
	public String agregarEmpleado(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "agregarEmpleado";
	}
	
	@GetMapping("/agregarTarea")
	public String agregarTarea(Model model) {
		model.addAttribute("tarea", new Tarea());
		return "agregarTarea";
	}
	
	@PostMapping("/guardarEmpleado")
	public String guardarEmpleado(Empleado p) {
		servicio.guardar(p);
		return "redirect:/listarEmpleados";
	}
	
	@PostMapping("/guardarTarea")
	public String guardarTarea(Tarea p) {
		serv.guardar(p);
		return "redirect:/listarTareas";
	}
	

	
	@GetMapping("/editarEmpleado/{id}")
	public String editarEmpleado(@PathVariable int id, RedirectAttributes atributos) {
		Optional<Empleado> empleado = servicio.listarId(id);
		atributos.addFlashAttribute("empleado", empleado);
		return "redirect:/mostrarEmpleado";
	}
	
	@GetMapping("/editarTarea/{id}")
	public String editarTarea(@PathVariable int id, RedirectAttributes atributos) {
		Optional<Tarea> tarea = serv.listarId(id);
		atributos.addFlashAttribute("tarea", tarea);
		return "redirect:/mostrarTarea";
	}
	
	
	@GetMapping("/mostrarEmpleado")
	public String mostrarEmpleado(@ModelAttribute("empleado") Empleado p, Model model) {
		model.addAttribute("empleado", p);
		return "agregarEmpleado";
	}
	
	@GetMapping("/mostrarTarea")
	public String mostrarTarea(@ModelAttribute("tarea") Tarea p, Model model) {
		model.addAttribute("tarea", p);
		return "agregarTarea";
	}
	@GetMapping("/eliminarEmpleado/{id}")
	public String eliminarEmpleado(@PathVariable int id) {
		servicio.borrar(id);
		return "redirect:/listarEmpleados";
	}
	@GetMapping("/eliminarTarea/{id}")
	public String eliminarTarea(@PathVariable int id) {
		serv.borrar(id);
		return "redirect:/listarTareas";
	}
	
	@GetMapping("/buscarEmpleados")
	public String buscarEmpleados (
		@RequestParam(name="nombre") String nombre,
		Model model) {
		System.out.println(nombre);
		List<Empleado> empleados = servicio.buscar(nombre);
		model.addAttribute("empleados",empleados);
		return "buscarEmpleado";
	}
	
	
			@GetMapping("/buscarTareas")
			public String buscarTareas(
					@RequestParam(name="descripcion")String descripcion,
					Model model) {
				System.out.println(descripcion);
				List<Tarea> tareas = serv.buscar(descripcion);
				model.addAttribute("tareas", tareas);
				return "buscarTarea";
			}
	
}
















