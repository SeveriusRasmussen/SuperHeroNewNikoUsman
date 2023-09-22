// #6-7 user story

import java.util.ArrayList;

public class Database {

    //Array
    private ArrayList<Superhero> superherolist;


    //array
    public Database() {
        this.superherolist = new ArrayList<>();
    }

    //get metode
    public ArrayList<Superhero> getSuperherolist() {
        return superherolist;
    }

    //metode til at adde til arraylist
    public void addSuperhero(Superhero superhero) {
        superherolist.add(superhero);
    }

    public Superhero findSuperhero(String superheroName){
        for (Superhero hero : superherolist) {
            if (hero.getName().contains(superheroName))
                return hero;
        }

        return null;
    }

    public ArrayList<Superhero> findSuperheroes(String superheroName){
        ArrayList<Superhero> superheroes = new ArrayList<>();
        for (Superhero superhero : superherolist) {
            if (superhero.getName().contains(superheroName)){
                superheroes.add(superhero);
            }
        }
        return superheroes;
    }
}