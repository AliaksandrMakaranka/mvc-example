# MVC Coin Toss Game

Простая консольная игра "Орел и Решка", реализованная с использованием паттерна MVC (Model-View-Controller).

## Структура проекта

```
src/
├── controller/         # Контроллеры
│   ├── Application.java
│   ├── Main.java
│   └── MainColor.java
├── model/             # Модели
│   └── Coin.java
└── view/              # Представления
    ├── View.java
    ├── ViewConsole.java
    └── ViewConsoleColor.java
```

## Требования

- Java 11 или выше
- Maven 3.6 или выше

## Сборка проекта

```bash
mvn clean install
```

## Запуск игры

### Стандартная версия (без цветов)
```bash
mvn exec:java -Dexec.mainClass="controller.Main"
```

### Цветная версия
```bash
mvn exec:java -Dexec.mainClass="controller.MainColor"
```

## Тестирование

```bash
mvn test
```

## Особенности реализации

- Чистая архитектура MVC
- Два варианта интерфейса (обычный и цветной)
- Отслеживание статистики игры
- Полное покрытие тестами
- Поддержка выхода из игры
- Валидация пользовательского ввода

## Технические детали

- Использование JUnit 5 для тестирования
- Maven для управления зависимостями и сборки
- ANSI-цвета для цветной версии
- Обработка пользовательского ввода с валидацией
