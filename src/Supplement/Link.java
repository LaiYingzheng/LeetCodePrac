package Supplement;

public class Link {
    //define variables
    public String bookName;
    public int millionSold;

    public Link next;

    public Link( String bookName, int millionSold){
        this.bookName = bookName;
        this. millionSold = millionSold;
    }

    public void display(){
        System.out.println(bookName+ ": "+ millionSold + ",000,000");
    }

    public String toString(){
        return bookName;
    }

    public static void main(String[] args){

        Linklist ll1 = new Linklist();
        ll1.insertFirstLink("book1", 1200);
        ll1.insertFirstLink("book12", 123);
        ll1.display();
        ll1.removeLink("book12");
        ll1.display();

    }

}

class Linklist{

    public Link firstLink;

    Linklist(){
        firstLink = null;

    }

    public boolean isEmpty(){
        return (firstLink == null);
    }

    //a new link added
    public void insertFirstLink(String bookName, int millionSold){
        Link newLink = new Link(bookName, millionSold);
        newLink.next = firstLink; //first assigned firstLink = null;
        firstLink = newLink; //re - assign the firstLink
    }

    //remove a link
    public Link removeFirst(){
        Link linkReference = firstLink;

        if(!isEmpty()){
            firstLink = firstLink.next; // remove the first Link
        }else{
            System.out.println("empty linklist");
        }

        return linkReference;
    }

    //cycle throught the linklist
    public void display(){
        Link theLink = firstLink;
        while(theLink != null){
            theLink.display();
            System.out.println("next link: " + theLink.next);
            theLink = theLink.next; // while loop break till theLink = null
            System.out.println();
        }
    }

    //find a link in a linklst -> check throught every link in the linklist for matching
    public Link find(String bookName){
        Link theLink = firstLink;
        if(!isEmpty()){
            while(!theLink.bookName.equals(bookName) ){
                if(theLink.next == null){
                    return null;
                }else{
                    theLink = theLink.next;
                }
            }
        }else{
            System.out.println("Empty Linkedlist");
        }
        return theLink;
    }

    /*
        remove a specific link -> find a match, then remove it, link.next = link.next.next
        CurrentLink = firstLink                                           CurrentLink = firstLink.next
                                currentLink not match    ===========>>>>
        preLink = firstLink                                               preLink = firstLink

                                                CurrentLink = firstLink.next.next
        firstLink.next not match ======>>>>
                                                PreLink = firstLink.next

                                                firstLink = firstLink.next
        firstLink.next match ======>>>>
                                                PreLink = firstLink
    */

    public Link removeLink(String bookName){
        Link currentLink = firstLink;
        Link preLink = firstLink;
        while(currentLink.bookName != bookName){
            if(currentLink.next == null) {
                return null;
            }else{
                preLink = currentLink;
                currentLink = currentLink.next;
            }
        }

        if(currentLink == firstLink){

            firstLink = firstLink.next; // this is the remove step

        }else{
            preLink.next = currentLink.next;
        }

        return currentLink;
    }


}
