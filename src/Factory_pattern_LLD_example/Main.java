package Factory_pattern_LLD_example;
interface  Notification{
    public void notify(String msg);
}
class email_notification implements Notification{
    @Override
    public void notify(String msg) {
        System.out.println("Email Notification");
    }
}
class sms_notification implements Notification{
    @Override
    public void notify(String msg) {
        System.out.println("SMS Notifications");
    }
}

public class Main {
    public static void main(String[] args) {
       Notification_factory notificationFactory=new email_notification_factory();
       Notification notification=notificationFactory.sendnotification();
       notification.notify("Email Notifications");

       notificationFactory=new sms_notification_factory();
       notification=notificationFactory.sendnotification();
       notification.notify("SMS Notifications");

    }
}
