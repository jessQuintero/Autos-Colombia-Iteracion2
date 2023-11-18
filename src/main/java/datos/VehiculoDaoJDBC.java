package datos;

import dominio.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDaoJDBC {

    private static final String SQL_SELECT = "SELECT * FROM vehiculos";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM vehiculos WHERE id=?";
    private static final String SQL_INSERT = "INSERT INTO vehiculos (placa, color, marca, modelo) VALUES(?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE vehiculos set placa=?, color=?, marca=?, modelo=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM vehiculos WHERE id=?";
    //private Conexion conexion;

    public List<Vehiculo> listar() throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Vehiculo vehiculo = null;
        List<Vehiculo> vehiculos = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String placa = rs.getString("placa");
                String color = rs.getString("color");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");

                vehiculo = new Vehiculo(id, placa, color, marca, modelo);
                vehiculos.add(vehiculo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vehiculos;
    }

    public Vehiculo encontrar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, vehiculo.getId());
            rs = stmt.executeQuery();
            rs.next();//nos posicionamos en el primer registro devuelto

            String placa = rs.getString("placa");
            String color = rs.getString("color");
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");

            vehiculo.setPlaca(placa);
            vehiculo.setColor(color);
            vehiculo.setMarca(marca);
            vehiculo.setModelo(modelo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vehiculo;
    }

    public int insertar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getColor());
            stmt.setString(3, vehiculo.getMarca());
            stmt.setString(4, vehiculo.getModelo());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getColor());
            stmt.setString(3, vehiculo.getMarca());
            stmt.setString(4, vehiculo.getModelo());

            stmt.setInt(5, vehiculo.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vehiculo.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

}
