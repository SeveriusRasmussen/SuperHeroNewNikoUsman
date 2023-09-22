// #6-7 user story

public class Superhero {

    //Attributes
    private String name;
    private String realName;
    private String superPower;
    private int yearCreated;
    private String isHuman;
    private String strenght;

    // This metode.
    public void setName(String name) {
        this.name = name;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public void setIsHuman(String isHuman) {
        this.isHuman = isHuman;
    }

    public void setStrenght(String strenght) {
        this.strenght = strenght;
    }



    //konstruktør
    public Superhero(String name, String realName,
                     String superPower, int yearCreated, String isHuman, String strenght) {
        this.name = name;
        this.realName = realName;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strenght = strenght;
    }

    //get metoder
    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public String getIsHuman() {
        return isHuman;
    }

    public String getStrenght() {
        return strenght;
    }



    @Override
    public String toString() {
        return "\nSuperhero name: " + name +
                "\nReal name: " + realName +
                "\nSuper power: " + superPower +
                " \nYear created: " + yearCreated +
                " \nIs human: " + isHuman +
                " \nStrenght: " + strenght;
    }
}