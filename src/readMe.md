# Обратите внимание

Недостаточно реализовать программу таким образом, чтобы она проходила по всей истории просмотров и только потом удаляла предыдущий просмотр. Это приведет к линейной зависимости времени работы от длины истории.

## Цель

Реализовать функциональность таким образом, чтобы время выполнения задачи не зависело от общего количества задач в истории.

## Интерфейс HistoryManager

У нас уже есть интерфейс, необходимо добавить метод `void remove(int id)` для удаления задачи из просмотра и реализовать его в классе `InMemoryHistoryManager`. Также добавьте вызов этого метода при удалении задач, чтобы они удалялись из истории просмотров.

### Структура интерфейса HistoryManager

```java
public interface HistoryManager {
    void add(Task task);
    void remove(int id);
    List<Task> getHistory();
}
```

## Дальнейшая разработка алгоритма с CustomLinkedList и HashMap

Программа должна запоминать порядок вызовов метода `add`, так как в этом порядке просмотры будут выстраиваться в истории. Для хранения порядка вызовов удобно использовать список.

Если задача просматривалась несколько раз, в истории должен отображаться только последний просмотр. Предыдущий просмотр должен быть удален сразу после появления нового — за O(1). Константное время выполнения операции может гарантировать связный список LinkedList. Однако эта стандартная реализация в данном случае не подойдёт, поэтому вам предстоит написать собственную.

### CustomLinkedList

CustomLinkedList позволяет удалить элемент из произвольного места за O(1) с одним важным условием — если программа уже дошла до этого места по списку. Чтобы выполнить это условие, создайте стандартную HashMap. Её ключом будет id задачи, просмотр которой требуется удалить, а значением — место просмотра этой задачи в списке, то есть узел связного списка. С помощью номера задачи можно получить соответствующий ему узел связного списка и удалить его.

### Реализация метода getHistory

Метод `getHistory` должен перекладывать задачи из связного списка в ArrayList для формирования ответа.

### Про CustomLinkedList

Сначала напишите свою реализацию двусвязного списка задач с методами `linkLast` и `getTasks`. `linkLast` будет добавлять задачу в конец этого списка, а `getTasks` собирать все задачи из него в обычный ArrayList. Убедитесь, что решение работает. Отдельный класс для списка создавать не нужно — реализуйте его прямо в классе `InMemoryHistoryManager`. А вот отдельный класс `Node` для узла списка необходимо добавить.

### Про метод removeNode

Добавьте метод `removeNode` в класс. В качестве параметра этот метод должен принимать объект `Node` — узел связного списка и вырезать его.

### Про HashMap

Создайте HashMap — стандартной реализации будет достаточно. В ключах будут храниться id задач, а в значениях Node — узлы связного списка. Изначально HashMap пустая. Она будет заполняться по мере добавления новых задач. Напишите реализацию метода `add(Task task)`. Теперь с помощью HashMap и метода удаления `removeNode` метод `add(Task task)` будет быстро удалять задачу из списка, если она там есть, а затем вставлять её в конец двусвязного списка. После добавления задачи не забудьте обновить значение узла в HashMap.

## Тестирование работы программы

После написания менеджера истории проверьте его работу:

- Создайте две задачи, эпик с тремя подзадачами и эпик без подзадач.
- Запросите созданные задачи несколько раз в разном порядке.
- После каждого запроса выведите историю и убедитесь, что в ней нет повторов.
- Удалите задачу, которая есть в истории, и проверьте, что при печати она не будет выводиться.
- Удалите эпик с тремя подзадачами и убедитесь, что из истории удалился как сам эпик, так и все его подзадачи.
