package Printer;

public class PrioritySettings {
    private int priority;

    public PrioritySettings(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void changePriority(int priority) {
        this.priority = priority;
    }
    /**
     * changing priority should be a responsibility of the PrioritySettings Class. So moved this function from PrintJob.
     * So it Violated Single Responsibility Principle.
     * */
}
