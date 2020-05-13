import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class View extends JFrame{

    public static View view;

    public static void windowSetup(){
        view = new View();
        view.setSize(1100,600);
        view.setBackground(Color.BLACK);
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        view.setLocation(200,100);
        view.setVisible(true);
    }


}
