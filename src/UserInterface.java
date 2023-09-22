// #8 user story

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    public void StartProgram() {

        final int CREATE_HERO = 1;
        final int SUPERHERO_LIST = 4;
        final int SEARCH_SUPERHERO = 7;
        final int EDIT_SUPERHERO = 8;
        final int EXIT_PROGRAM = 9;
        int choice;

        System.out.println("Welcome to superhero universe");

        Database database = new Database();
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.println("\nMake your choice sir");
            System.out.println("1. Create a superhero");
            System.out.println("4. Print superhero list");
            System.out.println("7. Search for a superhero");
            System.out.println("8. Edit superhero");
            System.out.println("9. Exit program");

            while (!keyboard.hasNextInt()) {
                String text = keyboard.next();
                System.out.println(text + " Is not a valid number, try again");
            }
            choice = keyboard.nextInt();

            keyboard.nextLine(); //clearer scanneren

            if (choice == CREATE_HERO) {

                System.out.println("Create your hero:\n");
                System.out.println("Your Superhero name?");
                String name = keyboard.nextLine();
                System.out.println("Your real name?");
                String realName = keyboard.nextLine();
                System.out.println("Your superpower?");
                String superPower = keyboard.nextLine();
                System.out.println("What year did you get created?");
                while (!keyboard.hasNextInt()) {
                    String text = keyboard.next();
                    System.out.println(text + " Is not a valid number, try again");
                    System.out.println("What year did you get created?");
                }
                int yearCreated = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Is your superhero human?");
                String isHuman = keyboard.nextLine();
                System.out.println("What is your superhero strenght?");
                String strenght = keyboard.nextLine();

                Superhero hero = new Superhero(name, realName, superPower, yearCreated, isHuman, strenght);
                database.addSuperhero(hero);

                System.out.println("New hero created:\n " + hero);

            } else if (choice == SUPERHERO_LIST) {
                System.out.println(database.getSuperherolist());

            } else if (choice == SEARCH_SUPERHERO) {
                System.out.println("What superhero do you wanna search for?");
                String searchTerm = keyboard.nextLine();
                Superhero sh = database.findSuperhero(searchTerm);
                if (sh != null) {
                    System.out.println("your superhero" + sh);
                } else {
                    System.out.println(" No matching superhero, sadge");
                }

            } else if (choice == EDIT_SUPERHERO) {
                System.out.println("What superhero do you wanna edit?");
                String brugerInput = keyboard.nextLine();

                //find superhelte
                ArrayList<Superhero> søgeResultat = database.findSuperheroes(brugerInput);
                Superhero superheroDerSkalRedigeres = null;

                //søgning finder ingen personer
                if (søgeResultat.size() == 0) {
                    System.out.println("No superheroes found");
                } else if (søgeResultat.size() > 1) {
                    //vælg en superhelt i søgeresultatet med flere personer
                    System.out.println("Choose a superhero");
                    int count = 1;
                    for (Superhero superhero : søgeResultat) {
                        System.out.println(count++ + "." + " " +
                                superhero.getName() + " " + " " +
                                superhero.getRealName() + " " + " " +
                                superhero.getSuperPower() + " " + " " +
                                superhero.getYearCreated() + " " + " " +
                                superhero.getIsHuman() + " " + " " +
                                superhero.getStrenght());
                    }

                    int superheroValg = keyboard.nextInt();
                    keyboard.nextLine(); //clearer scanner
                    superheroDerSkalRedigeres = søgeResultat.get(superheroValg - 1);
                }
                //søgning finder 1 person
                else {
                    superheroDerSkalRedigeres = søgeResultat.get(0);
                }
                //Redigering af valgte personer

                if (superheroDerSkalRedigeres != null) {
                    System.out.println("Edit superhero stats. Press Enter if the stats do not need to get changed");
                    String nyVærdi;
                    System.out.println("Superhero name: " + superheroDerSkalRedigeres.getName());
                    nyVærdi = keyboard.nextLine();
                    if (!nyVærdi.isEmpty()) {
                        superheroDerSkalRedigeres.setName(nyVærdi);
                    }
                    System.out.println("Real name: " + superheroDerSkalRedigeres.getRealName());
                    nyVærdi = keyboard.nextLine();
                    if (!nyVærdi.isEmpty()) {
                        superheroDerSkalRedigeres.setRealName(nyVærdi);
                    }
                    System.out.println("Super power: " + superheroDerSkalRedigeres.getSuperPower());
                    nyVærdi = keyboard.nextLine();
                    if (!nyVærdi.isEmpty()) {
                        superheroDerSkalRedigeres.setSuperPower(nyVærdi);
                    }
                    System.out.println("Year created: " + superheroDerSkalRedigeres.getYearCreated());
                    do {
                        nyVærdi = keyboard.nextLine();
                        if (nyVærdi.isEmpty()) {
                            break;
                        } else {
                            try {
                                superheroDerSkalRedigeres.setYearCreated(Integer.parseInt(nyVærdi));
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Its not a valid number, try again");
                            }
                        }
                    } while (true);
                    /*while (!keyboard.hasNextInt()) {
                        keyboard.nextLine();
                        System.out.println("Its not a valid number, try again");
                        System.out.println("Year created: " + superheroDerSkalRedigeres.getYearCreated());
                    }
                    nyVærdi = keyboard.next();
                    if (!nyVærdi.isEmpty()) {
                        superheroDerSkalRedigeres.setYearCreated(Integer.parseInt(nyVærdi));
                    } */

                    //keyboard.nextLine();
                    System.out.println("Is Human: " + superheroDerSkalRedigeres.getIsHuman());
                    nyVærdi = keyboard.nextLine();
                    if (!nyVærdi.isEmpty()) {
                        superheroDerSkalRedigeres.setIsHuman(nyVærdi);
                    }
                    System.out.println("Strenght: " + superheroDerSkalRedigeres.getStrenght());
                    nyVærdi = keyboard.nextLine();
                    if (!nyVærdi.isEmpty()) {
                        superheroDerSkalRedigeres.setStrenght(nyVærdi);
                    }
                    System.out.println(superheroDerSkalRedigeres);
                }

            }

        } while (choice != EXIT_PROGRAM);
        System.out.println("See you next time");
    }
}