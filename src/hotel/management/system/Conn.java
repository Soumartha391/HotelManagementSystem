package hotel.management.system;

import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            c = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-EGN3525:1521:xe","system","system");
            s = c.createStatement();
            
        } catch (Exception e){
            e.printStackTrace();
        }    
    }
}
