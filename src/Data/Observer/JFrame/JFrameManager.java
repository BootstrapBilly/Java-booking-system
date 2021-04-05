package Data.Observer.JFrame;

import javax.swing.*;
import java.util.ArrayList;

public class JFrameManager implements Subject {

    private ArrayList<Data.Observer.JFrame.Observer> observers;
    private JFrame appContainer;

    public JFrameManager() {
        observers = new ArrayList<Data.Observer.JFrame.Observer>();
    }

    @Override
    public void register(Data.Observer.JFrame.Observer o) {
        observers.add(o);
    }

    @Override
    public void unRegister(Data.Observer.JFrame.Observer o) {
        int toBeDeletedIndex = observers.indexOf(o);
        observers.remove(toBeDeletedIndex);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs : observers){
            obs.update(appContainer);
        }
    }
    public void setJframe(JFrame jFrame){ this.appContainer = jFrame; }
    public JFrame getJFrame(){
        return this.appContainer;
    }

}
