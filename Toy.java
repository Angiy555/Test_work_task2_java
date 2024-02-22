/**
 * Toy
 */
public class Toy {

    private int id;
    private String name;
    private int chanceOfDrop;


    public Toy(int id, String name, int chanceOfDrop){
        this.id = id;
        this.name = name;
        this.chanceOfDrop = chanceOfDrop;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getChanceOfDrop() {
        return chanceOfDrop;
    }

    @Override
    public String toString() {
        return "Игрушка ID №" + id + ". " + name;
    }
}