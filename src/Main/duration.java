package Main;

public class duration {
    public String name;
    public int start, end, id;
    public String description;

    public duration(String name, int start, int end, int id, String description) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.description = description;
        this.id = id;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
