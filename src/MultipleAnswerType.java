import java.util.HashSet;
import java.util.Set;

// Конкретна реалізація Flyweight — тип питання з КІЛЬКОМА правильними відповідями
// Студент вводить відповіді через кому, наприклад: "Java, Python"
// Так само як SingleAnswerType — один об'єкт на весь кеш
public class MultipleAnswerType implements QuestionType {

    // Внутрішній стан — назва типу
    private final String typeName = "Кілька правильних відповідей";

    @Override
    public String getTypeName() {
        return typeName;
    }

    // Інструкція для студента
    @Override
    public void printInstruction() {
        System.out.println("  [Тип] Введіть всі правильні відповіді через кому");
    }

    // Перевірка: збираємо множину правильних відповідей з питання,
    // збираємо множину того що ввів студент, і порівнюємо їх
    @Override
    public boolean checkAnswer(Question question, String studentAnswer) {

        // Збираємо правильні відповіді у Set (в нижньому регістрі)
        Set<String> correctSet = new HashSet<>();
        for (Answer answer : question.getAnswers()) {
            if (answer.isCorrect()) {
                correctSet.add(answer.getText().trim().toLowerCase());
            }
        }

        // Збираємо відповіді студента у Set
        Set<String> studentSet = new HashSet<>();
        for (String part : studentAnswer.split(",")) {
            studentSet.add(part.trim().toLowerCase());
        }

        // Множини мають повністю збігатися
        return studentSet.equals(correctSet);
    }
}