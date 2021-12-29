package Main;

public class duration {
    String name;
    int start, end;
    String description;
    public duration(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public duration(String name, int start, int end, String description) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.description = description;
    }
}
