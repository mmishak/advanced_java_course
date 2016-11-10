package com.pokemons.pokemon;

/**
 * Created by mmishak on 01/11/16.
 */
public class Pokemon {

    private static int DEFAULT_HEALTH = 100;
    private static int LOW_DAMAGE = 10;
    private static int MIDDLE_DAMAGE = 20;
    private static int HIGHT_DAMAGE = 30;

    private PokemonState state;
    private PokemonPosition position;
    private int health;
    private String name;

    public Pokemon(String name){

        this.name = name;

        state = PokemonState.ATTACK;
        position = PokemonPosition.CENTER;

        health = DEFAULT_HEALTH;
    }

    public int getHealth(){
        return health;
    }

    public String getName(){
        return name;
    }

    public Pokemon setState(PokemonState state){
        this.state = state;
        return this;
    }
    public PokemonState getState(){
        return state;
    }

    public void setPosition(PokemonPosition position){
        this.position = position;
    }
    public PokemonPosition getPosition(){
        return position;
    }

    public void attackedBy(Pokemon pokemon){

        if (pokemon.getState() == PokemonState.ATTACK){

            switch (state){

                case ATTACK:
                    if (position == pokemon.getPosition())
                        health -= LOW_DAMAGE;
                    else
                        health -= MIDDLE_DAMAGE;
                    break;
                case DEFEND:
                    if (position != pokemon.getPosition())
                        health -= MIDDLE_DAMAGE;
                    break;
            }
        }
    }

    public void relax(){
        health = DEFAULT_HEALTH;
    }
}
