package classes;

import javax.swing.*;
import java.awt.*;

public class Task extends JPanel {

    //This are the type of variable I need in the project
    //FE here I need index value like 1,2,3
    private JLabel index;

    //Here I need a Task Name(String) like "i will read 5 pages of Atomic Habit"
    private JTextField taskName;

    //Here I also need a done button after complitation
    private JButton done;

    private boolean checked;
    //Constructor
    Task(){
        this.setPreferredSize(new Dimension(40,20));
        //It is th 1,2,3,4 numbers red bg
        this.setBackground(Color.red);

        this.setLayout(new BorderLayout());

        checked = false;

        index = new JLabel("");
        index.setPreferredSize(new Dimension(20,20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index,BorderLayout.WEST);

        taskName = new JTextField("Your Task Here");
        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBackground(Color.orange);
        //
        taskName.setForeground(Color.GRAY); // placeholder text color

        taskName.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (taskName.getText().equals("Your Task Here")) {
                    taskName.setText("");
                    taskName.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (taskName.getText().isEmpty()) {
                    taskName.setText("Your Task Here");
                    taskName.setForeground(Color.GRAY);
                }
            }
        });

        //
        this.add(taskName,BorderLayout.CENTER);

        done = new JButton("Done");
        done.setPreferredSize(new Dimension(40,20));
        done.setBorder(BorderFactory.createEmptyBorder());

        this.add(done,BorderLayout.EAST);

    }
    //This is for when I pressed the done button it will turn Green
    public JButton getDone(){
        return done;
    }
    //**
    public void changeIndex(int num) {
        this.index.setText(num+"");
        this.revalidate();
    }

    public void changeState() {
        if (checked) {
            this.setBackground(new Color(255, 255, 153)); // yellow for unfinished
            taskName.setBackground(new Color(255, 255, 153));
            done.setText("Done"); // change button label back
            checked = false;
        } else {
            this.setBackground(Color.green); // green for completed
            taskName.setBackground(Color.green);
            done.setText("Check"); // change button label to "Check"
            checked = true;
        }
    }

}

