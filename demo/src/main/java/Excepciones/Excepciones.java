package Excepciones;

public class Excepciones extends Exception {

     public Excepciones() {
        super("NO SE ENCONTRO EL MEDICAMENTO");
    }


    public Excepciones(String message) {
        super(message);
    }
    
}
