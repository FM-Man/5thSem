package x;

public class InternalNode extends Node {
    int maxDegree;
    int minDegree;
    int degree;
    InternalNode leftSibling;
    InternalNode rightSibling;
    String[] keys;
    Node[] childPointers;

    /**
     * Constructor
     * @param m: the max degree of the x.InternalNode
     * @param keys: the list of keys that x.InternalNode is initialized with
     */
    public InternalNode(int m, String[] keys) {
        this.maxDegree = m-1;
        this.minDegree = (int)Math.ceil((m-1)/2.0);
        this.degree = 0;
        this.keys = keys;
        this.childPointers = new Node[this.maxDegree+1];
    }

    /**
     * Constructor
     * @param m: the max degree of the x.InternalNode
     * @param keys: the list of keys that x.InternalNode is initialized with
     * @param pointers: the list of pointers that x.InternalNode is initialized with
     */
    public InternalNode(int m, String[] keys, Node[] pointers) {
        this.maxDegree = m;
        this.minDegree = (int)Math.ceil(m/2.0);
        this.degree = HelperFunction.linearNullSearch(pointers);
        this.keys = keys;
        this.childPointers = pointers;
    }

    /**
     * This method appends 'pointer' to the end of the childPointers
     * instance variable of the x.InternalNode object. The pointer can point to
     * an x.InternalNode object or a x.LeafNode object since the formal
     * parameter specifies a x.Node object.
     * @param pointer: x.Node pointer that is to be appended to the
     *                    childPointers list
     */
    public void appendChildPointer(Node pointer) {
        this.childPointers[degree] = pointer;
        this.degree++;
    }

    /**
     * Given a x.Node pointer, this method will return the index of where the
     * pointer lies within the childPointers instance variable. If the pointer
     * can't be found, the method returns -1.
     * @param pointer: a x.Node pointer that may lie within the childPointers
     *                     instance variable
     * @return the index of 'pointer' within childPointers, or -1 if
     * 'pointer' can't be found
     */
    public int findIndexOfPointer(Node pointer) {
        for (int i = 0; i < childPointers.length; i++) {
            if (childPointers[i] == pointer) { return i; }
        }
        return -1;
    }

    /**
     * Given a pointer to a x.Node object and an integer index, this method
     * inserts the pointer at the specified index within the childPointers
     * instance variable. As a result of the insert, some pointers may be
     * shifted to the right of the index.
     * @param pointer: the x.Node pointer to be inserted
     * @param index: the index at which the insert is to take place
     */
    public void insertChildPointer(Node pointer, int index) {
        for (int i = degree - 1; i >= index ;i--) {
            childPointers[i + 1] = childPointers[i];
        }
        this.childPointers[index] = pointer;
        this.degree++;
    }

    /**
     * This simple method determines if the x.InternalNode is deficient or not.
     * An x.InternalNode is deficient when its current degree of children falls
     * below the allowed minimum.
     * @return a boolean indicating whether the x.InternalNode is deficient
     * or not
     */
    public boolean isDeficient() {
        return this.degree < this.minDegree;
    }

    /**
     * This simple method determines if the x.InternalNode is capable of
     * lending one of its dictionary pairs to a deficient node. An x.InternalNode
     * can give away a dictionary pair if its current degree is above the
     * specified minimum.
     * @return a boolean indicating whether or not the x.InternalNode has
     * enough dictionary pairs in order to give one away.
     */
    public boolean isLendable() { return this.degree > this.minDegree; }

    /**
     * This simple method determines if the x.InternalNode is capable of being
     * merged with. An x.InternalNode can be merged with if it has the minimum
     * degree of children.
     * @return a boolean indicating whether or not the x.InternalNode can be
     * merged with
     */
    public boolean isMergeable() { return this.degree == this.minDegree; }

    /**
     * This simple method determines if the x.InternalNode is considered overfull,
     * i.e. the x.InternalNode object's current degree is one more than the
     * specified maximum.
     * @return a boolean indicating if the x.InternalNode is overfull
     */
    public boolean isOverfull() {
        return this.degree == maxDegree + 1;
    }

    /**
     * Given a pointer to a x.Node object, this method inserts the pointer to
     * the beginning of the childPointers instance variable.
     * @param pointer: the x.Node object to be prepended within childPointers
     */
    public void prependChildPointer(Node pointer) {
        for (int i = degree - 1; i >= 0 ;i--) {
            childPointers[i + 1] = childPointers[i];
        }
        this.childPointers[0] = pointer;
        this.degree++;
    }

    /**
     * This method sets keys[index] to null. This method is used within the
     * parent of a merging, deficient x.LeafNode.
     * @param index: the location within keys to be set to null
     */
    public void removeKey(int index) { this.keys[index] = null; }

    /**
     * This method sets childPointers[index] to null and additionally
     * decrements the current degree of the x.InternalNode.
     * @param index: the location within childPointers to be set to null
     */
    public void removePointer(int index) {
        this.childPointers[index] = null;
        this.degree--;
    }

    /**
     * This method removes 'pointer' from the childPointers instance
     * variable and decrements the current degree of the x.InternalNode. The
     * index where the pointer node was assigned is set to null.
     * @param pointer: the x.Node pointer to be removed from childPointers
     */
    public void removePointer(Node pointer) {
        for (int i = 0; i < childPointers.length; i++) {
            if (childPointers[i] == pointer) { this.childPointers[i] = null; }
        }
        this.degree--;
    }

}
