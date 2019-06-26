package cl.model;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class Servicio
 */
@Singleton
@LocalBean
public class Servicio implements ServicioLocal {
	private ArrayList <Cliente> lista = new ArrayList();
    /**
     * Default constructor. 
     */
    public Servicio() {
        lista.add(new Cliente("Juan","Perez", "1-1"));
        lista.add(new Cliente("Diego","Perez", "2-2"));
    }
	@Override
	public void addCliente(Cliente c) {		
		lista.add(c);
	}
	@Override
	public ArrayList<Cliente> getCliente() {		
		return lista;
	}
	
	@Override
    public Cliente buscarRut(String rut){
		
		for (Cliente cliente : lista) {
			if (cliente.getRut().equals(rut)){
				return cliente;
			}
		}
		return null;
		
	}
	
	@Override
	public String eliminar(String rut){
		Cliente cli = buscarRut(rut);
		if (cli == null){
			return "Cliente no encontrado";
		}else{
			lista.remove(cli);
			return "Cliente eliminado";
		}
		
	}
	
	@Override
	public void actualizarCliente(Cliente c){
		eliminar(c.getRut());
		addCliente(c);
	}
	
}
