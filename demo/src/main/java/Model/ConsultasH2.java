package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Database.Conexion;
import Excepciones.Excepciones;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConsultasH2 {

    public List<Medicaments> medicamentosEncontrados(Medicaments parametro) {
        List<Medicaments> medicamentos = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicamentos WHERE nombre LIKE ?")) {
                
            preparedStatement.setString(1, "%" + parametro.getName() + "%");
    
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                Medicaments medicamento = new Medicaments();
                medicamento.setId(resultSet.getInt("id"));
                medicamento.setName(resultSet.getString("nombre"));
                medicamentos.add(medicamento);
            }
        } catch (Exception e) {
        
            throw new Excepciones(e.getMessage());

           
        }
        return medicamentos;
    }
    public boolean reiniciarId() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("ALTER TABLE medicamentos ALTER COLUMN id RESTART WITH 1")) {

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean borrarTodosLosMedicamentos() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM medicamentos")) {

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
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

    public boolean eliminarMedicamento(Medicaments medicamento) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM medicamentos WHERE id = ?")) {

            preparedStatement.setInt(1, medicamento.getId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean actualizarMedicamento(Medicaments medicamento) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE medicamentos SET nombre = ? WHERE id = ?")) {

            preparedStatement.setString(1, medicamento.getName());
            preparedStatement.setInt(2, medicamento.getId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public Medicaments buscarMedicamento(Medicaments medicamento) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicamentos WHERE id = ?")) {

            preparedStatement.setInt(1, medicamento.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                medicamento.setName(resultSet.getString("nombre"));
                return medicamento;
            } else {
                throw new Excepciones();
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
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