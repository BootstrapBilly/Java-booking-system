package Data.Singleton;

import Data.Observer.SessionObserver.SessionManager;

public class Session {
    private static SessionManager uniqueInstance;

    private Session(){};

    public static SessionManager getInstance(){
        if(uniqueInstance == null){
            SessionManager sessionManager = new SessionManager();
            uniqueInstance = sessionManager;
        }
        return uniqueInstance;
    }
}