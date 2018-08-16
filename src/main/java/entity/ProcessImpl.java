package entity;

public class ProcessImpl {

    private String name;
    private int counter;

    public ProcessImpl(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }
}
