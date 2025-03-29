package taskmanager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

    // create an instance of AddTask class to handle task additions
    AddTask addTask = new Addtask();
    JButton addButton = addTask.getAddButton;

    // add action listener to the button to the add task button
    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        addNewTask(); // call the method to add a new task
      }
    });

    // create a "clear all" button to clear all tasks
    JButton clearButton = new JButton("Clear All");
    clearButton.setBounds(420, 10, 100, 30);
    clearButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        clearAllTaks(); // call the method to clear all tasks
      }
    });

    // set and add components to the frame
    addButton.setBounds(420, 50, 100, 30);
    frame.add(addButton);
    frame.add(clearButton);
    frame.add(scrollPane);
    frame.setVisible(true);

  }

  private static void addNewTask() {
    // creates an instance of the AddTask class to add a new task
    Addtask addTask = new Addtask();
    int result = JOptionPane.showConfirmDialog(null, addTask.getPanel(), "Create New Task",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

    //if the user clicks the OK button, add the task to the task panel
    if (result == JOptionPane.OK_OPTION) {
      String taskText = addTask.getTaskTextFeild().getText();
      if (!taskText.isEmpty()) {
        JButton taskButton = new JButton(taskText);
        taskButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            taskButton.setEnabled(!taskButton.isEnabled());
          }
        });
        taskPanel.add(taskButton);
        taskPanel.revalidate();
        taskPanel.repaint();
      }
  }
}