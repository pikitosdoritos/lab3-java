import java.util.List;

// Інтерфейс QuestionType — це і є Flyweight-інтерфейс
// Він визначає що ВМІЄ робити кожен тип питання
// Самі об'єкти цього інтерфейсу будуть зберігатись у кеші фабрики
public interface QuestionType {

    // Повертає назву типу питання, наприклад "Одна відповідь"
    String getTypeName();

    // Виводить підказку студенту — як саме відповідати на це питання
    void printInstruction();

    // Перевіряє чи відповідь студента правильна
    // question — саме питання з варіантами (це зовнішній стан, приходить ззовні)
    // studentAnswer — те що ввів студент
    boolean checkAnswer(Question question, String studentAnswer);
}