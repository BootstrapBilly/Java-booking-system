package Data.Observer.Coaches;

import Backend.User.Object;

import java.util.ArrayList;

public class CoachesObserver implements Observer {

    private ArrayList<Object> objects;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject coachesGrabber;

    public CoachesObserver(Subject coachesGrabber) {

        this.coachesGrabber = coachesGrabber;
        this.observerID = ++observerIDTracker;

        coachesGrabber.register(this);
    }

    public ArrayList<Object> getUsers(){
        return this.objects;
    }

    @Override
    public void update(ArrayList<Object> objects) {
        this.objects = objects;
    }
}
