import java.awt.event.*;

import javax.swing.*;

public class View {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1100,600);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setLocation(200,100);
        frame.setVisible(true);
	}
	

}
