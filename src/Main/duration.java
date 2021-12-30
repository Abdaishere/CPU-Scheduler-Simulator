package Main;

public class duration {
    String name;
    int start, end, id;
    String description;

    public duration(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public duration(String name, int start, int end, int id, String description) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.description = description;
        this.id = id;
    }
}
