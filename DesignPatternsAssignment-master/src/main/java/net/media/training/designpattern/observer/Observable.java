package net.media.training.designpattern.observer;

public interface Observable {
    void addSubscriber(String event, Subscriber subscriber);
    void removeSubscriber(String event, Subscriber subscriber);
}
