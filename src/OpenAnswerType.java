// Конкретна реалізація Flyweight — відкрите питання (студент вводить текст вільно)
// Перевіряємо без урахування регістру
public class OpenAnswerType implements QuestionType {

    // Внутрішній стан — назва типу
    private final String typeName = "Відкрита відповідь";

    @Override
    public String getTypeName() {
        return typeName;
    }

    // Інструкція для студента
    @Override
    public void printInstruction() {
        System.out.println("  [Тип] Введіть відповідь у вільній формі");
    }

    // Перевірка: знаходимо правильну відповідь і порівнюємо рядки
    @Override
    public boolean checkAnswer(Question question, String studentAnswer) {
        for (Answer answer : question.getAnswers()) {
            if (answer.isCorrect()) {
                return answer.getText().trim().equalsIgnoreCase(studentAnswer.trim());
            }
        }
        return false;
    }
}