package MultipleChoiceTest;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class Game{
    private ArrayList<Question> questionSet;
    public Game(){
        questionSet = new ArrayList<Question>();

        String q = "Where does the Sum rise?";
        String[] a = {"East","West","North","South"};
        questionSet.add(new Question(q,a,"East"));

        q = "Who invented the telephone?";
        a = new String[]{"Thomas Edison" , "Micheal Faraday","James Watt","Alexander Bell"};
        questionSet.add(new Question(q,a,"Alexander Bell"));

        q = "Where is the capital of Japan?";
        a = new String[]{"Beijing","Tokyo","Seoul","Bangkok"};
        questionSet.add(new Question (q,a,"Tokyo"));

        q = "Which feature is not supported by Java?";
        a = new String[]{"Dynamic","Multiple Inheritance","Interface","Abstraction"};
        questionSet.add(new Question(q,a,"Multiple inheritance"));
        Collections.shuffle(questionSet, new Random());

    }

    public void start(){
        Scanner scan = new Scanner(System.in);
        int numCorrect = 0;
        //show questions from questionSet
        for(int questions = 0;questions < questionSet.size();questions++){
            System.out.println(questionSet.get(questions).getQuestion());
            int numChoices = questionSet.get(questions).getChoices().size();
            //show choices from question in questionSet

            for(int choice =0;choice<numChoices;choice++){
                System.out.println((choice + 1) + " : " + questionSet.get(questions).getChoices().get(choice));
            }

            int playerAnswer = scan.nextInt();
            ArrayList<String> choiceSet = questionSet.get(questions).getChoices();
            String correctAnswer = questionSet.get(questions).getAnswer();
            
            int correctAnswerIndex = choiceSet.indexOf(correctAnswer);
            if(playerAnswer == correctAnswerIndex + 1){
                numCorrect++;
            }
        }
        scan.close();
        System.out.println("You got " + numCorrect + " correct answer(s)");
    }
        
}
