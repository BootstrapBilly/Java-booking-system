package Data.Observer.JFrame;

import javax.swing.*;

public class JFrameObserver implements Observer {

    private JFrame jFrame;

    private static int observerIDTracker = 0;

    private int observerID;

    private Data.Observer.JFrame.Subject jFrameGrabber;

    public JFrameObserver(Subject jFrameGrabber) {

        this.jFrameGrabber = jFrameGrabber;
        this.observerID = ++observerIDTracker;

        jFrameGrabber.register(this);
    }

    @Override
    public void update(JFrame jFrame) {
        this.jFrame = jFrame;
    }
}
