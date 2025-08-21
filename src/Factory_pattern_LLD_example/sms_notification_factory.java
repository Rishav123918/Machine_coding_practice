package Factory_pattern_LLD_example;

public class sms_notification_factory extends Notification_factory{
    @Override
    public Notification sendnotification() {
        return new sms_notification();
    }
}
