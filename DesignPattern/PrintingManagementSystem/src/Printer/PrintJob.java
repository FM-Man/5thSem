package Printer;

import PrintModes.BoostMode;
import PrintModes.PageSavingMode;
import PrintModes.TonerSaveMode;
import miscellanious.Docs;

import java.util.ArrayList;
import java.util.Comparator;

public class PrintJob {
    private ArrayList<PrintRequest> printRequests;
    //private PrioritySettings priority;
    /**
     * Priority is not needed in PrintJob rather it is important for every single PrintRequests.
     * So it violated Single Responsibility Principle.
     * */

    public PrintJob(ArrayList<PrintRequest> printRequests) {
        this.printRequests = printRequests;
    }

    public PrintJob() {
        printRequests = new ArrayList<>();
    }
//    public void changePriority(int priority) {
//    }
    /**
     * changing priority should be a responsibility of the PrioritySettings Class.
     * So it Violated Single Responsibility Principle.
     * */

    public void addJob(PrintRequest printRequest){
        printRequests.add(printRequest);
    }

    public void pullJob(){
        printRequests.sort(Comparator.comparingInt(printRequest -> printRequest.getPriority().getPriority()));
        PrintRequest request = printRequests.remove(0);
        if(request.getMode() instanceof BoostMode){
            Docs reqDoc = request.getDocument();
            reqDoc = ((BoostMode) request.getMode()).boost(reqDoc);
            request.setDocument(reqDoc);
        }
        else if (request.getMode() instanceof PageSavingMode){
            Docs reqDoc = request.getDocument();
            reqDoc = ((PageSavingMode) request.getMode()).savePages(reqDoc);
            request.setDocument(reqDoc);

            ((PageSavingMode) request.getMode()).renderPreview(reqDoc);
        }
        else if(request.getMode() instanceof TonerSaveMode){
            Docs reqDoc = request.getDocument();
            reqDoc = ((TonerSaveMode) request.getMode()).saveToner(reqDoc);
            request.setDocument(reqDoc);
        }

        System.out.println(request.getDocument().getContent()+" successfully printed");
        System.out.println("Total page: "+request.getDocument().getNumberOfPages());
        System.out.println("Total cost: "+ request.getMode().getCostPerPage()*request.getDocument().getNumberOfPages());
        System.out.println();
    }
}
