package demo.src.main.java.Database;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class Conexion {
    private Connection con = null;

    public Connection getConexion() {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("demo/src/main/java/Database/app.properties");
            properties.load(fileInputStream);
            con = (Connection)DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password")); 
            if(con != null){
                System.out.println("Conexion exitosa");
            }
            else{
                System.out.println("Conexion fallida");
            }

        } catch (Exception e) {
            System.out.println("Error en la conexion");
            e.printStackTrace();
        }
        return con;
    }
    
}
