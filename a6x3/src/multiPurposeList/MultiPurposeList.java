package multiPurposeList;

public class MultiPurposeList<T> implements MultiPurposeList_I<T> {

    //----- VARIABLES -----
    private int listSize;
    private Node<T> head;
    private Node<T> tail;





    //----- CONSTRUCTOR -----
    public MultiPurposeList() {
        this.listSize = 0;
        this.head = null; 
        this.tail = null;
    }//constructor





    //----- METHODS -----

    // --- //----- OVERRIDE -----

    //get data from requested Position
    @Override
    public T getNo(int requestedPosition) {
        // ----- asserts -----
        assert this.listSize > 0 : "List is empty";     //list can't be empty to deliver data. 
        assert this.listSize > requestedPosition : "Requested Position is out if list index"; //list has to be bigger than requested Position.

        if ( this.listSize > requestedPosition ) {
            Node<T> workNode = iGetNodeNo(requestedPosition);   //use method to get Node from requested Position

            return workNode.data;                               //return data from rq

        }
        return null;                                            //returns null if ListSize is not valid
    }//getNo



    //get Data from requested position and remove node
    @Override
    public T extractNo(int requestedPosition) {

        T workData = getNo(requestedPosition);              //get Data from Position and Testing
        Node<T> workNode = iGetNodeNo(requestedPosition);   //get Node from Position
        iRemoveNode(workNode);                              //delete Noed from Position

        return workData;

    } //extractNo



    //check if list contains data. 
    @Override
    public boolean contains(T info) {
        // --- asserts ---
        assert info!=null : "requested Object is null";     //assert: cant be null


        //--- variables ---
        Node<T> work = head;

        // iterate through list until data found or end of list is reached
        while (!work.data.equals(info) && work!=null) {
            work = work.next;
        } //while

        return (work.data.equals(info));            //returns if data are equal
    }



    //
    @Override
    public void putNo(int requestedPosition, T info) {
        //--- asserts
        assert info != null : "data can't be null";   //check if data null
        assert this.listSize >= requestedPosition : "position out of range";

        Node<T> newNode = new Node<T>(info);    //create new node with info as data
        this.listSize++;                        //increase ListSize after adding new Nose.

        // special cases
        if (this.listSize == 0) {   //only object in List.
            head = newNode;
            tail = newNode;
        } else if ( requestedPosition == 0 ) {  //new first object in List.
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else if ( requestedPosition == this.listSize ) {  //new last objct in List
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {                        // put at requested positon

            Node<T> tempNode = iGetNodeNo(requestedPosition); // get Node from Position
            newNode.next = tempNode;        // make old Node on position newNodes next
            newNode.prev = tempNode.prev;   // make old Nodes prev on position newNodes p
            tempNode.prev.next = newNode;   // make prevs next new node 
            tempNode.prev = newNode;        // make newNode old nodes prev
        } //ifelse
    } //putNo

    @Override
    public T setNo(int requestedPosition, T info) {
        //--- asserts ---
        assert info != null : "Data can't be null";
        assert this.listSize >= requestedPosition : "requestedPosition out of List";


        Node<T> tempNode = iGetNodeNo(requestedPosition);       //get Node from Position
        T tempData = tempNode.data;                             //store request Data in 
        tempNode.data = info;                                   //set Data

        return tempData;

    } //setNo



    //remove node by data object
    @Override
    public boolean remove(T info) {
        //--- assert ---
        assert info != null : "Data can't be null";

        Node<T> tempNode = iSearchNode(info); // get Node with requested Data
        tempNode.data = null;

        return iRemoveNode(tempNode);       //remove Node and get boolean about success
    } //



    //remove Node by position
    @Override
    public void removeNo(int requstedPosition) {
        //--- assert ---
        assert this.listSize > requstedPosition : "requstedPosition out of List";   //pos can't be bigger because position of last node is ListSize-1

        if ( this.listSize > requstedPosition ) {         //last Object is listSize-1
            Node<T> tempNode = iGetNodeNo(requstedPosition); //get Node from position
            tempNode.data = null;                            //set data to null

            iRemoveNode(tempNode);                          //delete Node 
        }//if
    } //removeNo

    @Override
    public boolean isEmpty() {
        return (this.listSize == 0);
    }//isEmpty

    //reset List to beginning state. 
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.listSize = 0;
    } //clear




    // --- //----- HELPER -----
    private Node<T> iSearchNode(T wantedData) {
        Node<T> wantedNode = head;

        //go through nodes until this data equals wanted data
        while (!wantedNode.data.equals(wantedData)) {   
            wantedNode = wantedNode.next;               //iterate through List
        } //while

        return wantedNode;
    } // iSearchNode



    private Node<T> iGetNodeNo(int wantedPos) {
        Node<T> wantedNode=head;                        //start with head for pos = 0

        //go through nodes until pos is wanted pos.
        for (int pos = 0; pos <= wantedPos; pos++) {
            wantedNode = wantedNode.next;               //iterate wantedNode through List
        } //for

        return wantedNode;
    }//iGetNodeno



    private boolean iRemoveNode(Node<T> givenNode) {
        //given Node first Node (head)
        if (givenNode == this.head) {           //Node is head if Node == head.
            Node<T> newHead = givenNode.next;   //create tempHead (next in List is new Head)
            newHead.prev = null;                //delete old head
            this.head = newHead;                //make tempHead new Head

            this.listSize--;                    //decrease List Size

            return true;
        }//iRemoveNode


        //givenNode is Last Node (tail)
        if (givenNode == this.tail) {           //Node is tail if Node == tail
            Node<T> newTail = givenNode.prev;   //create TempTail (prev Node is new Tail)
            newTail.next = null;                //delete Tail
            this.tail = newTail;                //make tempTail ne Tail

            this.listSize--;                    //decrease List Size

            return true;
        } //if


        //givenNode only Node (listSize == 0)
        if (givenNode.next == null && givenNode.prev == null) { //given Node is only Node if next and prev are null also means that it's head and tail
            this.head = null;                                   // make head null 
            this.tail = null;                                   // make tail null

            this.listSize--;                                     //decrease List Size

            return true;
        } //if


        //givenNode between nodes
        if (givenNode != this.head && givenNode != this.tail ) {

            Node<T> prevNode = givenNode.prev;      //prev Node of given Node
            Node<T> nextNode = givenNode.next;      //next Node of given Node

            //bypass given Node
            prevNode.next = nextNode;               //make current next to next of prev
            nextNode.prev = prevNode;               //make current prev to prev of next.

            this.listSize--;                        //decrease List Size

            return true;
        }//if

        return false;
    }//iRemoveNode



    @Override
    public int getSize() {
        return listSize;
    }//getSize

}
