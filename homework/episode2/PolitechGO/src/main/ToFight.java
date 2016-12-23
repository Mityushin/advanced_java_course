package main;

/**
 * Created by user on 10.11.16.
 */
public interface ToFight {
    int getCurrentHealth();
    boolean isDead();
    void goFight();
    void attack1();
    void attack2();
    void block();
}
