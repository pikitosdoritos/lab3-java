import java.util.HashMap;
import java.util.Map;

// QuestionFactory — це Flyweight Factory (фабрика з кешем)
// Головна ідея: для кожного типу питання існує ОДИН об'єкт у пам'яті
// Якщо об'єкт вже є в кеші — повертаємо його, не створюємо новий
public class QuestionFactory {

    // Кеш об'єктів: ключ — рядок з назвою типу, значення — сам об'єкт
    // static — один кеш на всю програму
    private static final Map<String, QuestionType> cache = new HashMap<>();

    // Константи щоб не писати рядки вручну і не помилитись
    public static final String SINGLE   = "single";
    public static final String MULTIPLE = "multiple";
    public static final String OPEN     = "open";

    // Головний метод фабрики — повертає потрібний тип питання
    public static QuestionType getType(String type) {

        // Перевіряємо кеш — якщо вже є, повертаємо той самий об'єкт
        if (cache.containsKey(type)) {
            System.out.println("  [CACHE HIT] Об'єкт вже є у кеші: " + type
                    + " | hashCode=" + System.identityHashCode(cache.get(type)));
            return cache.get(type);
        }

        // Об'єкта ще немає — створюємо новий і кладемо в кеш
        QuestionType questionType;

        switch (type) {
            case SINGLE:
                questionType = new SingleAnswerType();
                break;
            case MULTIPLE:
                questionType = new MultipleAnswerType();
                break;
            case OPEN:
                questionType = new OpenAnswerType();
                break;
            default:
                throw new IllegalArgumentException("Невідомий тип: " + type);
        }

        cache.put(type, questionType);
        System.out.println("  [NEW OBJECT] Створено новий об'єкт: " + type
                + " | hashCode=" + System.identityHashCode(questionType));
        return questionType;
    }

    // Скільки унікальних об'єктів зараз у кеші
    public static int getCacheSize() {
        return cache.size();
    }

    // Виводить вміст кешу — для демонстрації ефекту Flyweight
    public static void printCacheInfo() {
        System.out.println("\n====== Кеш QuestionFactory ======");
        System.out.println("Унікальних об'єктів у пам'яті: " + cache.size());
        for (Map.Entry<String, QuestionType> entry : cache.entrySet()) {
            System.out.println("  ключ='" + entry.getKey()
                    + "' | клас=" + entry.getValue().getClass().getSimpleName()
                    + " | hashCode=" + System.identityHashCode(entry.getValue()));
        }
        System.out.println("=================================");
    }
}