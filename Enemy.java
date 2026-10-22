import EnemyBehavoir.EnemyBehavior;

public class Enemy {
    private EnemyBehavior behavior;

    public Enemy(EnemyBehavior behavior){
        this.behavior = behavior;
    }

    public void setBehavior(EnemyBehavior behavior){
        this.behavior = behavior;
    }

    public void performAction(){
        behavior.execute();
    }
}