package Controller;

import Model.ConsultasH2;
import Model.Medicaments;
import View.Jtable;
import java.util.List;

public class H2DBController {

    private ConsultasH2 consultasH2;
    private Jtable jtable;
    private List<Medicaments> medicamentos;

    public H2DBController() {
        this.consultasH2 = new ConsultasH2();
        this.jtable = new Jtable();
    }

    public void insertarMedicamento(Medicaments medicamento) {
        consultasH2.insertarMedicamento(medicamento);
    }

    public void tablaMedicamentos() {
        consultasH2.tablaMedicamentos();
    }

    public void mostrarVentana() {
        jtable.setVisible(true);
    }

  
   
}