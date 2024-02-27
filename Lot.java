public class Lot {
    private int id;
    private String nameToy;
    private int chanceOfDrop;

    public Lot(int id, String nameToy, int chanceOfDrop){
        this.id = id;
        this.nameToy = nameToy;
        this.chanceOfDrop = chanceOfDrop;
    }

    public int getId() {
        return id;
    }

    public String getNameToy() {
        return nameToy;
    }

    public int getChanceOfDrop() {
        return chanceOfDrop;
    }

    public void setNameToy(String nameToy) {
        this.nameToy = nameToy;
    }

    public void setChanceOfDrop(int chanceOfDrop) {
        this.chanceOfDrop = chanceOfDrop;
    }

    @Override
    public String toString() {
        return "Лот № " + id +  " название " + nameToy + ", вероятность выпадения " + chanceOfDrop + " %";
    }
}
