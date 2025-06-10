package classes;

import javax.swing.*;
import java.awt.*;


// As the name suggest here I will do the code fore Title Bar
// Which is the "To Do List" name holder
public class TitleBar extends JPanel {
    //Constructor
    TitleBar(){
        //Title Box "TO Do List" Size,Colour,Position
        this.setPreferredSize(new Dimension(400,80));

        this.setBackground(new Color(255, 238, 88)); // bright yellow


        JLabel titleText = new JLabel("To Do List");
        //titleText is using because it define Text's functions
        titleText.setPreferredSize (new Dimension(200,80));
        titleText.setFont(new Font("Sans-serif", Font.BOLD,20));
        titleText.setHorizontalAlignment(JLabel.CENTER);

        this.add(titleText);
    }

}
