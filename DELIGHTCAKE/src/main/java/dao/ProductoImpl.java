package dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Producto;

public class ProductoImpl extends Conexion implements ICRUD<Producto> {

    @Override
    public void guardar(Producto producto) throws Exception {
        try {
            String sql = "insert into producto" + " (NOMPRO,PREPRO,DESPRO,ESTPRO)"
                    + " values (?,?,?,?) ";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, producto.getNOMPRO());
            ps.setDouble(2, producto.getPREPRO());
            ps.setString(3, producto.getDESPRO());
            ps.setString(4, producto.getESTPRO());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error en ProductoImpl/registrar: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Producto producto) throws Exception {
        try {
            String sql = "update producto set NOMPRO=?,PREPRO=?,DESPRO=?,ESTPRO=? where IDPRO=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, producto.getNOMPRO());
            ps.setDouble(2, producto.getPREPRO());
            ps.setString(3, producto.getDESPRO());
            ps.setString(4, "A");
            ps.setInt(5, producto.getIDPRO());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error en ProductoImpl/modificar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Producto producto) throws Exception {
        try {
            String sql = "update Producto set ESTPRO='I' where IDPRO=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, producto.getIDPRO());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en ProductoImpl/eliminar: " + e.getMessage());
        }
    }

    public void cambiarEstado(Producto producto) throws Exception {
        try {
            String sql = "update producto set ESTPRO=? where IDPRO=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, producto.getESTPRO());
            ps.setInt(2, producto.getIDPRO());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en PacienteImpl/cambiarEstado: " + e.getMessage());
        }
    }

    @Override
    public List<Producto> listarTodos() throws Exception {
        List<Producto> lista = new ArrayList<>();
        ResultSet rs;
        String sql = "select * from PRODUCTO where ESTPRO='A' order by IDPRO desc";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto pro = new Producto();
                pro.setIDPRO(rs.getInt("IDPRO"));
                pro.setNOMPRO(rs.getString("NOMPRO"));
                pro.setPREPRO(rs.getDouble("PREPRO"));
                pro.setDESPRO(rs.getString("DESPRO"));
                pro.setESTPRO(rs.getString("ESTPRO"));
                lista.add(pro);

            }
        } catch (Exception e) {
            System.out.println("Error al listar todos)");
        } finally {
            this.cerrar();
        }
        return lista;
    }

}

//    public void cambiarEstado(Producto producto) throws Exception {
//        String sql = "UPDATE usuarios SET estado = "
//                + (producto.isEstado() == true ? "1" : "0")
//                + " WHERE id_usuario = " + producto.getIDPRO();
//        try {
//            this.conectar(false);
//            this.ejecutarOrden(sql);
//            this.cerrar(true);
//        } catch (Exception e) {
//            throw e;
//        } finally {
//        }
//    }
