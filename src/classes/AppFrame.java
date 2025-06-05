package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


//It is the app framework where it connets all the other classes to one frame

//Here we add some functionality
public class AppFrame extends JFrame {

    private TitleBar title;
    private List list;
    private  ButtonPanel btnPanel;

    //Getter Methods
    private JButton addTask;
    private JButton clear;

    //Constructor
    AppFrame() {
        this.setSize(400,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        title = new TitleBar();
        list = new List();
        btnPanel = new ButtonPanel();
        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);

        this.add(list,BorderLayout.CENTER);

        addTask = btnPanel.getAddTask();
        clear = btnPanel.getClear();


        addListeners();

    }

    public void addListeners(){
        addTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
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
