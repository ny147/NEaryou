
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bathroom extends OurFrame {

    private JLabel NoteLabel, CraftLabel, KitchenRoomLabel;
    private ImageSet backgroundImg;
    private Player pt;
    private LivingRoom LVR;
    private bathroom Bt = this;

    public bathroom(LivingRoom l) {
        super("bathroom");

        LVR = l;
        pt = LVR.getplayer();
        contentpane.setLayout(new BorderLayout());

        addcomponent();

    }

    @Override
    public void addcomponent() {
        backgroundImg = new ImageSet("resource/test.jpg").resize(1366, 618);

        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);

        NoteLabel = new JLabel(new ImageSet("resource/piano.png"));
        NoteLabel.setBounds(100, 100, 388, 300);

        KitchenRoomLabel = new JLabel(new ImageSet("resource/back.png"));
        KitchenRoomLabel.setBounds(100, 50, 64, 64);
        drawpane.add(NoteLabel);
        drawpane.add(KitchenRoomLabel);

        addListener();

        contentpane.add(drawpane, BorderLayout.CENTER);
        contentpane.add(pt.getPane(), BorderLayout.PAGE_START);
        validate();

    }

    public void addListener() {
        NoteLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                //pt.getItem(0).setIcon(null);
                new Hint("Note", Bt).setVisible(true);
                setVisible(false);

            }

        });
        KitchenRoomLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                setVisible(false);
                LVR.setVisible(true);
                LVR.updatePane();

            }

        });

    }

}

class Hint extends OurFrame {

    private ImageSet HintImg;
    private JLabel HintLabel, BackLabel;
    private bathroom Bt;

    public Hint(String n, bathroom b) {
        super("Hint");
        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.DARK_GRAY);
        HintLabel = new JLabel(HintImg);
        Bt = b;

        if (n.equals("Note")) {
            SetNoteImg();
        }
        if (n.equals("Craft")) {
            SetCraftImg();
        }
        addcomponent();
    }

    public void addcomponent() {

        drawpane = new JLabel();
        drawpane.setBackground(Color.DARK_GRAY);
        drawpane.setLayout(null);

        BackLabel = new JLabel(new ImageSet("resource/back.png"));
        BackLabel.setBounds(0, 0, 64, 64);
        
        addListener();
        drawpane.add(HintLabel);
        drawpane.add(BackLabel);
        contentpane.add(drawpane, BorderLayout.CENTER);
        validate();

    }

    public void addListener() {

        BackLabel.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                Bt.setVisible(true);  
                dispose();
                    
            }

        });

    }

    public void SetNoteImg() {
        HintLabel.setIcon(new ImageSet("resource/piano.png"));
        HintLabel.setBounds(500, 500, 300, 300);
    }

    public void SetCraftImg() {
        HintLabel.setIcon(new ImageSet("resource/back.png").resize(300, 300));
        HintLabel.setBounds(500, 500, 300, 300);

    }

}
