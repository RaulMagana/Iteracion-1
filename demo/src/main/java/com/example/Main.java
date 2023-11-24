package demo.src.main.java.com.example;

import demo.src.main.java.Controller.H2DBController;
import demo.src.main.java.Model.Medicaments;

public class Main {
    public static void main(String[] args) {
         H2DBController controller = new H2DBController();
         Medicaments medicamento = new Medicaments(1, "Paracetamol");
        controller.insertarMedicamento(medicamento);
    }
}