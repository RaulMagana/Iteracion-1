package Controller;

import Model.ConsultasH2;
import Model.Medicaments;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.Jtable;


public class H2DBController implements ActionListener {
    private final Medicaments medicaments;
    private final ConsultasH2 consultasH2;
    private final Jtable jtable;

    public H2DBController(Medicaments medicaments, ConsultasH2 consultasH2, Jtable jtable) {
        this.medicaments = medicaments;
        this.consultasH2 = consultasH2;
        this.jtable = jtable;
        this.jtable.jButton1.addActionListener(this);
        this.jtable.jButton2.addActionListener(this);
        this.jtable.jButton3.addActionListener(this);
        this.jtable.jButton4.addActionListener(this);
        this.jtable.jButton5.addActionListener(this);
        this.jtable.jButton6.addActionListener(this);
        actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == jtable.jButton1) {
            insertarMedicamento();
        }else if (source == jtable.jButton3) {
            eliminarMedicamento();
        } else if (source == jtable.jButton4) {
            actualizarMedicamento();
        } else if (source == jtable.jButton2) {
            buscarMedicamento();
        }else if (source == jtable.jButton5) {
            borrarTodosLosMedicamentos();
        }else if (source == jtable.jButton6) {
            reiniciarId();
        }

    }

    

    private void reiniciarId() {
        int confirmacion = JOptionPane.showConfirmDialog(jtable, "¿Estas seguro de reiniciar el ID?");
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (consultasH2.reiniciarId()) {
                JOptionPane.showMessageDialog(jtable, "ID reiniciado correctamente");
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(jtable, "No se pudo reiniciar el ID");
            }
        }
    }

    public void borrarTodosLosMedicamentos() {
        int confirmacion = JOptionPane.showConfirmDialog(jtable, "¿Estas seguro de borrar todos los medicamentos?");
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (consultasH2.borrarTodosLosMedicamentos()) {
                JOptionPane.showMessageDialog(jtable, "Medicamentos borrados correctamente");
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(jtable, "No se pudo borrar los medicamentos");
            }
        }
    }

    private void actualizarTabla(){
        List<Medicaments> medicamentos = consultasH2.tablaMedicamentos();
        jtable.actualizarTabla(medicamentos);

  }

    public void tablaMedicamentos() {
        consultasH2.tablaMedicamentos();
        actualizarTabla();
    }


    private void insertarMedicamento() {
        obtenerMedicamentoDesdeVista();
        if (consultasH2.insertarMedicamento(medicaments)) {
            JOptionPane.showMessageDialog(jtable, "Medicamento agregado correctamente");
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(jtable, "No se pudo agregar el medicamento");
        }
    }

    private void eliminarMedicamento() {
        obtenerMedicamentoDesdeVista();
        if (medicaments.getId() > 0) {
            if (consultasH2.eliminarMedicamento(medicaments)) {
            JOptionPane.showMessageDialog(jtable, "Medicamento eliminado correctamente");
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(jtable, "No se pudo eliminar el medicamento");
        }
        }else{
            JOptionPane.showMessageDialog(jtable, "ID INVALIDO");
        }
    }

    private void actualizarMedicamento() {
        obtenerMedicamentoDesdeVista();
       if(medicaments.getId() > 0){
        if (consultasH2.actualizarMedicamento(medicaments)) {
            JOptionPane.showMessageDialog(jtable, "Medicamento actualizado correctamente");
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(jtable, "No se pudo actualizar el medicamento");
        }
    }else{
        JOptionPane.showMessageDialog(jtable, "ID INVALIDO");
    }
}
    private void buscarMedicamento() {
        obtenerMedicamentoDesdeVista();
    List<Medicaments> resultadosBusqueda = consultasH2.medicamentosEncontrados(medicaments);
    if (!resultadosBusqueda.isEmpty()) {
        JOptionPane.showMessageDialog(jtable, "Medicamento encontrado");
        jtable.actualizarTabla(resultadosBusqueda);
    }
    }

    


    private void obtenerMedicamentoDesdeVista(){
        medicaments.setName(jtable.jTextField2.getText());
    }

    private void llenarVistaDesdeMedicamento() {
        jtable.jTextField1.setText(String.valueOf(medicaments.getId()));
        jtable.jTextField2.setText(medicaments.getName());
    }

    public void mostrarVentana() {
        jtable.setVisible(true);
    }

  
   
}