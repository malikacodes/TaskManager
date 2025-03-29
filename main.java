package taskmanager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {

  // class variable
  private static JPanel taskPanel;

  public static void main(String[] args) {
    // creates the main frame for the program
    JFrame frame = new JFrame("Task Manager");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLayout(null);

    // creats a panel to hold the tasks
    taskPanel = new JPanel();
    taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));

    // create scroll
    JScrollPane scrollPane = new JScrollPane(taskPanel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(10, 10, 400, 400);

    frame.add(scrollPane);
    frame.setVisible(true);

  }
}