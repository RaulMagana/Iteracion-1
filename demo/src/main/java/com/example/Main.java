package demo.src.main.java.com.example;
import demo.src.main.java.Controller.H2DBController;
import demo.src.main.java.Model.ConsultasH2;
import demo.src.main.java.Model.Medicaments;


public class Main {
    public static void main(String[] args) {
        ConsultasH2 consultasH2 = new ConsultasH2();
        consultasH2.insertarMedicamento(new Medicaments(1, "Medicamento Ejemplo", "Descripción del medicamento"));
    }
}