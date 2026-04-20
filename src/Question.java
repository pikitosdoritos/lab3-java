import java.util.List;

// Клас Question описує одне питання тесту
public class Question {

    // Текст питання (наприклад: "2 + 2 = ?")
    private String text;

    // Список відповідей до цього питання
    // Кожен елемент — об'єкт класу Answer
    private List<Answer> answers;

    // Порожній конструктор
    // Потрібен, щоб можна було створити об'єкт без початкових значень
    public Question() {
    }

    // Конструктор з параметрами
    // Одразу задаємо текст питання і список відповідей
    public Question(String text, List<Answer> answers) {
        this.text = text; // присвоюємо текст
        this.answers = answers; // присвоюємо список відповідей
    }

    // Getter для отримання тексту питання
    public String getText() {
        return text;
    }

    // Getter для отримання списку відповідей
    public List<Answer> getAnswers() {
        return answers;
    }

    // Setter для зміни тексту питання
    public void setText(String text) {
        this.text = text;
    }

    // Setter для зміни списку відповідей
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    // Перевизначаємо метод toString()
    // Щоб при виводі об'єкта він виглядав зрозуміло
    @Override
    public String toString() {
        return "Question: " + text + "\nAnswers: " + answers;
    }
}