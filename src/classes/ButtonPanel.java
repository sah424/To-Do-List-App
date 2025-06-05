package classes;

import javax.swing.*;
import java.awt.*;
import java.time.temporal.Temporal;
import javax.swing.border.Border;


public class ButtonPanel extends JPanel {

    private JButton addTask;
    private JButton clear;

    Border emptyBorder = BorderFactory.createEmptyBorder();

    //Constructor
    ButtonPanel(){
        this.setPreferredSize(new Dimension(400,60));
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));


        //Task button in the bottom
        addTask = new JButton("Add Task");
        addTask.setBorder(emptyBorder);
        //size & font
        addTask.setFont(new Font("Serif", Font.ITALIC, 22));

        this.add(addTask);
        //Created spaces b/w to buttons
        this.add(Box.createHorizontalStrut(20));

        //clear button in the bottom
        clear = new JButton("Clear completed Tasks");
        clear.setBorder(emptyBorder);
        //size & font
        clear.setFont(new Font("Serif", Font.ITALIC, 22));


        this.add(clear);

    }

    //?
    //Getter
    //To add new task
    public JButton getAddTask(){
        return addTask;
    }

    public JButton getClear(){
        return clear;
    }
}
