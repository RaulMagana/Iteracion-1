package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Database.Conexion;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ConsultasH2 {
    
    public void insertarMedicamento(Medicaments medicamento) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicamentos (nombre) VALUES (?)")) {

            preparedStatement.setString(1, medicamento.getName());  // Corregido a getName()

            preparedStatement.executeUpdate();

            System.out.println("Medicamento insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Medicaments> tablaMedicamentos() {


        Medicaments medicamentotemporale = new Medicaments(0, "");
        
       

        List<Medicaments> listita = new ArrayList<>();

         System.out.println("Tabla medicamentos:");
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicamentos")) {
                ResultSet resultSet = preparedStatement.executeQuery(); {

                    System.out.println("Tabla de Medicamentos:");
                    System.out.println("ID\tNombre");
                    
                    while (resultSet.next()) {
                         medicamentotemporale.setId(resultSet.getInt("ID"));
                        medicamentotemporale.setName(resultSet.getString("nombre"));
                        listita.add(medicamentotemporale);
                        System.out.println(medicamentotemporale.getId() + "\t" + medicamentotemporale.getName());
                    }
            preparedStatement.executeQuery();
            
        }
    }catch (SQLException e) {
            
            e.printStackTrace();
        }
        return listita;
    }

    

    private Connection getConnection() {
        Conexion conexion = new Conexion();
        return conexion.getConexion();
    }
}