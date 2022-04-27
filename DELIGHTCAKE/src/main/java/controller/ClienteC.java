
package controller;
import model.Cliente;
import dao.ClienteImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;




/**
 *
 * @author cupej
 */
@Named(value = "ClienteC")
@SessionScoped
public class ClienteC implements Serializable {

    private Cliente cliente;
    ClienteImpl dao;
    private List<Cliente> lstCliente;

    public ClienteC() {
        cliente = new Cliente();
        dao = new ClienteImpl();
    }

    public void registrar() throws Exception {
        try {
            dao.guardar(cliente);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado", "Registrado con éxito"));
        } catch (Exception e) {
            System.out.println("Error en registar ClienteC/registar: " + e.getMessage());
        }

    }

    public void modificar() throws Exception {
        try {
            dao.modificar(cliente);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificado", "Registrado con éxito"));
        } catch (Exception e) {
            System.out.println("Error en modificar ClienteC/modificar: " + e.getMessage());
        }
    }

    public void eliminar(Cliente cli) throws Exception {
        try {
            dao.eliminar(cli);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Eliminado", "Eliminado con éxito"));
        } catch (Exception e) {
            System.out.println("Error en eliminar ClienteC/eliminar: " + e.getMessage());
        }
    }

    public void listar() throws Exception {
        try {
            lstCliente = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en eliminar ClienteC/modificar: " + e.getMessage());
        }
    }

    public void cambiarEstado() throws Exception {
        try {
            dao = cambiarEstado(cliente);
        } catch (Exception e) {
            System.out.println("Error en eliminar ClienteC/modificar: " + e.getMessage());
        }
    }

    // Getter y Setter
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getLstCliente() {
        return lstCliente;
    }

    public void setLstCliente(List<Cliente> lstCliente) {
        this.lstCliente = lstCliente;
    }

    private ClienteImpl cambiarEstado(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
