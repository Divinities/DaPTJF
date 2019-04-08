package exo;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Exe {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextField demo");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        Font newF = new Font("Arial", Font.BOLD, 19);
        JTextField text = new JTextField("momo");
        text.setBounds(40, 40, 200, 30);
        text.setFont(newF);
        text.setForeground(Color.red);
        text.setBackground(Color.BLACK);
        frame.add(text);
        frame.setVisible(true);

    }

}
