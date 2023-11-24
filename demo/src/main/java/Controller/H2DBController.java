package demo.src.main.java.Controller;

import demo.src.main.java.Model.ConsultasH2;
import demo.src.main.java.Model.Medicaments;

public class H2DBController {

    private ConsultasH2 consultasH2;

    public H2DBController() {
        this.consultasH2 = new ConsultasH2();
    }

    public void insertarMedicamento(Medicaments medicamento) {
        consultasH2.insertarMedicamento(medicamento);
    }
}