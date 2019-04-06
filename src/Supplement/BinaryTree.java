package Supplement;

public class BinaryTree {

    Node root;

    public void addNode ( int key, String name){
        Node newNode = new Node(key,name);

        if (root == null){
            root = newNode;
        }else{
            Node focusNode = root;

            Node parent;

            while(true){
                parent = focusNode;
                if(key< focusNode.key){
                    focusNode = focusNode.left;
                    if(focusNode == null){
                        parent.left = newNode;

                        return;
                    }
                }else{
                    focusNode = focusNode.right;

                    if(focusNode == null){
                        parent.right=newNode;
                        return ;
                    }
                }
            }
        }
    }

    /**
     * In Order Traversal
     * @param focusNode
     *
     *                               root
     *                            /       \
     *                           /         \
     *                          /  ∆ -->    \
     *                         /   |   |     \
     *                        /    |   |      \
     *                       /     |   |       \
     *                      /      |   |        \
     *                     /       |   |         \
     *                    /        |   |          \
     *                   /         |   |           \
     *                  /          |   |            \
     *              left           |   |           right
     *           /        \        |   |       /    ∆->   \
     *          /   ∆-> |  \       |   |      /     |  |   \
     *     L.left   |   | L.right  |   |    R.left  |  |  R.right
     *     --------->   V---------->   V   ------>     V --------->
     *
     *
     *
     */

    public void inOrderTraverseTree(Node focusNode){ // small value first  to biggest value
        if(focusNode != null){
            inOrderTraverseTree(focusNode.left);

            System.out.println(focusNode);

            inOrderTraverseTree(focusNode.right);
        }
    }



    public void preOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.left);
            inOrderTraverseTree(focusNode.right);
        }
    }


    /**
     *  Post Order Traversal
     * @param focusNode
     *
     *                          root
     *    |                  /       \
     *    |                 /   ∆-->  \
     *    |                /    |  |   \
     *    |               /     |  |    \
     *    |              /      |  |     \
     *    |             /       |  |      \
     *    |            /        |  |       \
     *    |           /         |  |        \
     *    |          /          |  |         \
     *    |        left         |  |         right
     *    |      /     \        |  |      /        \
     *    |  L.left    L.right  |  |    R.left     R.right
     *    V---------> ------->     V --------> ----------->
     *
     *     order:
     *
     */
    public void postOrderTraverseTree(Node focusNode){ // small value first  to biggest value
        if(focusNode != null){

            inOrderTraverseTree(focusNode.left);
            inOrderTraverseTree(focusNode.right);
            System.out.println(focusNode);
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;
        while(focusNode.key != key){
            if(key < focusNode.key){
                focusNode = focusNode.left;
            }else{
                focusNode = focusNode.right;
            }

            if (focusNode == null)
                return null;
        }
        return focusNode;
    }

    public boolean remove(int key){
        Node focusNode = root;
        Node parent = root;

        boolean isItaLeft = true;
        while (focusNode.key != key) {
            parent = focusNode;
            if (key < focusNode.key){
                isItaLeft = true;
                focusNode = focusNode.left;
            }else{
                isItaLeft = false;
                focusNode = focusNode.right;
            }

            if(focusNode == null) {
                return false;
            }
        }

        if(focusNode.left ==null && focusNode.right == null){
            if(focusNode == root ){
                root = null;
            }else if(isItaLeft){
                parent.left =null ;
            }else{
                parent.right = null;
            }
        }

        else if (focusNode.right == null){
            if(focusNode == root ){
                root = focusNode.left;
            }else if(isItaLeft){
                parent.left = focusNode.left;
            }else {
                parent.right = focusNode.left;
            }
        }


        else if (focusNode .left == null){
            if(focusNode == root ){
                    root = focusNode.right  ;
            }else if(isItaLeft){
                parent.left = focusNode.right;
            }else {
                parent.right = focusNode.right;
            }
        }

        else {
            Node replacement = getReplacement(focusNode);
            if(focusNode == root) {
                root = replacement;
            }else if ( isItaLeft) {
                 parent.left = replacement;
            }else{
                parent.right = replacement;
            }
            replacement.left = focusNode.left  ;
        }

        return true;
    }


    public static void main(String args[]){

        BinaryTree Tree = new BinaryTree();

        Tree.addNode(123, "amada");
        Tree.addNode(33, "bmada");
        Tree.addNode(23, "cmada");
        Tree.addNode(321, "dmada");
        Tree.addNode(4321, "fmada");

        Tree.preOrderTraverseTree(Tree.root);
        System.out.println(Tree.findNode(33));

        Tree.remove(33);
        System.out.println(Tree.findNode(33));



    }

    public Node getReplacement(Node repNode){
        Node repParent = repNode;
        Node replacement = repNode;

        Node focusNode = repNode.right;
        while (focusNode != null) {
            repParent =replacement;
            replacement = focusNode;
            focusNode = focusNode.left;
        }
        if(replacement != repNode .right){
            repParent.left = replacement.left;
            replacement.right = repNode.right;
        }

        return replacement;
    }

}


class Node{
    int key;
    String name;

    Node left;
    Node right;

    Node(int key, String name){
        this.key = key;

        this.name = name;
    }

    public String toString(){
        return name + " has a key " + key;

    }
}

