package classes;

import javax.swing.*;
import java.awt.*;
import java.time.temporal.Temporal;
import javax.swing.border.Border;


public class ButtonPanel extends JPanel {

    //Those are the 2 Buttons we add
    private JButton addTask;
    private JButton clear;


    //Border object
    Border emptyBorder = BorderFactory.createEmptyBorder();

    //Constructor
    ButtonPanel(){
        //This are the Button's Size,Color,Design of the BottomPanal Buttons
        this.setPreferredSize(new Dimension(400,60));
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));


        //Task button in the bottom. It's name & Design
        //name
        addTask = new JButton("Add Task");
        //border
        addTask.setBorder(emptyBorder);
        //size & font
        addTask.setFont(new Font("Serif", Font.ITALIC, 22));

        //calling the function
        this.add(addTask);
        //Created spaces b/w to buttons
        this.add(Box.createHorizontalStrut(20));

        //Clear button in the bottom
        clear = new JButton("Clear completed Tasks");
        //border
        clear.setBorder(emptyBorder);
        //size & font
        clear.setFont(new Font("Serif", Font.ITALIC, 22));


        this.add(clear);

    }

    //To access this from other class-- 2 methods for returning buttons
    //Getter
    //To add new task
    public JButton getAddTask(){
        return addTask;
    }

    public JButton getClear(){
        return clear;
    }
}
