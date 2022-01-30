package PrintModes;

public abstract class PrintMode {
    private double costPerPage;
//    private int numberOfPages;
//    private PageSize pageSize;
//    private String orientation;
//    private double colorIntensity;
    /**
     * Removed these variables to the Docs.java Class because they are needed to specify a document not a print mode.
     * So these variables violate the Single Responsibility principle.
     * */

    public PrintMode(double costPerPage) {
        this.costPerPage = costPerPage;
    }

    public double getCostPerPage() {
        return costPerPage;
    }

    public void setCostPerPage(double costPerPage) {
        this.costPerPage = costPerPage;
    }

//    public void saveToner(Docs input){
//    }
    /**
     * moved this method to TonerSaverMode.java Class as it is not needed in any other child of PrintMode other than
     * Toner saver mode. So It would have violated the Interface Segregation Principle.
     * */
//    public void boost(Docs input){
//    }
    /**
     * moved this method to BoostMode.java Class as it is not needed in any other child of PrintMode other than
     * BoostMode. So It would have violated the Interface Segregation Principle.
     * */
//    public Docs savePages(Docs inputDocument){
//    }

    /**
     * moved this method to PageSavingMode.java Class as it is not needed in any other child of PrintMode other than
     * PageSavingMode. So It would have violated the Interface Segregation Principle.
     * */
}
