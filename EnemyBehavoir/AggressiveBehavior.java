package EnemyBehavoir;

public class AggressiveBehavior implements EnemyBehavior{
    @Override
    public void execute(){
        System.out.println("Enemy attacks the player!");
    }
}
