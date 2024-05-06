package myApplication;

import javax.swing.*;

public class Test extends JFrame {

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.setTitle("Program");
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
}