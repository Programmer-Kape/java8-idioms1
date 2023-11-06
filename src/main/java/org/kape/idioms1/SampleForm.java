package org.kape.idioms1;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class SampleForm {
  private JButton sampleBtn;
  private JPanel mainPanel;
  private JTextField userText;

  public SampleForm() {

  }

  public void showMessage(ActionEvent event) {
    String text = userText.getText();
    if (text == null || "".equals(text.trim())) {
      text = "[no message]";
    }
    JOptionPane.showMessageDialog(mainPanel, text, "User Said", JOptionPane.PLAIN_MESSAGE);
  }

  public void show() {
    JFrame window = new JFrame("Test GUI");
    window.setContentPane(mainPanel);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(new Dimension(300, 200));
    window.setLocationRelativeTo(null);
    window.setVisible(true);
    window.setResizable(false);
  }

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    }
    catch (Exception ex) {
      System.err.println(ex.getMessage());
      System.exit(1);
    }
    SampleForm form = new SampleForm();
    form.show();
  }
}
