package dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Empleado; 

public class EmpleadoImpl extends Conexion implements ICRUD<Empleado> {

    @Override
    public void guardar(Empleado empleado) throws Exception {
        try {
            String sql = "insert into EMPLEADO" + " (NOMEMP,APEEMP,DNIEMP,TELEMP, ESTEMP, ROLEMP)" + 
                    " values (?,?,?,?,?,?) ";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, empleado.getNOMEMP());
            ps.setString(2, empleado.getAPEEMP());
            ps.setInt(3, empleado.getDNIEMP());
            ps.setInt(4, empleado.getTELEMP());
            ps.setString(5, empleado.getESTEMP());
            ps.setString(6, empleado.getROLEMP());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error en EmpleadoImpl/registrar: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Empleado empleado) throws Exception {
        try {
            String sql = "update EMPLEADO set NOMEMP=?,APEEMP=?,DNIEMP=?,TELEMP=?, ESTEMP=?,ROLEMP=? whre IDEMP=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, empleado.getNOMEMP());
            ps.setString(2, empleado.getAPEEMP());
            ps.setInt(3, empleado.getDNIEMP());
            ps.setInt(4, empleado.getTELEMP());
            ps.setString(5, "A");
            ps.setString(6, empleado.getROLEMP());
            ps.setInt(7, empleado.getIDEMP());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error en EmpleadoImpl/modificar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Empleado empleado) throws Exception {
        try {
            String sql = "update EMPLEADO set ESTEMP='I' where IDEMP=? ";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, empleado.getIDEMP());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en EmpleadoImpl/eliminar: " + e.getMessage());
        }
    }

    
        public void cambiarEstado(Empleado empleado) throws Exception {
        try {
            String sql = "update EMPLEADO set ESTEMP=? where IDEMP=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, empleado.getESTEMP());
            ps.setInt(2, empleado.getIDEMP());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en PacienteImpl/cambiarEstado: " + e.getMessage());
        }
    }


    @Override
    public List<Empleado> listarTodos() throws Exception {
        List<Empleado> lista = new ArrayList<>();
        ResultSet ple;
        String sql = "select * from EMPLEADO where ESTEMP='A' order by IDEMP asc";

        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ple = ps.executeQuery();
            
            while (ple.next()) {
                Empleado emp = new Empleado();
                emp.setIDEMP(ple.getInt("IDEMP"));
                emp.setNOMEMP(ple.getString("NOMEMP"));
                emp.setAPEEMP(ple.getString("APEEMP"));
                emp.setDNIEMP(ple.getInt("DNIEMP"));
                emp.setTELEMP(ple.getInt("TELEMP"));
                emp.setESTEMP(ple.getString("ESTEMP"));
                emp.setROLEMP(ple.getString("ROLEMP"));
                lista.add(emp);

            }
        } catch (Exception e) {
            System.out.println("Error al listar todos)");
        } finally {
            this.cerrar();
        }
        return lista;
    }
   
}