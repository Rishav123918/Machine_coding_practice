package factory_pattern_example;
interface Dtabaseconnection{
    void connect();
}
class mysqlconnection implements Dtabaseconnection{
    @Override
    public void connect() {
        System.out.println("connected to mysql connection");
    }
}
class oracleconnection implements Dtabaseconnection{
    @Override
    public void connect() {
        System.out.println("connected to oracle connection");
    }
}
class dbconnection{
    public static Dtabaseconnection getconnecction(String url)
    {
        if(url.contains("sql")){
            return new mysqlconnection();
        }else if(url.contains("Oracle")){
            return new oracleconnection();
        }
        throw new IllegalArgumentException("Unknown database type: " + url);
    }
}
public class main {
    public static void main(String[] args) {
        Dtabaseconnection obj=dbconnection.getconnecction("jdbc:mysql://localhost:3306/test");
        obj.connect();
        obj=dbconnection.getconnecction("jdbc:Oracle://localhost:3306/test");
        obj.connect();

    }
}
