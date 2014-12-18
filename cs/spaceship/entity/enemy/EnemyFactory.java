/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

/**
 *
 * @author s544545
 */
public abstract class EnemyFactory {
    public abstract Enemy build();
    public Enemy build(int param1, int param2) {return build();}
    public Enemy[] buildArray() {
        return new Enemy[] {build()};
    }
}
