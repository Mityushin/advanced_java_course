package main;

import static main.State.FIGHT;
import static main.State.SLEEP;

/**
 * Created by user on 10.11.16.
 */
public final class Pokemon implements PokemonSimple, ToFight {
    private int pokemonID;
    private String name;
    private int health;
    private int currentHealth;
    private State state = SLEEP;

    void setPokemonID(int pokemonID) {
        this.pokemonID = pokemonID;
    }

    void setName(String name) {
        this.name = name;
    }

    void setHealth(int health) {
        this.health = health;
    }

    Pokemon() {
    }

    private void rollbackCurrentHealth() {
        this.currentHealth = health;
    }

    @Override
    public int getID() {
        return pokemonID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public boolean isDead() {
        return getCurrentHealth() <= 0;
    }

    @Override
    public void goFight() {
        state = FIGHT;
        currentHealth = health;
    }

    @Override
    public void attack1() {
        currentHealth -= 10;
    }

    @Override
    public void attack2() {
        currentHealth -= 29;
    }

    @Override
    public void block() {
        currentHealth = ((currentHealth + 5) > health) ? health : currentHealth + 5;
    }

    @Override
    public String toString() {
        return "ID: " + getID() + " Name: " + getName() + " Health: " + getHealth() + " curHealth: " + getCurrentHealth();
    }
}
