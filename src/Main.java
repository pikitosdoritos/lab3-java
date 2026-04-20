import java.util.Arrays;

// Головний клас програми
// Саме тут запускається вся логіка (метод main)
public class Main {

    public static void main(String[] args) {

        // Створюємо об'єкт студента
        Student student = new Student("Nikita", 19);

        // Створюємо варіанти відповідей
        Answer a1 = new Answer("3", false); // неправильна відповідь
        Answer a2 = new Answer("4", true); // правильна відповідь
        Answer a3 = new Answer("5", false); // неправильна відповідь

        // Створюємо питання і передаємо список відповідей
        Question q1 = new Question(
                "2 + 2 = ?",
                Arrays.asList(a1, a2, a3) // створюємо список прямо тут
        );

        // Створюємо тест і додаємо до нього питання
        Test test = new Test(
                "Math Test",
                Arrays.asList(q1) // список питань
        );

        // Виводимо інформацію про студента
        System.out.println(student);

        // Виводимо тест (разом з питанням і відповідями)
        System.out.println(test);
    }
}