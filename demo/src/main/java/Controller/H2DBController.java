package Controller;

import Model.ConsultasH2;
import Model.Medicaments;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import View.Jtable;
import javax.swing.table.DefaultTableModel;

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
        actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == jtable.jButton1) {
            insertarMedicamento();
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