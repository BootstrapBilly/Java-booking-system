package Data.Observer.Coaches;

import Backend.User.Coach;

import java.util.ArrayList;

public class CoachesObserver implements Observer {

    private ArrayList<Coach> coaches;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject coachesGrabber;

    public CoachesObserver(Subject coachesGrabber) {

        this.coachesGrabber = coachesGrabber;
        this.observerID = ++observerIDTracker;

        coachesGrabber.register(this);
    }

    public ArrayList<Coach> getUsers(){
        return this.coaches;
    }

    @Override
    public void update(ArrayList<Coach> coaches) {
        this.coaches = coaches;
    }
}
