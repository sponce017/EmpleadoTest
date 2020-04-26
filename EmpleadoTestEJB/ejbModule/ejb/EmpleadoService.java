package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import model.Employee;

/**
 * Session Bean implementation class EmpleadoService
 */
@Stateless
public class EmpleadoService implements EmpleadoServiceLocal {

	@PersistenceContext(unitName = "EmpleadoMgt")
	private EntityManager entityManager;
	
	public EmpleadoService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void agregarEmpleado(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.persist(employee);
	}

	@Override
	public void modifcarEmpleado(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.merge(employee);		
	}

	@Override
	public void eliminarEmpleado(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(employee));
	}

	@Override
	public List<Employee> listaEmpleados() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("Employee.findAll");
		List<Employee> lse = query.getResultList();
		return lse;
		
	}

}
