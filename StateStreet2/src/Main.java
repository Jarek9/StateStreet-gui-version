import javax.swing.JFrame;

import java.io.IOException;

public class Main {

   

    public static void main(String[] args) throws IOException {
    	
    	Gui gui = new Gui();
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setSize(800, 530);
        gui.setResizable(false);
        gui.setTitle("STATE STREET FILE SEARCHER");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        
    }
    
    
    
}

