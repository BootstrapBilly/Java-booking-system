package Data.Managers.JFrame;

public class JFrame {
    // this makes the JFrame container globally available, so the router and append the required screen to it on the fly
    private static JFrameManager uniqueInstance;

    private JFrame(){};

    public static JFrameManager getInstance(){
        if(uniqueInstance == null){
            JFrameManager jFrameManager = new JFrameManager();
            uniqueInstance = jFrameManager;
        }
        return uniqueInstance;
    }
}