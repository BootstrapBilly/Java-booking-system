package Controllers;

import Views.Router.Router;

public abstract class EventHandler {

    // state managers
    private Router router = Router.getInstance();

    public void handleEvent(){ // main algorithm in template method

        setupRequiredData(); // get any data which is needed in the event handler

        updateDataStore(); // the outcome of the event, which data needs to be updated ?

        String nextRoute = handleNextRoute(); // get the next route to render

        if(nextRoute != null){
            router.setRoute(nextRoute); // re-render the next root
        }

    }

    // default implementation provided as all of these methods are optional
    public void setupRequiredData(){};
    public void updateDataStore(){};
    public String handleNextRoute(){return null;};
}
