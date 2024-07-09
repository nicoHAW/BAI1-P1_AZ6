package multiPurposeList;

import java.util.Objects;

public class Node<T> {

    //----- VARIABLES -----
    T data;
    Node<T> next;
    Node<T> prev;




    //----- CONSTRUCTOR -----
    public Node( T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }//constructor




    //----- METHODS -----


    //----- | GETTER | SETTER | STANDARDS | -----

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }//hashcode




    
    @Override
    public boolean equals(Object other) {
        //same Object?
        if (this == other)
            return true;

        //is null?
        if (other == null)
            return false;

        //same class=?
        if (this.getClass() != other.getClass())
            return false;

        //same content?
        Node<T> otherNode = (Node<T>) other;
        return this.data.equals(otherNode.data);    //compare if data are same
    }// equals



// deliver data, next and prev
    @Override
    public String toString() {
        return String.format("[<%s> : Daten = %s,    Next = %s,    prev = %s]", this.data,this.next, this.prev ); 

    } //toString

}//class
