
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LivingRoom extends OurFrame {

    private LivingRoom LVR = this;
    private ImageSet backgroundImg, MusicBoxImg, TVImg;
    private JLabel MusicBoxLabel, TVLabel,PillowLabel,TabeLabel,KitchenRoomLabel;
    private Player pt;
    private boolean Tapelost;
    private int Xx,Yy;
   
    
    public LivingRoom() {
        super("Living room");
        pt = new Player("Pete");
        setIconImage(new ImageSet("resource/logo.png").getImage());
        contentpane.setLayout(new BorderLayout());
        
        Tapelost =false;
        addcomponent();

    }

    public void addcomponent() {
        backgroundImg = new ImageSet("resource/test.jpg").resize(1366, 618);
        MusicBoxImg = new ImageSet("resource/piano.png");

       /* Playerpane = new JPanel();
        Playerpane.setPreferredSize(new Dimension(1366,150));
        Playerpane.setBackground(Color.DARK_GRAY);
        Playerpane.setLayout(new FlowLayout(FlowLayout.LEADING));*/
        
        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);
        
        
        KitchenRoomLabel = new JLabel(new ImageSet("resource/back.png"));
        KitchenRoomLabel.setBounds(1280, 0, 64, 64);
      
        MusicBoxLabel = new JLabel(MusicBoxImg);
        MusicBoxLabel.setBounds(867, 392, 322, 86);

        TVLabel = new JLabel(new ImageSet("resource/TV.png").resize(300, 300));
        TVLabel.setBounds(638, 43, 300, 300);
        
        PillowLabel = new JLabel(new ImageSet("resource/pillow.png"));
        PillowLabel.setBounds(100, 400, 298, 200);
        
        TabeLabel = new JLabel(new ImageSet("resource/tape.png"));
        TabeLabel.setBounds(100, 500, 175, 100);
        
        addListener();

        //addItemListener(KeyLabel);
        
        drawpane.add(MusicBoxLabel);
        drawpane.add(TVLabel);
        drawpane.add(PillowLabel);
        drawpane.add(TabeLabel);
        drawpane.add( KitchenRoomLabel);


        
       // drawpane.add(Playerpane);
        contentpane.add(drawpane, BorderLayout.CENTER);
        contentpane.add(pt.getPane(),BorderLayout.PAGE_START);
        validate();

    }
    public void updatePane(){
    contentpane.add(pt.getPane(),BorderLayout.PAGE_START);
     validate();
     repaint();
    }
   /*public void addItemListener(JLabel item ){
      
    JLabel test = new JLabel(new ImageSet("resource/back.png"));
    test.setBounds(0, 0,64, 64);
    test.setVisible(false);
    drawpane.add(test);
    item.addMouseListener( new MouseAdapter(){
     public void mousePressed(MouseEvent e) {
               
               test.setVisible(true);
                
                //test.setLocation(0, 0);
            }
    });
    test.addMouseListener( new MouseAdapter(){
     public void mousePressed(MouseEvent e) {
                 xi = e.getX();
                 yi = e.getY();
                
              
            }
    });
   test.addMouseMotionListener( new MouseMotionAdapter(){
    public void mouseDragged(MouseEvent e) {
                
                int x =  e.getXOnScreen();
                int y =  e.getYOnScreen();
                
                int SumX = x - xi - 64;
                int SumY = y - yi - 64;
                test.setBounds(SumX, SumY, 64, 64);
                 System.out.printf("x = %d  y = %d xi =  %d  yi =  %d\n",x,y,xi,yi);
              if(test.getBounds().intersects(PillowLabel.getBounds())){
               
                  drawpane.remove(test);
                  Playerpane.remove(item);
                  validate();
        }
              
                
               
            }
    
    
    
    
    
    });
    
    }*/

    public void addListener() {
        
        PillowLabel.addMouseListener(new MouseAdapter(){
           

            @Override
            public void mousePressed(MouseEvent e) {
                 Xx = e.getX();
                Yy = e.getY();
            }

           
           
        
        });
        
        
       PillowLabel.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                
                int x =  e.getXOnScreen();
                int y =  e.getYOnScreen();
                int SumX = x - Xx - 298;
                //System.out.printf(" x = %d  Xx = %d Sum x = %d\n",x,Xx,SumX);
                //PillowLabel.setLocation(x - Xx - 298,400);
                if(SumX <0){
                
                }else if(SumX > 300){
                
                }else PillowLabel.setLocation(x - Xx - 298,400);
                //validate();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                
            }
        
        
        
        });
        MusicBoxLabel.addMouseListener(new MouseAdapter() {
           
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
               
                new Musicpuzzle(LVR).setVisible(true);
                // new TV().setVisible(true);

            }

            

        });
        TVLabel.addMouseListener(new MouseAdapter() {
           
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new TV().setVisible(true);
            }

         

        });
        TabeLabel.addMouseListener(new MouseAdapter(){
           

            @Override
            public void mousePressed(MouseEvent e) {
                if(Tapelost == true){
                 TabeLabel.setIcon(null);
                 pt.getItem(1).setIcon(null);
                }
                
                
            }

           
        
        });
        KitchenRoomLabel.addMouseListener( new MouseAdapter(){
        
        
        
          public void mousePressed(MouseEvent e) {
                setVisible(false);
                
                new bathroom(LVR).setVisible(true);
            }
        
        
        
        });
        
        pt.getRadio(1).addItemListener(new ItemListener(){
          
            public void itemStateChanged(ItemEvent e) {
               if(e.getStateChange() == 1){
               Tapelost =true;
               
               }
            }
         
         
         });
         
        
         
         

    }
    public Player getplayer(){
        return pt;
    }
    public static void main(String args[]) {

        new LivingRoom();
    }
}
// Auxiliary class to resize image

