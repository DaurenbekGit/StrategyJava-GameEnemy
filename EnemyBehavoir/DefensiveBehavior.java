package EnemyBehavoir;

public class DefensiveBehavior implements EnemyBehavior{
    @Override
    public void execute(){
        System.out.println("Enemy blocks the attack!");
    }
}
