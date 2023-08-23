# CardDelivery
Домашнее задание к занятию «2.2. Selenide»

Вам необходимо автоматизировать тестирование формы заказа доставки карты:

![image](https://user-images.githubusercontent.com/121516669/235769339-2035a7d4-41e9-4d18-ac37-2f4f17199de6.png)


Требования к содержимому полей:

Город — один из административных центров субъектов РФ.
Дата — не ранее трёх дней с текущей даты.
В поле фамилии и имени разрешены только русские буквы, дефисы и пробелы.
В поле телефона — только 11 цифр, символ + на первом месте.
Флажок согласия должен быть выставлен.
Тестируемая функциональность: отправка формы.
Поля «Город» и «Дата» заполняются через прямой ввод значений без использования выбора из выпадающего списка и всплывающего календаря.

Условия: если все поля заполнены корректно, то форма переходит в состояние загрузки:



Важно: состояние загрузки не должно длиться более 15 секунд.

После успешной отправки формы появится всплывающее окно об успешном завершении бронирования:



Вам необходимо самостоятельно изучить элементы на странице, чтобы подобрать правильные селекторы. Обратите внимание, что элементы могут быть как скрыты, так и динамически добавляться или удаляться из DOM.
