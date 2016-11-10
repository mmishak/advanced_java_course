package com.pokemons;

import com.pokemons.battle.PokemonBattle;
import com.pokemons.pokemon.Pokemon;

/**
 * Created by mmishak on 01/11/16.
 */
public class Main {
    public static void main(String[] args) {

        PokemonBattle battle = new PokemonBattle();

        battle.begin(new Pokemon("Dimas"), new Pokemon("Denchik"));
    }
}
