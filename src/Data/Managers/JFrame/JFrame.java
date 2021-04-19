package Data.Managers.JFrame;

import Data.Managers.JFrame.JFrameManager;

public class JFrame {
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