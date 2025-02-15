package github.sagubr.notifications;

public interface NotifierStrategy {

    void send(NotifierEvent notifierEvent);

}

