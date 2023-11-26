package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Database.Conexion;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import org.h2.table.Table;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import View.Jtable;
import javax.swing.JOptionPane;

public class ConsultasH2 {
    
    public boolean insertarMedicamento(Medicaments medicamento) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicamentos (nombre) VALUES (?)")) {

            preparedStatement.setString(1, medicamento.getName());  // Corregido a getName()

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Medicaments> tablaMedicamentos() {
        List<Medicaments> listita = new ArrayList<>();
         System.out.println("Tabla medicamentos:");


        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicamentos")) {
                ResultSet resultSet = preparedStatement.executeQuery(); {

                    System.out.println("Tabla de Medicamentos:");
                    System.out.println("ID\tNombre");
                    

                        while (resultSet.next()) {
                            Medicaments medicamentotemporale = new Medicaments();
                            medicamentotemporale.setId(resultSet.getInt("ID"));
                            medicamentotemporale.setName(resultSet.getString("nombre"));
                            listita.add(medicamentotemporale);                  
                            System.out.println(medicamentotemporale.getId() + "\t" + medicamentotemporale.getName());
                        }
                  
            preparedStatement.executeQuery();
            
        }
    }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la tabla Medicamentos.");
            e.printStackTrace();
        }
        return listita;
    }

    

    private Connection getConnection() {
        Conexion conexion = new Conexion();
        return conexion.getConexion();
    }
}