package Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Interfaces.Main;

public class sql {

    public int auto_increment(String sql) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conectar db = new Conectar();
        try {
            ps = db.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("idmaximo" + ex.getMessage());
            id = 1;
        } finally {
            try {
                ps.close();
                rs.close();
                db.desconectar();
            } catch (Exception ex) {
            }
        }
        return id;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.setVisible(true);
    }

}
