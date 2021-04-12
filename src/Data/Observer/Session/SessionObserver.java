package Data.Observer.Session;

import Models.User.User;

public class SessionObserver implements Observer {

    private User user;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject sessionGrabber;

    public SessionObserver(Subject sessionGrabber) {

        this.sessionGrabber = sessionGrabber;
        this.observerID = ++observerIDTracker;

        sessionGrabber.register(this);
    }

    @Override
    public void update(User user) {
        this.user = user;
    }
}
