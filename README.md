# ДЗ 29. Логирование

1. Создать новый пакет coffee.order
2. Создать класс CoffeeOrderBoard. Класс является цифровым представлением очереди заказов в кофейне.
3. Данный класс содержит список заказов.
4. Создать класс Order. Класс является цифровым представлением заказа. Данный класс содержит номер заказа и имя человека его заказавшего.
5. Реализовать метод add в классе CoffeeOrderBoard. Данный метод добавляет новый заказ и присваивает заказу номер (натуральный порядок).
6. Натуральный порядок (natural ordering) означенает, что если у последнего заказа номер 86, то следущий будет 87.
7. Не может быть такой ситуации, что номер повторяется в рамках одного объекта типа CoffeeOrderBoard.
8. Реализовать метод deliver в классе CoffeeOrderBoard. Данный метод выдает ближайший на очереди заказ. Выдача сопровождается удалением заказа с списка.
9. Реализовать метод deliver в классе CoffeeOrderBoard. Данный метод выдает заказ с определенным номеров. Выдача сопровождается удалением заказа с списка.
10. Данный метод обслуживает ситуацию, когда заказ поступивший позже готов раньше.
11. Реализовать метод draw в классе CoffeeOrderBoard. Данный метод выводит в консоль информацию о текущем состоянии очереди в порядке ближайшего к выдаче заказа.

Например:

=============   
Num   |  Name   
4     |  Alen   
27    |  Yoda   
33    |  Obi-van    
34    |  John Snow  

1. Подключить логирование
2. Сконфигурировать логирование для вывода информации в консоль и записи в файл
3. Применить логирование ко всем операциям на уровне info. Кроме методов: constructor, getter, setter
4. Логирование должно отображать ход операции, содержать достаточную информацию для анализа операции.
5. В случае исключения, stacktrace должен быть залогирован на уровне error