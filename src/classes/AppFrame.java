package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


//It is the app framework where it connects all the other classes to one frame

//Here we add some functionality
public class AppFrame extends JFrame {

    //Variables
    //The app gonna split up into 3 things
    private TitleBar title;
    private List list;
    private  ButtonPanel btnPanel;

    //Getter Methods to make them do things(add some functionality)
    private JButton addTask;
    private JButton clear;

    //Constructor
    AppFrame() {
        //App Frame Design
        this.setSize(400,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        title = new TitleBar();
        list = new List();
        btnPanel = new ButtonPanel();
        //these are the functions which connect the functionality(add) after design the app in each classes
        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(list,BorderLayout.CENTER);

        //these are the functionality for Task
        //Adding task
        addTask = btnPanel.getAddTask();
        //Clear the completed task
        clear = btnPanel.getClear();

        //Function created
        addListeners();

    }

    //Made this so when we click on "Add Task" it's going to add a new task
    public void addListeners(){
        addTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //making new task
                Task task = new Task();
                list.add(task);
                //1,2,3,4 in the ToDoList
                list.updateNumbers();

                task.getDone().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        task.changeState();
                        revalidate();
                    }
                });
                revalidate();
            }
        });

        clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Component[] tasks = list.getComponents();
                for (Component c : tasks) {
                    if (c instanceof Task) {
                        Task t = (Task) c;
                        if (t.getBackground().equals(Color.green)) {
                            list.remove(t);
                        }
                    }
                }
                list.updateNumbers();
                list.revalidate();
                list.repaint();
            }
        });

    }

}
