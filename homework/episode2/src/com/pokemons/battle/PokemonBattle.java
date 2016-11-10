package com.pokemons.battle;

import com.pokemons.pokemon.Pokemon;
import com.pokemons.pokemon.PokemonPosition;
import com.pokemons.pokemon.PokemonState;

import java.util.Scanner;

/**
 * Created by mmishak on 01/11/16.
 */
public class PokemonBattle {

    Pokemon firstPokemon;
    Pokemon secondPokemon;


    public void begin(Pokemon first, Pokemon second){

        firstPokemon = first;
        secondPokemon = second;

        Scanner in = new Scanner(System.in);

        while (firstPokemon.getHealth() > 0 && secondPokemon.getHealth() > 0){

            printStatus(firstPokemon);
            printStatus(secondPokemon);

            System.out.println("pokemon " + firstPokemon.getName() + ":");
            parseCommand(in.nextLine(), firstPokemon);

            System.out.println("pokemon " + secondPokemon.getName() + ":");
            parseCommand(in.nextLine(), secondPokemon);

            fight();
            swap();
        }

        if (firstPokemon.getHealth() > 0)
            System.out.println("Pokemon " + firstPokemon.getName() + " - WIN");
        else if (secondPokemon.getHealth() > 0)
            System.out.println("Pokemon " + secondPokemon.getName() + " - WIN");
        else
            System.out.println("All fail..");

        firstPokemon.relax();
        secondPokemon.relax();


    }

    private void parseCommand(String command, Pokemon pokemon){

        String[] arg = command.split(" ");
        PokemonState tmpState;
        PokemonPosition tmpPasition;

        switch (arg[0]){
            case "attack":
                tmpState = PokemonState.ATTACK;
                break;
            case "defend":
                tmpState = PokemonState.DEFEND;
                break;
            default:
                System.out.println("Command error.");
                return;
        }
        switch (arg[1]){
            case "up":
                tmpPasition = PokemonPosition.UP;
                break;
            case "center":
                tmpPasition = PokemonPosition.CENTER;
                break;
            case "down":
                tmpPasition = PokemonPosition.DOWN;
                break;
            default:
                System.out.println("Command error.");
                return;
        }

        pokemon.setState(tmpState)
                .setPosition(tmpPasition);
    }

    private void fight(){
        firstPokemon.attackedBy(secondPokemon);
        secondPokemon.attackedBy(firstPokemon);
    }

    private void swap(){
        Pokemon tmp = firstPokemon;
        firstPokemon = secondPokemon;
        secondPokemon = tmp;
    }

    private void printStatus(Pokemon pokemon){

        for (int i = 0; i < 112; i++) {
            System.out.print("-");
        }
        System.out.print("\n " + pokemon.getName() + "\n\t\t" + pokemon.getHealth() + "\t");
        for (int i = 0; i < pokemon.getHealth(); i++) {
            System.out.print("|");
        }
        System.out.println();
        for (int i = 0; i < 112; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
