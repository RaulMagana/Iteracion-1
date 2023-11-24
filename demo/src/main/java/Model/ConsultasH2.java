package demo.src.main.java.Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ConsultasH2 {
    
    public void insertarMedicamento(Medicaments medicamento) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicamentos (nombre, descripcion) VALUES (?, ?)")) {

            preparedStatement.setString(1, medicamento.getNombre());
            preparedStatement.setString(2, medicamento.getDescripcion());

            preparedStatement.executeUpdate();

            System.out.println("Medicamento insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        private Connection getConnection() {
            Conexion conexion = new Conexion();
            return conexion.getConexion();
        }
        
    }
}
