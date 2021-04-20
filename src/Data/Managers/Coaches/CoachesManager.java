package Data.Managers.Coaches;

import Models.User.Coach;

import java.util.ArrayList;
import java.util.Iterator;

public class CoachesManager {

    private ArrayList<Coach> coaches;
    private Coach selectedCoach;

    public CoachesManager() {
        coaches = new ArrayList<Coach>();
    }

    public void addCoach(Coach coach){
        this.coaches.add(coach);

    }

    public ArrayList<Coach> getCoaches(){
        return this.coaches;
    }

    public Coach getCoachById(String ID){
        Iterator<Coach> coachIterator = this.coaches.iterator();
        while(coachIterator.hasNext()){
            Coach next = coachIterator.next();
            if(next.getID() == ID){
                return next;
            }
        }

        return null;
    }

    public Coach getSelectedCoach() {
        return selectedCoach;
    }

    public void setSelectedCoach(Coach selectedCoach) {
        this.selectedCoach = selectedCoach;
    }
}
