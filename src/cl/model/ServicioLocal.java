package cl.model;

import java.util.ArrayList;

import javax.ejb.Local;

@Local
/**
*@author Marcela Castro
*@version 20-06-2019 v0.1
*/
public interface ServicioLocal {
	
	void addCliente(Cliente c);
	ArrayList <Cliente> getCliente();
	Cliente buscarRut(String rut);
	String eliminar(String rut);
	void actualizarCliente(Cliente c);
}
