package Excepciones;

public class Excepciones extends RuntimeException {

     public Excepciones(String message) {
        super(message);
    }

     public Excepciones() {
        super("NO SE ENCONTRO EL MEDICAMENTO");
    }


   
    
}
