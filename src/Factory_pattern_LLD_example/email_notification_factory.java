package Factory_pattern_LLD_example;

public class email_notification_factory extends Notification_factory{
    @Override
    public Notification sendnotification() {
        return new email_notification();
    }
}
