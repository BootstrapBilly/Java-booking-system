package Data.Observer.SessionObserver;

import Backend.User.User;


public class SessionObserver implements Observer {

    private User user;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject userGrabber;

    public SessionObserver(Subject userGrabber) {

        this.userGrabber = userGrabber;
        this.observerID = ++observerIDTracker;

        userGrabber.register(this);
    }

    @Override
    public void update(User user) {
        this.user = user;
    }
}
