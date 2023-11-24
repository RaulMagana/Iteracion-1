package com.example;

import Controller.H2DBController;
import Model.Medicaments;

public class Main {
    public static void main(String[] args) {
         H2DBController controller = new H2DBController();
         Medicaments medicamento = new Medicaments(1, "Paracetamol");
        controller.insertarMedicamento(medicamento);
    }
}