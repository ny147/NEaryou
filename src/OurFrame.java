
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


abstract class OurFrame extends JFrame {

    private int frameWidth = 1366, frameHeight = 768;
    protected JLabel drawpane;
    protected JPanel contentpane,Setpane,Playerpane;
    

    public OurFrame(String s) {
        setTitle(s);
        setBounds(50, 50, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null); // set middle Display
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        contentpane = (JPanel) getContentPane();
        
        //set your Layout in your own constructor class 
        //Example
        /*
        
        contentpane.setLayout(new BorderLayout());
        
        
        
        */

    }

    public void addcomponent() { /* add for your JLabel JPanel */}

    public void addListener() { /* add your Event */}
}
