class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(int userAnswerIndex) {
        return userAnswerIndex == correctAnswerIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(questionText).append("\n");
        for (int i = 0; i < options.length; i++) {
            sb.append(i + 1).append(". ").append(options[i]).append("\n");
        }
        return sb.toString();
    }
}

// User class
class User {
    private String username;
    private int score;

    public User(String username) {
        this.username = username;
        this.score = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}

// Quiz class
import java.util.*;

class Quiz {
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        questions.add(question);
        System.out.println("Added question: " + question.getQuestionText());
    }

    public void takeQuiz(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting quiz for: " + user.getUsername());
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ":");
            System.out.println(question);
            System.out.print("Your answer (1-" + question.getOptions().length + "): ");
            int userAnswer = scanner.nextInt() - 1;

            if (question.isCorrectAnswer(userAnswer)) {
                System.out.println("Correct!");
                user.incrementScore();
            } else {
                System.out.println("Wrong. The correct answer was: " + (question.getOptions()[question.isCorrectAnswer(userAnswer) ? userAnswer : question.getOptions().length]));
            }
            System.out.println();
        }
        System.out.println("Quiz finished! Your score: " + user.getScore() + "/" + questions.size());
    }
}

// Main class to demonstrate functionality
public class OnlineQuizSystem {
    public static void main(String[] args) {
        // Create quiz
        Quiz quiz = new Quiz();

        // Add questions to quiz
        quiz.addQuestion(new Question("What is the capital of France?", new String[]{"Berlin", "Paris", "Madrid", "Rome"}, 1));
        quiz.addQuestion(new Question("What is 5 + 3?", new String[]{"5", "8", "12", "10"}, 1));
        quiz.addQuestion(new Question("Which programming language is this quiz written in?", new String[]{"Python", "Java", "C++", "Ruby"}, 1));

        // Create user
        User user = new User("Alice");

        // Take the quiz
        quiz.takeQuiz(user);
    }
}
