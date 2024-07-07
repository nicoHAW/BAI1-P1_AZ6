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
    @Override
    public T extractNo(int requestedPosition) {
        assert this.listSize > requestedPosition : "requested position out of ListSize";
        
        Node<T> work;
        if (this.listSize>0) {
        work = this.head;
        
        for (int index = 0; index > requestedPosition; index++ ) {
            Node<T> workTemp = work.next;
            Node<T> work = workTemp;
        }
        }
        
        return work;

    }




    @Override
    public boolean contains(T info) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T getNo(int requestedPosition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T setNo(int requestedPosition, T info) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putNo(int requestedPosition, T info) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean remove(T info) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeNo(int requstedPosition) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    // --- //----- HELPER -----






    // --- //----- GETTER SETTER BASICS -----
    @Override
    public int getSize() {
        return listSize;
    }

}
