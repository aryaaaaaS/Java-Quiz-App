import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class QuizApp extends JFrame {

  private JButton btnNext;
  private JButton btnSubmit;
  private JLabel lblQuestion;
  private JRadioButton option1, option2, option3, option4;
  private ButtonGroup group;
  private int score;
  private String correctAnswer;
  private boolean isNotLastQuestion;

  public QuizApp() {
    // Set up the frame
    setTitle("Java Quiz");
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    // Create components
    lblQuestion = new JLabel("Question will appear here", SwingConstants.CENTER);
    option1 = new JRadioButton();
    option2 = new JRadioButton();
    option3 = new JRadioButton();
    option4 = new JRadioButton();
    btnNext = new JButton("Next");
    btnSubmit = new JButton("Submit");

    group = new ButtonGroup();
    group.add(option1);
    group.add(option2);
    group.add(option3);
    group.add(option4);

    // Layout using BoxLayout
    setLayout(new BorderLayout(10, 10));

    // Panel for the question and options
    JPanel questionPanel = new JPanel();
    questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
    questionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    questionPanel.add(lblQuestion); // Add question label
    questionPanel.add(option1); // Add option 1
    questionPanel.add(option2); // Add option 2
    questionPanel.add(option3); // Add option 3
    questionPanel.add(option4); // Add option 4

    // Panel for buttons (Next and Submit)
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(btnNext);
    buttonPanel.add(btnSubmit);

    // Add the panels to the frame
    add(questionPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    // Add action listeners
    btnNext.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          if (isNotLastQuestion) {
            updateScore();
            loadNextQuestion();
          }
          if (!isNotLastQuestion) {
            btnNext.setEnabled(false);
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });

    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        submitQuiz();
      }
    });

    // Load the first question
    loadNextQuestion();
  }

  // update score
  private void updateScore() {
    if (option1.isSelected() && option1.getText().equals(correctAnswer)) {
      score++;
    } else if (option2.isSelected() && option2.getText().equals(correctAnswer)) {
      score++;
    } else if (option3.isSelected() && option3.getText().equals(correctAnswer)) {
      score++;
    } else if (option4.isSelected() && option4.getText().equals(correctAnswer)) {
      score++;
    }
  }

  // Fetch questions from database
  ResultSet rs = DatabaseConnection.getQuestions();

  private void loadNextQuestion() {
    try {
      if (rs != null && rs.next()) {
        isNotLastQuestion = true;
        String question = rs.getString("question_text");
        String option1 = rs.getString("option1");
        String option2 = rs.getString("option2");
        String option3 = rs.getString("option3");
        String option4 = rs.getString("option4");
        this.correctAnswer = rs.getString("answer");
        lblQuestion.setText(question);
        this.option1.setText(option1);
        this.option2.setText(option2);
        this.option3.setText(option3);
        this.option4.setText(option4);
      } else {
        isNotLastQuestion = false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void submitQuiz() {
    // Code to submit the quiz (e.g., calculate score)

    JOptionPane.showMessageDialog(this, "Quiz Submitted! Your score is: " + score);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new QuizApp().setVisible(true);
      }
    });
  }
}



