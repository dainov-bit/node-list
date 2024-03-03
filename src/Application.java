import com.wolfman.NodeList;

public class Application {
    public static void main(String[] args) {
        NodeList nl = new NodeList();
        nl.add("Первая строка");
        nl.add("Вторая строка");
        nl.add("Третья строка");
        nl.add("Четвертая строка");
        nl.add("Пятая строка");
        System.out.println("Приложение работает");
        System.out.println("Размер списка: " + nl.size());
        System.out.println("Результат третьей ячейки: " + nl.get(3));
        System.out.println("Полный список");
        nl.print();
        System.out.println("Удалим четвертый элемент");
        nl.remove(4);
        System.out.println("Проверим список");
        nl.print();
        System.out.println("Количество элементов: " + nl.size());
        System.out.println("Пробуем вставить элемент между элементами");
        nl.add(1, "Десятая строка");
        nl.print();
        System.out.println("Количество элементов: " + nl.size());
        nl.print();
        System.out.println("Первый элемент списка: " + nl.getFirst() + " / Последний элемент списка: " + nl.getLast());
        System.out.println("На последок обратный список");
        nl.printRevers();
    }

}