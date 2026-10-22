import EnemyBehavoir.AggressiveBehavior;
import EnemyBehavoir.DefensiveBehavior;
import EnemyBehavoir.StealthBehavior;

public class Main {
    public static void main(String[] args){
        Enemy enemy = new Enemy(new AggressiveBehavior());

        enemy.performAction();

        enemy.setBehavior(new DefensiveBehavior());
        enemy.performAction();

        enemy.setBehavior(new StealthBehavior());
        enemy.performAction();
    }
}