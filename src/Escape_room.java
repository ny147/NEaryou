
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static sun.net.www.http.HttpClient.New;

public class Escape_room  extends OurFrame{

    private ImageSet backgroundImg,StartImg,InfoImg;
    private JLabel StartLabel,InfoLabel;
    private JButton StartButton;
    
     public Escape_room() {
        super("menu");
        
        contentpane.setLayout(new BorderLayout());
        addcomponent();
    }
     
     public void addcomponent(){
         backgroundImg = new ImageSet("resource/test.jpg");
         StartImg = new ImageSet("resource/back.png");
         InfoImg = new ImageSet("resource/back.png");
         
         drawpane = new JLabel(backgroundImg);
         drawpane.setLayout(null);
        
         
         
         StartButton = new JButton();
         StartButton.setBounds(550, 303, 300, 50);
        
         StartButton.setText("Start");
         StartButton.setHorizontalTextPosition(JButton.CENTER);
         StartButton.setVerticalTextPosition(JButton.CENTER);
         StartButton.setFont(new Font("Times New Roman",Font.BOLD,25));
         StartButton.setForeground(Color.white);
         StartButton.setBackground(Color.DARK_GRAY);
         
         StartButton.setFocusable(false);
         
         InfoLabel = new JLabel(InfoImg);
         InfoLabel.setBounds(649,453, 64,64);
         
         drawpane.add(StartButton);
         drawpane.add(InfoLabel);
         addlistener();
         
         
         contentpane.add(drawpane,BorderLayout.CENTER);
       
         
        
         validate();
     
     }
    
    
    public void addlistener(){
    
        StartButton.addActionListener( new ActionListener(){
           
            public void actionPerformed(ActionEvent e) {
               new LivingRoom();
               dispose();
            }
    
    
    
    
    
    
    });
      
    
    
    
    
    
    
    

    
    
    
    
    }
    public static void main(String[] args) {
        new Escape_room();
    }

   
}
