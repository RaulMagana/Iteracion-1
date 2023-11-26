package com.example;

import Controller.H2DBController;
import Model.ConsultasH2;
import Model.Medicaments;
import View.Jtable;

public class Main {
    public static void main(String[] args) {
        
         Medicaments medicamento = new Medicaments();
        ConsultasH2 consultasH2 = new ConsultasH2();
        Jtable jtable = new Jtable();
        H2DBController controller = new H2DBController(medicamento, consultasH2, jtable);
        controller.mostrarVentana();
        var medicamentos = consultasH2.tablaMedicamentos();
    }
}