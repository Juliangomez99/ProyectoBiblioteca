package Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    
    /*Metodo RegistrarUsuario*/
    public boolean RegistrarUsuario(Usuario u) {
        boolean err = true;
        Conectar conec = new Conectar();
        String sql = "INSERT INTO usuarios (id_Rol, Cedula, Nombre, Apellidos, FechaN, Direccion, Telefono, Correo, Contra) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, u.getRol());
            ps.setInt(2, u.getCedula());
            ps.setString(3, u.getNombre());
            ps.setString(4, u.getApellidos());
            ps.setDate(5, u.getFechaN());
            ps.setString(6, u.getDireccion());
            ps.setString(7, u.getTelefono());
            ps.setString(8, u.getCorreo());
            ps.setString(9, u.getContra());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
                err = false;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return err;
    }
    
    /*Metodo Validar*/
    public Usuario ValidarUsuario(Usuario u) {
        Usuario v = null;
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM usuarios where Cedula = '"+u.getCedula()+"' ;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if(u.getContra().equals(rs.getString(10))){
                    u.setNombre(rs.getString(4));
                    u.setApellidos(rs.getString(5));
                    u.setCorreo(rs.getString(9));
                    u.setCedula(rs.getInt(3));
                    v = u;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return v;
    }
}
