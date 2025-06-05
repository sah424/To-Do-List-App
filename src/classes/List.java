package classes;

import javax.swing.*;
import java.awt.*;

public class List extends JPanel{
     List(){
         GridLayout layout = new GridLayout(10,1);
         layout.setVgap(5);

         this.setLayout(layout);
         //Made the colour of the bg of the main panel
         this.setBackground(new Color(255, 238, 88)); // bright yellow
     }

     public void updateNumbers(){
         Component[] listItems = this.getComponents();

         for (int i = 0; i < listItems.length; i++) {
             //listItems[i]: an element in an array or list
             //
             //Task: a class (likely a custom class in your project)
             //
             //instanceof: a Java keyword used to test if an object is of a specific type
             if(listItems[i] instanceof Task){
                 //Typecast it
                 //**
                 ((Task)listItems[i]).changeIndex(i+1);
             }
         }
     }
}
