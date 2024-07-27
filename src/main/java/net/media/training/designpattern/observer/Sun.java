package net.media.training.designpattern.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 9:12:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sun implements Observable {
    private boolean isUp;
    Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public Sun() {
        subscribers.put("sunrise", new ArrayList<>());
        subscribers.put("sunset", new ArrayList<>());
    }

    public boolean isUp() {
        return isUp;
    }

    public void set() {
        isUp = false;
        notify("sunset");
    }

    public void rise() {
        isUp = true;
        notify("sunrise");
    }

    @Override
    public void addSubscriber(String eventType, Subscriber listener) {
        List<Subscriber> users = subscribers.get(eventType);
        users.add(listener);
    }

    @Override
    public void removeSubscriber(String eventType, Subscriber listener) {
        List<Subscriber> users = subscribers.get(eventType);
        users.remove(listener);
    }

    private void notify(String eventType) {
        List<Subscriber> users = subscribers.get(eventType);
        for (Subscriber subscriber : users) {
            if (eventType.equals("sunrise")) {
                subscriber.notifySunRose();
            } else if (eventType.equals("sunset")) {
                subscriber.notifySunSet();
            }
        }
    }
}