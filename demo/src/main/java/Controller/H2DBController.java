package Controller;

import Model.ConsultasH2;
import Model.Medicaments;

public class H2DBController {

    private ConsultasH2 consultasH2;

    public H2DBController() {
        this.consultasH2 = new ConsultasH2();
    }

    public void insertarMedicamento(Medicaments medicamento) {
        consultasH2.insertarMedicamento(medicamento);
    }
}