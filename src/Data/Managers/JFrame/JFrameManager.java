package Data.Managers.JFrame;

import Views.Main;

public class JFrameManager {

    private Main appContainer;

    public JFrameManager() {}

    public void setJframe(Main jFrame){ this.appContainer = jFrame; }
    public Main getJFrame(){
        return this.appContainer;
    }

}
