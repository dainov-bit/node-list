package com.wolfman;
/* Своя реализация LinkedList */
// Класс узел
class Node {
    String value; // элемент
    Node next; // следующий элемент
    Node prev; // Придыдущий элемент

    public Node(String value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
// Класс, управляющий списком.
public class NodeList {
    Node first; // Первый элемент
    Node last; // Последний элемент
    int size; // Количество элементов

    public NodeList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
// Метод, который добавляет элемент
    public void add(String element) {
        Node node = new Node(element); // Создали узел
        if (this.first == null) { // Если список пуст
            this.first = node; // Создали первый элемент списка
        } else { // Вставляем элемент и сообщаем придыдущему, что новый элемент следующий.
            this.last.next = node;
            node.prev = this.last;
        }
        this.last = node;
        this.size++; // Накинули количество к элементам.
    }
// Метод, который вставит новый элемент после конкретного
    public void add(int index, String element) {
        Node node = new Node(element); // Создали узел
        Node current = this.first; // Вызвали первый элемент
        if (index == 0) { // Если хотим вставить перед первым элементом
            node.next = this.first; // Указали, что первый элемент теперь является вторым.
            this.first = node; // Указали, что новый узел будет первым.
            this.size++; // Накинули количество
        } else if (index == this.size) { // Тут вставляем в конец списка.
            this.last.next = node; // Новый узел помещаем в конец
            this.size++; // Накинули количество
        } else {
            int i = 0; // Просто счетчик для цикла ниже.
            while (current != null) {
                i++;
                if (i == index) { // Нашли элемент, после которого нужно вставить.
                    node.next = current.next; // Новому узлу сообщаем следующий элемент
                    node.prev = current; // Новому узлу указываем, что этот элемент теперь придыдущий для него.
                    current.next = node; // Ставим новый узел перед этим
                    this.size++; // Накинули количество
                } else {
                    current = current.next; // Указали на следующий элемент циклу
                }
            }
        }
    }
// Метод, который выводит список элементов
    public void print() {
        Node current = this.first; // Вызвали первый элемент списка.
        while (current != null) {
            System.out.println(current.value);
            current = current.next; // Указали циклу на следующий элемент
        }
    }

    // Выводим значение последнего элемента
    public String getLast() {
        return this.last.value;
    }
// Выводим значение первого элемента
    public String getFirst() {
        return this.first.value;
    }
// Метод выводит значение конкретного элемента
    public String get(int index) {
        Node current = this.first; // Вызвали первый элемент списка
        int i = 0; // Счетчик для цикла
        String element = null; // Переменная для того, чтобы в нее поместить значение
        while (current != null) {
            i++;
            if (i == index) { // Нашли элемент
                element = current.value; // Поместили значение в переменную
            }
            current = current.next; // Указали циклу на следующий элемент
        }
        return element; // Выводим значение
    }

    // Метод удаляет элемент из списка
    public void remove(int index) {
        Node current = this.first; // Вызвали первый элемент списка
        int i = 0; // Счетчик для цикла
        if (index == 1) { // Удаляем первый элемент
            this.first = current.next; // Первому элементу просто указали на следующий
            this.size--; // Отняли от количества
        } else if (index == this.size) { // Удаляем последний элемент
            this.last = this.last.prev; // Последнему элементу указываем на придыдущий
            this.size--; // Отняли от количества
            this.last.next = null; // Стерли следующий элемент, который ранее указывал на последний
        } else {
            while (current != null) {
                i++;
                if (i == index) { // Нашли нужный элемент
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                    current.next = null;
                    current.prev = null;
                    this.size--;
                } else {
                    current = current.next;

                }

            }
        }
    }
// Количество элементов
    public int size() {
        return this.size;
    }
/* Следующий метод должен пройти по списку от конца и к началу, но почему-то вызывает проблемы.
Дело в том, что он не замечает элемент, который был вставлен между элементами через метод add(int index,String element) */
    public void printRevers() {
        Node current = this.last; // Вызвали последний элемент.
        while (current != null) {
            System.out.println(current.value);
            current = current.prev; // Указали на придыдущий элемент
        }
    }

}