class Musicpuzzle extends OurFrame {

    private LivingRoom LVR;

    private JLabel MusicpianoLabel, BackLabel;
    private ImageSet backgroundImg, MusicBoxImg, BacktImg;
    private SoundEffect pianosound;

    /* private int frameWidth = 1366, frameHeight = 768;
    private boolean visible = true;*/
    public Musicpuzzle(LivingRoom L) {
        super("Puzzle Music");
        LVR = L;

        /*setTitle("Puzzle Music");
        setBounds(50, 50, frameWidth, frameHeight);
        setResizable(false);
        setVisible(visible);
        setLocationRelativeTo(null); // set middle Display
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);*/
        // MusicPanel =(JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.DARK_GRAY);

        addcomponent();
    }

    public void addcomponent() {

        // backgroundImg = new MyImageIcon("resource/test.jpg");
        MusicBoxImg = new ImageSet("resource/piano.jpg");
        pianosound = new SoundEffect("music/beep.wav");
        BacktImg = new ImageSet("resource/back.png");
        drawpane = new JLabel();
        //Musicdrawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);

        MusicpianoLabel = new JLabel(MusicBoxImg);
        MusicpianoLabel.setBounds(400, 200, 626, 397);

        BackLabel = new JLabel(BacktImg);
        BackLabel.setBounds(0, 0, 64, 64);
        addListener();
        //MusicPanel.add(Musicdrawpane);
        drawpane.add(MusicpianoLabel);
        drawpane.add(BackLabel);

        contentpane.add(drawpane, BorderLayout.CENTER);

        validate();

    }

    public void addListener() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_T) {
                    System.out.println("hello");
                    pianosound.playOnce();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
        BackLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                LVR.setVisible(true);
                //setVisible(false);
                dispose();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        
       
    }

}

class TV extends OurFrame {

    private JLabel TVLabel, TVnextLabel, TVbackLabel, TVpicture;
    private int ChannelPicture = 0;
    private ImageSet[] picture;

    public TV() {
        super("TV Channel");
        /* setTitle("TV Channel");
        setBounds(50, 50, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null); // set middle Display
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);*/

        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.DARK_GRAY);
        addcomponent();

    }

    public void addcomponent() {

        picture = new ImageSet[3];
        picture[0] = new ImageSet("resource/logo.png").resize(500, 300);
        picture[1] = new ImageSet("resource/test.jpg").resize(500, 300);
        picture[2] = new ImageSet("resource/musicbox.jpg").resize(500, 300);
        drawpane = new JLabel();
        drawpane.setLayout(null);

        TVpicture = new JLabel(picture[0]);
        TVpicture.setBounds(400, 200, 500, 300);

        TVLabel = new JLabel(new ImageSet("resource/TV.png"));
        TVLabel.setBounds(0, 0, 694, 429);
        TVLabel.add(TVpicture);
        //TVLabel.add();
        TVnextLabel = new JLabel(new ImageSet("resource/back.png"));
        TVnextLabel.setBounds(0, 0, 69, 69);

        TVbackLabel = new JLabel(new ImageSet("resource/back.png"));
        TVbackLabel.setBounds(0, 0, 69, 69);
        addListener();
        contentpane.add(TVbackLabel, BorderLayout.LINE_START);
        contentpane.add(TVnextLabel, BorderLayout.LINE_END);
        contentpane.add(TVLabel, BorderLayout.CENTER);

        // TVPanel.add(TVLabel,BorderLayout.CENTER);
        validate();
    }

    public void addListener() {
        TVbackLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (ChannelPicture > 0) {
                    --ChannelPicture;
                    TVpicture.setIcon(picture[ChannelPicture]);
                    //validate();
                }

                //validate();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        TVnextLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (ChannelPicture < 2) {
                    ++ChannelPicture;
                    TVpicture.setIcon(picture[ChannelPicture]);
                    //validate();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

    }

}

