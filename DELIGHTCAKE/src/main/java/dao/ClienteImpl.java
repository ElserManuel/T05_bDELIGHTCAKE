
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;


/**
 *
 * @author manol
 */
public class ClienteImpl extends Conexion implements ICRUD<Cliente> {
  
    @Override
    public void guardar(Cliente cliente) throws Exception {
        try {
            String sql = "insert into CLIENTE" + " (NOMCLI,APECLI,DNICLI,TELCLI, EMACLI, ESTCLI, CODUBI)" + 
                    " values (?,?,?,?,?,?) ";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, cliente.getNOMCLI());
            ps.setString(2, cliente.getAPECLI());
            ps.setString(3, cliente.getDNICLI());
            ps.setString(4, cliente.getTELCLI());
            ps.setString(5, cliente.getEMACLI());
            ps.setString(6, cliente.getESTCLI());
            ps.setString(7, cliente.getCODUBI());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error en ClienteImpl/registrar: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Cliente cliente) throws Exception {
        try {
            String sql = "update CLIENTE set NOMCLI=?,APECLI=?,DNICLI=?,TELCLI=?, EMACLI=?,ESTCLI=? CODUBI=? whrere IDCLI=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, cliente.getNOMCLI());
            ps.setString(2, cliente.getAPECLI());
            ps.setString(3, cliente.getDNICLI());
            ps.setString(4, cliente.getTELCLI());
            ps.setString(5, cliente.getEMACLI());
            ps.setString(6, cliente.getESTCLI());
            ps.setString(7, cliente.getCODUBI());
            ps.setInt(8, cliente.getIDCLI());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error en ClienteImpl/modificar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Cliente cliente) throws Exception {
        try {
            String sql = "update CLIENTE set ESTCLI='I' where IDCLI=? ";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, cliente.getIDCLI());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en ClienteImpl/eliminar: " + e.getMessage());
        }
    }

    
        public void cambiarEstado(Cliente cliente) throws Exception {
        try {
            String sql = "update CLIENTE set ESTCLI=? where IDCLI=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, cliente.getESTCLI());
            ps.setInt(2, cliente.getIDCLI());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en ClienteImpl/cambiarEstado: " + e.getMessage());
        }
    }


    @Override
    public List<Cliente> listarTodos() throws Exception {
        List<Cliente> lista = new ArrayList<>();
        ResultSet rs;
        String sql = "select * from CLIENTE where ESTCLI='A' order by IDCLI asc";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setIDCLI(rs.getInt("IDCLI"));
                cli.setNOMCLI(rs.getString("NOMCLI"));
                cli.setAPECLI(rs.getString("APECLI"));
                cli.setDNICLI(rs.getString("DNICLI"));
                cli.setTELCLI(rs.getString("TELCLI"));
                cli.setEMACLI(rs.getString("EMACLI"));
                cli.setESTCLI(rs.getString("ESTCLI"));
                cli.setCODUBI(rs.getString("CODUBI"));
                lista.add(cli);

            }
        } catch (Exception e) {
            System.out.println("Error al listar todos)");
        } finally {
            this.cerrar();
        }
        return lista;
    } 
}
