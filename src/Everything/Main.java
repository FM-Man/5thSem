package Everything;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<KeyValuePair> dictionary = new ArrayList<>();
    public static int n = 5;

    public static void initDictionary() throws FileNotFoundException {
        File rawDictionary = new File("Translation.txt");
        Scanner sc = new Scanner(rawDictionary);

        while(sc.hasNextLine()){
            String currentLine = sc.nextLine();
            String [] splitString = currentLine.split("[|]",0);
            KeyValuePair keyValuePair = new KeyValuePair(splitString[1],splitString[2]);

            if(dictionary.size()!=0){
                if(!dictionary.get(dictionary.size()-1).english.equals(keyValuePair.english))
                    dictionary.add(keyValuePair);
            }
            else dictionary.add(keyValuePair);
        }
        System.out.println(dictionary.size());
    }

    public static void main(String[] args) throws FileNotFoundException {
        initDictionary();

        BPT bpt = new BPT(n-1);

        for (KeyValuePair entry:
             dictionary) {
            bpt.insert(entry.english, entry.bengali);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("all successfull");
        for (KeyValuePair kvp:
             dictionary) {
            System.out.println(kvp.english+" "+bpt.search(kvp.english));
        }

        String s = scanner.nextLine();
        System.out.println(bpt.search(s));
    }
}
