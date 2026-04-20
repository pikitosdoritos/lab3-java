import java.util.List;

// Клас Question описує одне питання тесту
// Всі оригінальні конструктори, getters, setters і toString збережені
public class Question {

    // Текст питання, наприклад "2 + 2 = ?"
    private String text;

    // Список варіантів відповідей
    private List<Answer> answers;

    // Посилання на Flyweight-об'єкт — тип питання
    // Один і той самий об'єкт QuestionType використовується
    // для всіх питань одного типу у всіх тестах
    private QuestionType questionType;

    // Порожній конструктор — як в лабі 2
    public Question() {
    }

    // Оригінальний конструктор з лаби 2 — залишаємо для сумісності
    public Question(String text, List<Answer> answers) {
        this.text = text;
        this.answers = answers;
    }

    // НОВИЙ конструктор — приймає ще й тип питання
    // typeKey — один із рядків: "single", "multiple", "open"
    // При виклику QuestionFactory.getType() об'єкт або береться з кешу або
    // створюється
    public Question(String text, List<Answer> answers, String typeKey) {
        this.text = text;
        this.answers = answers;
        this.questionType = QuestionFactory.getType(typeKey);
    }

    // Виводить питання на екран разом з інструкцією і варіантами
    public void display() {
        System.out.println("  Питання: " + text);
        if (questionType != null) {
            questionType.printInstruction();
        }
        System.out.println("  Варіанти:");
        for (int i = 0; i < answers.size(); i++) {
            System.out.println("    " + (i + 1) + ") " + answers.get(i).getText());
        }
    }

    // Перевіряє відповідь студента — делегує логіку Flyweight-об'єкту
    public boolean checkAnswer(String studentAnswer) {
        if (questionType == null)
            return false;
        return questionType.checkAnswer(this, studentAnswer);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    public String toString() {
        String type = (questionType != null)
                ? " [" + questionType.getTypeName() + "]"
                : "";
        return "Question: " + text + type + "\nAnswers: " + answers;
    }
}