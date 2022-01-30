package PrintModes;

import miscellanious.*;

public class BoostMode extends PrintMode {
    private double intensityThreshold;

    public BoostMode(double intensityThreshold, double costPerPage) {
        super(costPerPage);
        this.intensityThreshold = intensityThreshold;
    }

    public Docs boost(Docs input){
        input.setColorIntensity(intensityThreshold);
        System.out.println("boosted successfully");
        return input;
    }

    /**
     * moved this method from PrintMode.java Class as it is not needed in any other child of PrintMode other than
     * BoostMode. So It would have violated the Interface Segregation Principle.
     * */


    public double getIntensityThreshold() {
        return intensityThreshold;
    }

    public void setIntensityThreshold(double intensityThreshold) {
        this.intensityThreshold = intensityThreshold;
    }
}
