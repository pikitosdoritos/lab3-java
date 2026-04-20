import java.util.List;

// Клас Test описує весь тест (набір питань)
public class Test {

    // Назва тесту (наприклад: "Math Test")
    private String title;

    // Список питань у тесті
    // Кожен елемент — об'єкт класу Question
    private List<Question> questions;

    // Порожній конструктор
    // Дозволяє створити об'єкт без початкових значень
    public Test() {
    }

    // Конструктор з параметрами
    // Одразу задаємо назву тесту та список питань
    public Test(String title, List<Question> questions) {
        this.title = title; // присвоюємо назву тесту
        this.questions = questions; // присвоюємо список питань
    }

    // Getter для отримання назви тесту
    public String getTitle() {
        return title;
    }

    // Getter для отримання списку питань
    public List<Question> getQuestions() {
        return questions;
    }

    // Setter для зміни назви тесту
    public void setTitle(String title) {
        this.title = title;
    }

    // Setter для зміни списку питань
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    // Перевизначення методу toString()
    // Використовується для зручного виводу тесту разом із питаннями
    @Override
    public String toString() {
        return "Test: " + title + "\nQuestions: " + questions;
    }
}