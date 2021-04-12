package Views.Util;

import javax.swing.*;

public class Methods {
    public static void setFontSize(JLabel component, float size){
        component.setFont(component.getFont().deriveFont(size));
    };
}
