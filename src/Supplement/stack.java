package Supplement;
import java.util.Arrays;
/*
    1.push element into the stack
    2.push multiple elements
    3.pop top element
    4.pop all elements
    5.display the stack
    6.check top element
 */
public class stack{

    // define variables
    private String[] stackArray;
    private int stackSize;
    private int topOfStack = -1;


    // initialize the stack
    stack(int size){
        stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray,"-1");
    }

    //display the stack
    public void displayStack(){
        for(int n = 0; n < 61; n++)
            System.out.print("-");
            System.out.println();
        for ( int n = 0; n < stackSize; n++){
            System.out.format("| %2s" + " ", n);
        }

        System.out.println();

        for(int n = 0; n < 61; n++)
            System.out.print("-");
            System.out.println();

        for ( int n = 0; n < stackSize; n++){

            if (stackArray[n].equals("-1"))
                System.out.print("|    ");
            else
                System.out.format("| %2s" + " ", stackArray[n]);

        }
        System.out.println("|");

        for(int n = 0; n < 61; n++)
            System.out.print("-");
        System.out.println();

    }

    // push into stack
    public void push(String input){

        if(topOfStack + 1 < stackSize){
            topOfStack ++;
            stackArray[topOfStack] = input;
        } else {System.out.println("failed because stack is full"); }

        displayStack();

        System.out.println("Push " + input + " was added into the stack");
    }

    // pop out the top element of stack
    public String pop(){
        if(topOfStack >= 0 ){
            displayStack();
            System.out.println("POP " + stackArray[topOfStack] + " was Removed");
            stackArray[topOfStack] = "-1";
            return stackArray[topOfStack --];
        }else{
            displayStack();
            System.out.println("failed because stack is empty");
            return "-1";
        }

    }
    // show the top element of the stack

    public String peek(){
        displayStack();
        System.out.println("Peek " + stackArray[topOfStack] + " is at the top of the stack");
        return stackArray[topOfStack];
    }
    //pop out all the element of the stack
    public void popAll(){
        for ( int i = topOfStack; i >=0; i--){
            pop();
        }
    }
    // add mutilple element into the stack
    public void pushMany(String mutipleValues){
        String[] temString = mutipleValues.split(" ");
        for ( int i = 0 ; i < temString.length; i++){
            push(temString[i]);
        }
    }

    //operations
    public static void main(String[] args){
        stack stack1 = new stack(10);
        stack1.push("1");
        stack1.push("1123");
        stack1.pop();
        stack1.pushMany("244 1421 123123 123");
        stack1.peek();
        stack1.displayStack();
        stack1.popAll();
        stack1.displayStack();
    }
}








