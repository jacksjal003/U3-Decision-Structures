import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class QuizGame {

    static double usersAnswer;
    static double correctAnswer;
    static String displayProblem = "";

    static JPanel panel;
    static JButton createProblem,checkAnswer;
    static JLabel showProblem, resultLabel;
    static JTextField answerInput;
    static JRadioButton addition, subtraction, multiplication, division;
    static ButtonGroup radios = new ButtonGroup();

    public static void main(String[] args) {

        new QuizGame();
        /*int choice = Integer.parseInt(JOptionPane.showInputDialog ("Choose Addition(1), Subtraction(2), Multiplication(3), Division(4)"));

        createProblem(choice);
        getUserAnswer();
        checkAnswer();*/

    }

    public QuizGame(){

        JFrame frame = new JFrame ("Quiz Game");
        frame.setSize(300, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel= new JPanel();

        addition = new JRadioButton("Addition");
        subtraction = new JRadioButton("Subtraction");
        multiplication = new JRadioButton("Multiplication");
        division = new JRadioButton("Division");

        createProblem = new JButton("Make a problem!");
        showProblem = new JLabel(" PLACE HOLDER");
        answerInput = new JTextField(10);
        checkAnswer = new JButton("CHECK ANSWER");
        resultLabel = new JLabel(" Answer RESULTS");


        addition.setBounds(100, 25, 200, 25);
        subtraction.setBounds(100, 50, 200, 25);
        multiplication.setBounds(100, 75, 200, 25);
        division.setBounds(100, 100, 200, 25);

        createProblem.setBounds(100, 125, 200, 25);
        showProblem.setBounds(100, 150, 200, 25);
        answerInput.setBounds(100, 175, 200, 25);
        checkAnswer.setBounds(100, 200, 200, 25);
        resultLabel.setBounds(100, 225, 200, 25);

        addition.setSelected(true);

        createProblem.addActionListener(new NewProblemButton());
        checkAnswer.addActionListener(new CheckProblemListener());

        radios.add(addition);
        radios.add(subtraction);
        radios.add(multiplication);
        radios.add(division);

        panel.setLayout(null);
        panel.add(addition);
        panel.add(subtraction);
        panel.add(multiplication);
        panel.add(division);
        panel.add(createProblem);
        panel.add(showProblem);
        panel.add(answerInput);
        panel.add(checkAnswer);
        panel.add(resultLabel);


        frame.add(panel);
        frame.setVisible(true);
        }

        private class NewProblemButton implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (addition.isSelected()){
                    addProblem();
                }
                if (subtraction.isSelected()){
                    subProblem();
                }
                if(multiplication.isSelected()){
                    multiplyProblem();
                }
                if(division.isSelected()){
                    divideProblem();
                }

                showProblem.setText(displayProblem);
                panel.remove(createProblem);
                panel.updateUI();
            }
        }

        private class CheckProblemListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getUserAnswer();
                checkAnswer();
            }
        }

        public static void checkAnswer(){
        if(usersAnswer == correctAnswer){
            resultLabel.setText("You are correct!");
            panel.add(createProblem);
            panel.updateUI();
        }else{
            resultLabel.setText("Incorrect, please try again");
        }
    }

    public static void getUserAnswer(){

        usersAnswer = Double.parseDouble(answerInput.getText());

    }

    private static void createProblem(int choice) {



        if (choice >= 1) {
            if (choice < 5) {

                if (choice == 1) {
                    addProblem();
                }
            }

            if (choice == 2) {
                subProblem();
            }
            if (choice == 3) {
                multiplyProblem();
            }
            if (choice == 4) {
                divideProblem();
            }

        } else {
            System.out.printf("Wrong Input, restart program, try again");
        }

    }

    public static void addProblem(){

        int number1 = random();
        int number2 = random();

        correctAnswer = number1 + number2;
        displayProblem = number1 + " + " + number2;

    }

    public static void subProblem(){

        int number1 = random();
        int number2 = random();

        correctAnswer = number1 - number2;
        displayProblem = number1 + " - " + number2;

    }


    public static void multiplyProblem(){

        int number1 = random();
        int number2 = random();

        correctAnswer = number1 * number2;
        displayProblem = number1 + " * " + number2;

    }


    public static void divideProblem(){

        int number1 = random();
        int number2 = random();

        correctAnswer = number1 / number2;

        correctAnswer = Math.round(correctAnswer * 100.0)/100.0;

        displayProblem = number1 + " / " + number2;

    }


    //HELPER METHODS
    public static int random(){

        Random random = new Random();
        return random.nextInt(20)+ 1;

    }
    public static double input(String message){

        return Double.parseDouble(JOptionPane.showInputDialog(message));
    }

}
