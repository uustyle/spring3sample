package sample;
import org.hsqldb.server.Server;


public class HsqlDbStart {
    public static void main(String[] args) throws Exception {
        Server.main(new String[]{
                "--database.0", 
                "file:./db/sample", 
                "--dbname.0", 
                "sample"
                });
    }
}
