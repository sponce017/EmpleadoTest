package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Employee;

@Local
public interface EmpleadoServiceLocal {

	public void agregarEmpleado(Employee employee);
	public void modifcarEmpleado(Employee employee);
	public void eliminarEmpleado(Employee employee);
	public List<Employee> listaEmpleados();
}
