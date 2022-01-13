package x;

public class KeyValuePair  implements Comparable<KeyValuePair> {
    public String english;
    public String bengali;

    public KeyValuePair(String english, String bengali){
        this.english=english;
        this.bengali=bengali;
    }


    /**
     * This is a method that allows comparisons to take place between
     * DictionaryPair objects in order to sort them later on
     * @param o
     * @return
     */

    public int compareTo(KeyValuePair o) {
        return english.compareTo(o.english);
    }

}
