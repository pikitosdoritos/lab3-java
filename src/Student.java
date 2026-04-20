// Оголошення публічного класу Student
public class Student {

    // Приватні поля класу (інкапсуляція)
    // name — ім’я студента (тип String)
    private String name;

    // age — вік студента (тип int)
    private int age;

    // Порожній конструктор (створює об'єкт без початкових значень)
    public Student() {
    }

    // Конструктор з параметрами для ініціалізації об'єкта
    public Student(String name, int age) {
        // this.name — поле класу
        // name — параметр конструктора
        this.name = name;
        this.age = age;
    }

    // Getter для отримання значення поля name
    public String getName() {
        return name;
    }

    // Setter для встановлення значення поля name
    public void setName(String name) {
        this.name = name;
    }

    // Getter для отримання значення поля age
    public int getAge() {
        return age;
    }

    // Setter для встановлення значення поля age
    public void setAge(int age) {
        this.age = age;
    }

    // Перевизначення методу toString()
    // Використовується для зручного виводу об'єкта у текстовому вигляді
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}