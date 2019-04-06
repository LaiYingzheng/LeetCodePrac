package Supplement;
import java.util.Arrays;
/*
    1.insert element into the queue
    2.remove element from the queue
    3.check top element
    4.define order of the insert elements
    5.display the queue

 */
public class queue {

    private String[] queueArray;
    private int queueSize;
    private int front, rear, numOfItems = 0;

    queue(int size){
        queueSize = size;
        queueArray = new String[size];
        Arrays.fill(queueArray, "-1");
    }
    // insert elements
    public void insert(String input){
        if(numOfItems + 1 <= queueSize){
            queueArray[rear] = input;
            rear++;
            numOfItems++;
            System.out.println("INSERT " + input + "was added into the queue");
        }else{
            System.out.println("failed, queue is full");
        }
    }

    //remove elements
    public void remove(){
        if(numOfItems > 0) {
            System.out.println("REMOVE " + queueArray[front] + "was removed from the queue");
            queueArray[front] = "-1";
            front++;
            numOfItems--;
        }else{
            System.out.println("failed, queue is empty");
        }
    }

    //show the peek
    public void peek(){
        System.out.println("the First element is " + queueArray[front]);
    }

    // define priority of the queue (greater number on the front)
    public void priorityInsert(String input){
        int i;
        if(numOfItems ==0){
            insert(input);
        }else{
            for(i = numOfItems-1; i >=0; i--){
                if(Integer.parseInt(input)> Integer.parseInt(queueArray[i])){
                    queueArray[i+1] = queueArray[i];
                }else break;
            }

            queueArray[i+1] = input;
            rear++;
            numOfItems++;
        }
    }

    //display the stack
    public void displayQueue(){
        for(int n = 0; n < 61; n++)
            System.out.print("-");
        System.out.println();
        for ( int n = 0; n < queueSize; n++){
            System.out.format("| %2s" + " ", n);
        }

        System.out.println();

        for(int n = 0; n < 61; n++)
            System.out.print("-");
        System.out.println();

        for ( int n = 0; n < queueSize; n++){

            if (queueArray[n].equals("-1"))
                System.out.print("|    ");
            else
                System.out.format("| %2s" + " ", queueArray[n]);

        }
        System.out.println("|");

        for(int n = 0; n < 61; n++)
            System.out.print("-");
        System.out.println();

        //number of space to put before the front
        int spacesBeforeFront = 3*(2*(front+1)-1);
        for (int k = 1; k < spacesBeforeFront; k++) System.out.print(" ");
        System.out.print("F");

        //number of space to put before the rear
        int spaceBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);
        for(int l =0; l < spaceBeforeRear; l++) System.out.print(" ");
        System.out.print("R");
        System.out.println("\n");
    }

    public static void main(String[] args){
        queue queue1= new queue(10);
        queue1.priorityInsert("11");
        queue1.priorityInsert("121");
        queue1.priorityInsert("112");
        queue1.displayQueue();
        queue1.remove();
        queue1.displayQueue();
        queue1.peek();

    }

}
