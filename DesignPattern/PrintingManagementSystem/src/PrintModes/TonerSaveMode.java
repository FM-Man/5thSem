package PrintModes;

import miscellanious.*;

public class TonerSaveMode extends PrintMode {
    private String tonerSavingLevel;

    public TonerSaveMode(String level, double costPerPage) {
        super(costPerPage);
        tonerSavingLevel = level;

    }


    public Docs saveToner(Docs input){
        if(tonerSavingLevel.equals("High")){
            input.decreaseColorIntensity(1.0);
            System.out.println("Color intensity changed to save Toner");
        }
        else if(tonerSavingLevel.equals("Medium")){
            input.decreaseColorIntensity(2.0);
            System.out.println("Color intensity changed to save Toner");
        }
        else{
            input.decreaseColorIntensity(3.0);
            System.out.println("Color intensity changed to save Toner");
        }
        return input;
    }

    /**
     * moved this method from PrintMode.java Class as it is not needed in any other child of PrintMode other than
     * Toner saver mode. So It would have violated the Interface Segregation Principle.
     * */
}
