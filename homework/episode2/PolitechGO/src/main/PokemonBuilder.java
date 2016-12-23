package main;

/**
 * Created by user on 11.11.16.
 */
public final class PokemonBuilder {
    private int pokemonID = 0;
    private String name = "Default";
    private int health = 100;

    PokemonBuilder buildPokemonID(int pokemonID) {
        this.pokemonID = pokemonID;
        return this;
    }
    PokemonBuilder buildName(String name) {
        this.name = name;
        return this;
    }
    PokemonBuilder buildHealth(int health) {
        this.health = health;
        return this;
    }
    Pokemon build() {
        Pokemon pokemon = new Pokemon();
        pokemon.setPokemonID(pokemonID);
        pokemon.setName(name);
        pokemon.setHealth(health);
        return pokemon;
    }
}
