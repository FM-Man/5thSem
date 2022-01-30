package PrintModes;

import miscellanious.*;

public class PageSavingMode extends PrintMode {

    public PageSavingMode(double costPerPage) {
        super(costPerPage);
    }

    public Docs savePages(Docs inputDocument){
        System.out.println("Applied page saving algorithm on Document");
        String content = inputDocument.getContent();
        int pageNumber = inputDocument.getNumberOfPages() - 2;

        Docs output = new Docs(content,pageNumber, inputDocument.getPageSize(), inputDocument.getOrientation(), inputDocument.getColorIntensity());

        return output;
    }

    /**
     * moved this method from PrintMode.java Class as it is not needed in any other child of PrintMode other than
     * PageSavingMode. So It would have violated the Interface Segregation Principle.
     * */


    public void renderPreview(Docs input){
        System.out.println("Preview:");
        System.out.println(input.getContent());
        System.out.println(input.getNumberOfPages()+ " pages");
        System.out.println();
    }
}
