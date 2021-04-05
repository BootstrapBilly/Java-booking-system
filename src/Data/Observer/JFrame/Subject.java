package Data.Observer.JFrame;

public interface Subject {
    public void register(Observer o);
    public void unRegister(Observer o);
    public void notifyObservers();
}
