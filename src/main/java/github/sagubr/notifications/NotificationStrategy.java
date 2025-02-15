package github.sagubr.notifications;

public interface NotificationStrategy {
    void send(Notification notification);
}

