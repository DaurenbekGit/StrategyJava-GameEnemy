# Game Enemy AI — Strategy Design Pattern

## 1. Project Overview

**Course:** Software Design Patterns  
**Assignment:** #5 — Strategy Pattern  
**Programming Language:** Java  
**Build Tool:** Maven  
**Design Pattern:** Behavioral — Strategy

Game Enemy AI is a Java application demonstrating the Strategy Design Pattern.

The project simulates an enemy in a game that can dynamically change its behavior between aggressive, defensive, and stealth modes without modifying the enemy class.

## 2. Project Structure

```text
src/
└── main/
    └── java/
        ├── Main.java
        ├── Enemy.java
        ├── EnemyBehavior.java
        ├── AggressiveBehavior.java
        ├── DefensiveBehavior.java
        └── StealthBehavior.java
pom.xml
README.md
```

## 3. Strategy Pattern Components

| Component | Java File | Responsibility |
|---|---|---|
| Strategy Interface | EnemyBehavior.java | Defines the common execute() method |
| Concrete Strategy | AggressiveBehavior.java | Implements attacking behavior |
| Concrete Strategy | DefensiveBehavior.java | Implements defensive behavior |
| Concrete Strategy | StealthBehavior.java | Implements stealth behavior |
| Context | Enemy.java | Stores, executes, and switches strategies |
| Client | Main.java | Creates the enemy and selects strategies |

## 4. How It Works

The Strategy Pattern allows different algorithms to be selected and changed at runtime.

1. The `EnemyBehavior` interface defines the `execute()` method.
2. Three concrete strategy classes implement different enemy behaviors.
3. The `Enemy` class stores a reference to the current strategy.
4. The `Main` class creates an enemy and selects its initial behavior.
5. The `setBehavior()` method allows switching strategies during execution.
6. The `performAction()` method delegates execution to the selected strategy.

### Example

```java
Enemy enemy = new Enemy(new AggressiveBehavior());
enemy.performAction();

enemy.setBehavior(new DefensiveBehavior());
enemy.performAction();

enemy.setBehavior(new StealthBehavior());
enemy.performAction();
```

### Expected Output

```text
Enemy attacks the player!
Enemy blocks the attack!
Enemy hides from the player!
```

## 5. Clean Code Principles

The implementation follows five important Clean Code principles.

### 1. Polymorphism Instead of Conditional Logic

Each behavior implements the same interface.

The `Enemy` class does not require `if/else` or `switch` statements to select or execute a specific behavior.

### 2. Meaningful Naming

Classes and methods use descriptive names such as `AggressiveBehavior`, `setBehavior()`, and `performAction()`.

This makes the code easier to understand and maintain.

### 3. Single Responsibility Principle (SRP)

Each class has one main responsibility.

For example, `AggressiveBehavior` handles attacking behavior, while `Enemy` manages the currently selected strategy.

### 4. Algorithm-Independent Context

The `Enemy` class depends on the `EnemyBehavior` interface rather than specific implementations.

This separates the enemy's main logic from individual algorithms.

### 5. Open/Closed Principle (OCP)

The project can be extended with new strategies without modifying existing classes.

For example, a new `PatrolBehavior` class can implement `EnemyBehavior` and be used by the existing `Enemy` context.

## 6. How to Run

### Requirements

- Java JDK
- IntelliJ IDEA or another Java IDE
- Maven

### Steps

1. Open the project in IntelliJ IDEA.
2. Load the Maven project.
3. Open `src/main/java/Main.java`.
4. Run the `main()` method.
5. Check the output in the Run console.

Alternatively, compile and run the Java files from the project root:

```bash
javac -d out src/main/java/*.java
java -cp out Main
```

## 7. Advantages of Strategy Pattern

- Allows switching algorithms at runtime.
- Reduces conditional logic.
- Promotes code reusability.
- Improves maintainability.
- Makes adding new behaviors easier.
- Supports polymorphism and separation of responsibilities.

## 8. Conclusion

The Game Enemy AI project demonstrates the Strategy Design Pattern through three interchangeable enemy behaviors.

The `Enemy` context can dynamically change its behavior using the `setBehavior()` method without modifying its internal implementation.

The project illustrates how polymorphism, clean code principles, and separation of responsibilities can improve software design.
