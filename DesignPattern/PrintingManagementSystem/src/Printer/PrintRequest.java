package Printer;

import PrintModes.PrintMode;
import miscellanious.Docs;

public class PrintRequest {
    private Docs document;
    private PrintMode mode;
    /**
     * We don't need different object for different types of PrintModes because of Liskov Substitution Principle.
     * An object of PrintMode can be replaced by an object from any of its child.
     * */
    private PrioritySettings priority;
    /**
     * Priority is not needed in PrintJob rather it is important for every single PrintRequests.
     * So it violated Single Responsibility Principle.
     * */

    public PrintRequest(Docs document, PrintMode mode) {
        this.document = document;
        this.mode = mode;
        this.priority = new PrioritySettings(0);
    }

    public PrintRequest(Docs document, PrintMode mode, PrioritySettings priority) {
        this.document = document;
        this.mode = mode;
        this.priority = priority;
    }

    public Docs getDocument() {
        return document;
    }

    public void setDocument(Docs document) {
        this.document = document;
    }

    public PrintMode getMode() {
        return mode;
    }

    public void setMode(PrintMode mode) {
        this.mode = mode;
    }

    public PrioritySettings getPriority() {
        return priority;
    }

    public void setPriority(PrioritySettings priority) {
        this.priority = priority;
    }
}
