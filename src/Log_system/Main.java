package Log_system;
interface Logger {
    void log(String level, String message);
}
class ConsoleLogger implements Logger{
    @Override
    public void log(String level, String message) {
        //[INFO]: System started
        System.out.println("["+level+"]"+" : "+message);
    }
}

class LogService{
    private Logger logger;
    public  LogService(Logger logger){
        this.logger=logger;
    }

   private void writelogger(String level,String message){
        logger.log(level,message);
   }
   public void fun(String level,String message){
       writelogger(level, message);
   }
}



public class Main {
public static void main(String srgs[]){
    Logger logger=new ConsoleLogger();
    LogService l= new LogService(logger);
    l.fun("INFO", "System started");
    l.fun("DEBUG", "Debugging value x = 42");
    l.fun("ERROR", "Something went wrong");
}
}
