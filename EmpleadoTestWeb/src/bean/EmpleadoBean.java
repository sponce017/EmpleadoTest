package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import model.Employee;
import ejb.EmpleadoServiceLocal;

public class EmpleadoBean {

	@EJB
	private EmpleadoServiceLocal es;
	private List<Employee> lse ;
	private Employee emp;
	
	@PostConstruct
	public void init(){
		this.emp = new Employee();
		this.lse = this.es.listaEmpleados();
	}

	public void findAll(){
		lse = this.es.listaEmpleados();
	}
	
	public String guardarEmpleado(){
		es.agregarEmpleado(emp);
		init();
		return "index";
	}
	
	public String editarEmpleado(){
		es.modifcarEmpleado(emp);
		init();
		return "index";
	}
	
	public String eliminarEmpleado(){
		es.eliminarEmpleado(emp);
		init();
		return "index";
	}
	
	public String cargar(int idEmployee, String apellido, int area, String nombre){
			this.emp.setIdEmployee(idEmployee);
			this.emp.setApellido(apellido);
			this.emp.setArea(area);
			this.emp.setNombre(nombre);			
		return "index";
	}
		
	public EmpleadoServiceLocal getEs() {
		return es;
	}

	public void setEs(EmpleadoServiceLocal es) {
		this.es = es;
	}

	public List<Employee> getLse() {
		return lse;
	}

	public void setLse(List<Employee> lse) {
		this.lse = lse;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	
}
