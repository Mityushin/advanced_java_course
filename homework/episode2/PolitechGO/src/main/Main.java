package main;

import java.util.Scanner;

/**
 * Created by user on 10.11.16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("PolitechGO v0.1 -***- Follow me: @jees182");
        System.out.println();
        Pokemon pokemon1 = new PokemonBuilder()
                .buildPokemonID(1)
                .buildName("First")
                .buildHealth(120)
                .build();
        Pokemon pokemon2 = new PokemonBuilder()
                .buildPokemonID(2)
                .buildName("Second")
                .buildHealth(120)
                .build();
        Scanner in = new Scanner(System.in);
        String turn = "";
        pokemon1.goFight();
        pokemon2.goFight();
        while (true) {
            System.out.println(pokemon1.toString());
            System.out.println(pokemon2.toString());
            System.out.println("pokemon1's turn");
            System.out.println("                             1 - attack1");
            System.out.println("                             2 - attack2");
            System.out.println("                             3 - block");
            System.out.println("                             q - quit");
            System.out.print("Turn: ");
            turn = in.next();
            switch (turn) {
                case "q": {
                    System.out.println("Game finished.");
                    System.out.println("PolitechGO v0.1 -***- Follow me: @jees182");
                    return;
                }
                case "1": {
                    pokemon2.attack1();
                    break;
                }
                case "2": {
                    pokemon2.attack2();
                    break;
                }
                case "3": {
                    pokemon2.block();
                    break;
                }
            }

            System.out.println("pokemon2's turn");
            System.out.println("                             1 - attack1");
            System.out.println("                             2 - attack2");
            System.out.println("                             3 - block");
            System.out.println("                             q - quit");
            System.out.print("Turn: ");
            turn = in.next();
            switch (turn) {
                case "1": {
                    pokemon1.attack1();
                    break;
                }
                case "2": {
                    pokemon1.attack2();
                    break;
                }
                case "3": {
                    pokemon1.block();
                    break;
                }
                case "q": {
                    System.out.println("Game finished.");
                    System.out.println("PolitechGO v0.1 -***- Follow me: @jees182");
                    return;
                }
            }
            System.out.println("___");
        }
    }
}
