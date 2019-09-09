

public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;
    private static int size = 0;

    /*
    This function allows to insert a node at a specific index and shifts the list to the left so that head node points to the correct node
 */
    public void insertAt(int index, int data){

        if( index >= size ){
             getNode(index);
             System.out.println("Out of bounds. Cannot insert at position " + index);
        }
        // If index is last element
        else if( size - index == 0 ){
            insertAtBack(data);
        }
        // If index is 0, place node in front
        else if ( size - index == size ){
            insertAtFront(data);
        }
        // If anywhere in bounds
        else{
            Node n = new Node(data);
            Node temp = getNode(index - 1);
            n.next = temp.next;
            temp.next = n;
            size++;
            shiftListToLeft();

        }
    }
    /*
    This function allows to insert a nde at the very front
 */
    public void insertAtFront(int d){

        if( isEmpty() ){
            insertAtBack(d);
        }
        else{

            Node newNode = new Node(d);
            newNode.next = head;
            head = newNode;
            tail.next = head;
            size++;
        }
    }
    /*
        This function finds the node and checks if it gives and out of bounds exception.
        if not then, it goes and checks for the position throughout the list
     */
    public Node getNode(int index){

            if (index >= size) {
                //int newIndex = index-size;
                while(index >= size){
                    index = index-size;
                }

            }

        Node temp = head.next;
        while( index - 1 != 0 ){
            temp = temp.next;
            index--;
        }
        return temp;
    }
    /*
        This function shifts the head node to the last element of the list
     */
    public Node shiftListToLeft(){

        if( !isEmpty() ) {
            //go thought the list to get last element
            Node temporary = head;
            while (temporary.next != tail) {
                temporary = temporary.next;
            }
            tail = temporary;
            //set head to the whatever tail is pointing to
            head = tail.next;
            return head;
        }
        else{
            System.out.println("Nothing to shift.");
            return null;
        }
    }
    /*
    This function prints the list
 */
    public void printList(){
        // Print the entire list
        if( isEmpty() ){
            System.out.println("There's nothing to print");
        }
        else{
            Node temp = head;
            for( int i = 0; i < size; i++ ){
                System.out.print( temp.data + " " );
                temp = temp.next;
            }
        }
    }


    /*
    This function returns true if the list is empty
    */

    public boolean isEmpty(){

        return size == 0;
    }

    /*
        This function returns the size of the element
     */
    public int getSize(){
        return size;
    }

    /*
        This function inserts a node at the back
     */
    public void insertAtBack(int d){
        Node newNode = new Node(d);

        if ( isEmpty() ){
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }

        else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        size++;
    }
    /*
    This is the main function used to call all the other functions
 */
    public static void main(String[] args){

        CircularLinkedList a = new CircularLinkedList();

        a.insertAtBack(2);
        a.insertAtBack(3);
        a.insertAtBack(4);
        a.printList();

        System.out.println();
        a.insertAtFront(5);
        a.printList();
        System.out.println();
        System.out.println("Size: " + a.getSize());

        System.out.println("Index 5: " + a.getNode(5).data);

        a.insertAt(7, 6);
        a.printList();


    }

}
