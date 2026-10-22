# Game Enemy AI — Strategy Design Pattern

## 1. Project Overview

**Course:** Software Design Patterns  
**Assignment:** #5 — Strategy Pattern  
**Programming Language:** Java  
**Design Pattern:** Behavioral — Strategy

Game Enemy AI is a Java application that demonstrates the implementation of the Strategy Design Pattern.

The project simulates an enemy in a game that can dynamically change its behavior during runtime.

The enemy supports three different behaviors:

- **Aggressive Behavior** — attacks the player.
- **Defensive Behavior** — blocks incoming attacks.
- **Stealth Behavior** — hides from the player.

The main goal is to demonstrate how different algorithms can be switched without modifying the Context class.

## 2. Project Structure

```text
GameEnemyAI/
├── EnemyBehavior/
│   ├── EnemyBehavior.java
│   ├── AggressiveBehavior.java
│   ├── DefensiveBehavior.java
│   └── StealthBehavior.java
├── Enemy.java
├── Main.java
└── README.md
```

### File Responsibilities

| File | Responsibility |
|---|---|
| `EnemyBehavior.java` | Defines the common behavior interface |
| `AggressiveBehavior.java` | Implements attacking behavior |
| `DefensiveBehavior.java` | Implements defensive behavior |
| `StealthBehavior.java` | Implements stealth behavior |
| `Enemy.java` | Stores and switches enemy strategies |
| `Main.java` | Creates the enemy and demonstrates strategy switching |

## 3. Strategy Pattern Components

The project contains all four main components of the Strategy Design Pattern.

### Strategy Interface — EnemyBehavior

The `EnemyBehavior` interface defines a common method that every strategy must implement.

```java
public interface EnemyBehavior {
    void execute();
}
```

### Concrete Strategies

Three classes implement the `EnemyBehavior` interface.

**AggressiveBehavior**

```java
public class AggressiveBehavior implements EnemyBehavior {
    @Override
    public void execute() {
        System.out.println("Enemy attacks the player!");
    }
}
```

**DefensiveBehavior**

```java
public class DefensiveBehavior implements EnemyBehavior {
    @Override
    public void execute() {
        System.out.println("Enemy blocks the attack!");
    }
}
```

**StealthBehavior**

```java
public class StealthBehavior implements EnemyBehavior {
    @Override
    public void execute() {
        System.out.println("Enemy hides from the player!");
    }
}
```

Each strategy implements the same method but provides a different behavior.

### Context — Enemy

The `Enemy` class stores a reference to the Strategy interface and delegates behavior execution to the selected strategy.

```java
public class Enemy {
    private EnemyBehavior behavior;

    public Enemy(EnemyBehavior behavior) {
        this.behavior = behavior;
    }

    public void setBehavior(EnemyBehavior behavior) {
        this.behavior = behavior;
    }

    public void performAction() {
        behavior.execute();
    }
}
```

The `setBehavior()` method allows changing strategies at runtime.

The Context does not contain conditional statements for choosing strategies.

### Client — Main

The `Main` class creates an enemy, selects its initial strategy, and changes its behavior during execution.

```java
public class Main {
    public static void main(String[] args) {
        Enemy enemy = new Enemy(new AggressiveBehavior());

        enemy.performAction();

        enemy.setBehavior(new DefensiveBehavior());
        enemy.performAction();

        enemy.setBehavior(new StealthBehavior());
        enemy.performAction();
    }
}
```

## 4. Expected Output

```text
Enemy attacks the player!
Enemy blocks the attack!
Enemy hides from the player!
```

The output demonstrates that the same enemy object can execute different behaviors without modifying the `Enemy` class.

## 5. Clean Code Principles

The project demonstrates five important Clean Code principles.

### 1. Polymorphism Instead of Conditional Logic

Each behavior implements the same `EnemyBehavior` interface.

The `Enemy` class does not require `if/else` or `switch` statements to determine the current behavior.

Instead, the selected strategy executes its own implementation of `execute()`.

### 2. Meaningful Naming

The project uses descriptive names such as:

- `AggressiveBehavior`
- `DefensiveBehavior`
- `StealthBehavior`
- `setBehavior()`
- `performAction()`

These names clearly describe the responsibilities of classes and methods.

### 3. Single Responsibility Principle (SRP)

Each strategy class has one main responsibility.

For example:

- `AggressiveBehavior` handles attacking.
- `DefensiveBehavior` handles defending.
- `StealthBehavior` handles hiding.

The `Enemy` class is responsible for managing and executing the selected behavior.

### 4. Algorithm-Independent Context

The `Enemy` class depends on the `EnemyBehavior` interface instead of concrete strategy classes.

This keeps the Context independent of the internal implementation of each algorithm.

### 5. Open/Closed Principle (OCP)

The application can be extended with new strategies without changing the existing Context.

For example, a new `PatrolBehavior` strategy can implement the `EnemyBehavior` interface.

The existing `Enemy` class can use the new strategy without modification.

## 6. How to Run

### Requirements

- Java JDK
- IntelliJ IDEA or another Java IDE

### Run Using IntelliJ IDEA

1. Clone or download the GitHub repository.
2. Open the project in IntelliJ IDEA.
3. Make sure the Java JDK is configured.
4. Open `Main.java`.
5. Run the `main()` method.
6. Check the output in the console.

### Run Using Terminal

If the source files have no package declarations, compile them from the repository root:

```bash
javac -d out EnemyBehavior/*.java Enemy.java Main.java
```

Run the program:

```bash
java -cp out Main
```

**Note:** If Java package declarations are used, the compilation and execution commands must match the declared packages.

## 7. Advantages of Strategy Pattern

The Strategy Pattern provides several advantages:

- Supports runtime algorithm switching.
- Reduces conditional logic.
- Improves code readability.
- Encourages polymorphism.
- Separates algorithms into independent classes.
- Makes the application easier to maintain.
- Allows new behaviors to be added without changing the Context.

## 8. Conclusion

The Game Enemy AI project demonstrates the Strategy Design Pattern using three interchangeable enemy behaviors: Aggressive, Defensive, and Stealth.

The `EnemyBehavior` interface defines a common contract, while the concrete strategies provide different implementations.

The `Enemy` class acts as the Context and supports changing strategies dynamically through the `setBehavior()` method.

This implementation demonstrates polymorphism, separation of responsibilities, extensibility, and important Clean Code principles.
