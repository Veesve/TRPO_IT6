package lab3.model;

public class Film {
    private String title;
    private int cost;
    private FilmTypes type;

    public Film(String title, int cost, FilmTypes type) {
        this.title = title;
        this.cost = cost;
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    public FilmTypes getType() {
        return type;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(FilmTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", cost=" + cost +
                ", type=" + type +
                '}';
    }
}
