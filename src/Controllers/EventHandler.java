package Controllers;

import Views.Router.Router;

public abstract class EventHandler {
    private Router router = Router.getInstance();

    public void handleNavigation(){
        setupRequiredData();

        updateDataStore();

        String nextRoute = handleNextRoute();
        if(nextRoute != null){
            router.setRoute(nextRoute);
        }

    }

    // default implementation provided as all of these methods are optional
    public void setupRequiredData(){};
    public void updateDataStore(){};
    public String handleNextRoute(){return null;};
}
