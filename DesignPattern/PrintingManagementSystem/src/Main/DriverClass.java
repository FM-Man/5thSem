package Main;

import PrintModes.BoostMode;
import PrintModes.PageSavingMode;
import PrintModes.PrintMode;
import PrintModes.TonerSaveMode;
import Printer.*;
import miscellanious.*;

import java.util.ArrayList;

public class DriverClass {
    public static ArrayList<Docs> initDocs(){
        ArrayList<Docs> docs = new ArrayList<>();
        Docs document1 = new Docs("This is Document 1's content.",1,new PageSize(4,2,1), "Portrait", 5.0);
        Docs document2 = new Docs("This is Document 2's content.",2,new PageSize(4,2,1), "Portrait", 5.0);
        Docs document3 = new Docs("This is Document 3's content.",3,new PageSize(2,4,1), "Landscape", 5.0);
        Docs document4 = new Docs("This is Document 4's content.",4,new PageSize(2,4,1), "Landscape", 5.0);
        Docs document5 = new Docs("This is Document 5's content.",5,new PageSize(4,2,1), "Portrait", 5.0);
        Docs document6 = new Docs("This is Document 6's content.",6,new PageSize(2,4,1), "Landscape", 5.0);

        docs.add(document1);
        docs.add(document2);
        docs.add(document3);
        docs.add(document4);
        docs.add(document5);
        docs.add(document6);
        return docs;
    }

    public static ArrayList<PrintRequest> initPrintRequests(){
        ArrayList<Docs> docs = initDocs();
        ArrayList<PrintRequest> printRequests = new ArrayList<>();

        PrintRequest pr1 = new PrintRequest(docs.get(0), new BoostMode(6, 4), new PrioritySettings(3));
        PrintRequest pr2 = new PrintRequest(docs.get(1), new TonerSaveMode("High", 4), new PrioritySettings(2));
        PrintRequest pr3 = new PrintRequest(docs.get(2), new PageSavingMode(4), new PrioritySettings(1));
        PrintRequest pr4 = new PrintRequest(docs.get(3), new BoostMode(7, 4), new PrioritySettings(5));
        PrintRequest pr5 = new PrintRequest(docs.get(4), new TonerSaveMode("Low", 4), new PrioritySettings(4));
        PrintRequest pr6 = new PrintRequest(docs.get(5), new PageSavingMode(6), new PrioritySettings(7));

        printRequests.add(pr1);
        printRequests.add(pr2);
        printRequests.add(pr3);
        printRequests.add(pr4);
        printRequests.add(pr5);
        printRequests.add(pr6);
        return printRequests;
    }

    public static void main(String[] args) {
        ArrayList<PrintRequest> printRequests = initPrintRequests();

        PrintJob pj = new PrintJob();
        pj.addJob(printRequests.get(0));
        pj.addJob(printRequests.get(2));
        pj.pullJob();
        pj.addJob(printRequests.get(3));
        pj.addJob(printRequests.get(5));
        pj.addJob(printRequests.get(1));
        pj.pullJob();
        pj.addJob(printRequests.get(4));
        pj.pullJob();
        pj.pullJob();
        pj.pullJob();
        pj.pullJob();
    }
}
