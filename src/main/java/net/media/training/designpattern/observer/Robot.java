package net.media.training.designpattern.observer;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 10:16:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Robot implements Subscriber {
    private boolean outdoors;
    private boolean feelingWarm;
    private boolean feelingTired;
    private Observable sun;

    public Robot(Observable sun) {
        this.sun = sun;
    }

    public boolean isOutdoors() {
        return outdoors;
    }

    public void notifySunRose() {
        feelingWarm = true;
    }

    public void notifySunSet() {
        feelingWarm = false;
        if (outdoors)
            feelingTired = true;
    }

    public void goOutdoors() {
        outdoors = true;
        sun.addSubscriber("sunrise", this);
        sun.addSubscriber("sunset", this);
    }

    public void goIndoors() {
        outdoors = false;
        sun.removeSubscriber("sunrise", this);
        sun.removeSubscriber("sunset", this);
    }

    public boolean isFeelingWarm() {
        return feelingWarm;
    }

    public boolean isFeelingTired() {
        return feelingTired;
    }
}
