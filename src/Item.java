
import javax.swing.*;


public class Item extends JLabel{

    private String name;
    private ImageSet Img;
    private int amount;
    
    public Item(String n, ImageSet i,int ct) {
        name = n;
        Img = i;
        amount = ct;
        
        this.setIcon(i);
        
    }

   

    public ImageSet GetImg() {
        return Img;
    }

    public int Getamount() {

        return amount;
    }
    
}
