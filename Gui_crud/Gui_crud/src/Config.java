import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    public static Connection getConnection(){
        Connection conn = null;
        try{

            String url ="jdbc:sqlserver://localhost:1433;databaseName=UserDB;encrypt=true;trustServerCertificate=true";
            String user ="PABASARAMADHAWA";
            String password ="PABASARAMADHAWA";

            conn = DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
