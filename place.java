package am.aamchiimumbai;

public class place {
    private String busstop;
    private String cabs;
    private int priority;

    public place() {
        //empty constructor needed
    }

    public place(String busstop, String cabs, int priority) {
        this.busstop = busstop;
        this.cabs = cabs;
        this.priority = priority;
    }

    public String getBusstop() {
        return busstop;
    }

    public String getCabs() {
        return cabs;
    }

    public int getPriority() {
        return priority;
    }
}

