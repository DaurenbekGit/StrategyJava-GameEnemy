package EnemyBehavoir;

public class StealthBehavior implements EnemyBehavior{
    @Override
    public void execute(){
        System.out.println("Enemy hides from the player!");
    }
}
