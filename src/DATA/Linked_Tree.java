package DATA;

import Sort.*;

import java.util.Iterator;
/************************************------------@copyright for @m_it_01-----------------***********************************/

public class Linked_Tree<T> {

    private  int size=0;
    public Linked_Tree_Node<T> head;
    //@m_it_01
    public Linked_Tree(){

    }
    public Linked_Tree (T head_value){
        this.size++;
        this.head=new Linked_Tree_Node<T>(head_value,null);
    }
    //inti head if its empty  its too dangrouse method it will rest your list
    private Linked_Tree_Node<T> NewHead(Linked_Tree_Node<T> NewHead){
        this.head=NewHead;
        this.size=1;
        return head;
    }
    //@m_it_01
    //rest your Linked Tree and Delete all items Head Also
    public void Rest(){
        this.head=null;
        this.size=0;
    }

    public Linked_Tree_Node<T> getHead() {
        return head;
    }

    public int getSize() {
        return this.size;
    }

    //@m_it_01
    public Linked_Tree_Node<T> creatNode(T value){
        Linked_Tree_Node<T> Node = new Linked_Tree_Node<T>(value, null);
            return Node;
    }
    //to append node to end
    public Linked_Tree_Node<T> appendLast(Linked_Tree_Node<T> NewNode){
        if(head==null){
            NewHead(NewNode);
        }
        else {
            Linked_Tree_Node<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = NewNode;
            this.size++;
        }
        return NewNode;
    }

    //to append elemnt to start
//@m_it_01
    public Linked_Tree_Node<T> appendFirst(Linked_Tree_Node<T> NewNode){
        if(head==null){
         NewHead(NewNode);
        }
        else{
            NewNode.next=getHead();
            head=NewNode;
            this.size++;
        }
        return NewNode;
    }

    //insert in specific playce
public void insert_p(Linked_Tree_Node<T> NewNode,int Index) {
    if (Index<=size&&Index>=0){
        if (Index == 0) {
            appendFirst(NewNode);
        } else if (Index==size) {
            appendLast(NewNode);
        } else {
            //set loop to set elemnt
            Linked_Tree_Node node=head;
            if(head==null){
               appendLast(NewNode) ;
            }
            else{
                int i=0;
                while (i<Index-1) {
                    node=node.next;
                    i++;
                }

                Linked_Tree_Node temp=node.next;
                node.next=NewNode;
                NewNode.next=temp;
                size++;
            }
        }
}
}
    //@m_it_01
//to delete first elemnt
    public void DeleteFirst(){
        if(head!=null){
            head=head.next;
            size--;
        }
    }
    //@m_it_01
    //to delete last elemnt
    public void DeleteLast(){
        if(head!=null){
            if(head.next==null){DeleteFirst();}
            else{
                Linked_Tree_Node node=head;
                while (node.next.next!=null){
                    node=node.next;
                }
                node.next=null;
                size--;
            }
        }
    }
    /************************************------------@copyright for @m_it_01-----------------***********************************/
//@m_it_01
    //to recompute size of any linked tree
    public int CommputeSize(Linked_Tree<T> linked_tree){
        Linked_Tree_Node<T> node=linked_tree.getHead();
        int count=0;
        while (node!=null){
            node=node.next;
            count++;
        }
        return count;
    }

    //to recompute size of linked tree object
    public int CommputeSize(){
        Linked_Tree_Node<T> node=head;
        int count=0;
        while (node!=null){
            node=node.next;
            count++;
        }
        return count;
    }
    //to refresh Size of linked trre object
    public void RefreshSize(){
            this.size=CommputeSize();
    }
    //@m_it_01
    //to refresh Size of any linked tree
    public void RefreshSize(Linked_Tree<T> linked_tree){
        linked_tree.size=CommputeSize(linked_tree);
    }
    /************************************------------@copyright for @m_it_01-----------------***********************************/
//@m_it_01

//to sort all elemnts only when initi
public void Sort_Type_Integer(Direction direction) throws Exception{
        if (head!=null){
            RefreshSize();
            Linked_Tree_Node<Integer> node= (Linked_Tree_Node<Integer>) head;
            int[] arr=new int[getSize()];
            int i=0;
            while (node!=null){
                arr[i]=(int)node.value;
                node=node.next;
                i++;
            }
            //now i have an int array i can sort itt by algo
            Sort sort_obj=new Sort();
            sort_obj.sort(arr,direction);
            node= (Linked_Tree_Node<Integer>) head;
             i=0;
            while (node!=null){
                node.value=arr[i];
                node=node.next;
                i++;
            }

        }

}
//@m_it_01

//get specefic item by index
    public Linked_Tree_Node<T> getItem(int Index) throws NullPointerException{
        if(Index<size&&Index>-1){
            Linked_Tree_Node<T> node=head;
            int i=0;
            while (i<Index){
                node=node.next;
                i++;
            }
            return node;

        }
        return null;
    }

    public void printAllNodes(){
        Linked_Tree_Node<T> node=head;
        if (node==null){
            System.out.println("Your Linked Tree is Empty Try To Add Some Items");
        }
        else {
            System.out.print("Your List Nodes Is : ");
            System.out.print("[");
            while (node != null) {
                System.out.print(node.value+",");
                node = node.next;
            }
            System.out.println("]");

        }
    }


    //Mereg sorte implemnt for linked list
    public Linked_Tree_Node<Integer> sortedMerge(Linked_Tree_Node<Integer>  a, Linked_Tree_Node<Integer> b,Direction direction) {
        Linked_Tree_Node<Integer>  result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;
        if(direction==Direction.LOW_HIGH){
            /* Pick either a or b, and recur */
            if (a.value <= b.value) {
                result = a;
                result.next = sortedMerge(a.next, b,direction);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next,direction);
            }
        }
        else{
            /* Pick either a or b, and recur */
            if (a.value >= b.value) {
                result = a;
                result.next = sortedMerge(a.next, b,direction);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next,direction);
            }
        }
        return result;
    }
    /************************************------------@copyright for @m_it_01-----------------***********************************/
//@m_it_01
    public Linked_Tree_Node<Integer> mergeSort(Linked_Tree_Node<Integer> h,Direction direction) {
    // Base case : if head is null
    if (h == null || h.next == null) {
        return h;
    }
    // get the middle of the list
        Linked_Tree_Node<Integer> middle = getMiddle(h);
        Linked_Tree_Node<Integer> nextofmiddle = middle.next;

    // set the next of middle node to null
    middle.next = null;

    // Apply mergeSort on left list
        Linked_Tree_Node<Integer> left = mergeSort(h,direction);

    // Apply mergeSort on right list
        Linked_Tree_Node<Integer> right = mergeSort(nextofmiddle,direction);

    // Merge the left and right lists
        Linked_Tree_Node<Integer> sortedlist = sortedMerge(left, right,direction);
    return sortedlist;
}
    //@m_it_01
    // Utility function to get the middle of the linked list
    public  Linked_Tree_Node<Integer> getMiddle(Linked_Tree_Node<Integer> head) {
        if (head == null)
            return head;

        Linked_Tree_Node<Integer> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //inser sortd
    /************************************------------@copyright for @m_it_01-----------------***********************************/

    public void inser_with_Sort(Linked_Tree_Node<Integer> NewNode){
        Linked_Tree_Node node=head;
        while(node.next!=null&&(int)node.value<NewNode.value){
            node=node.next;
        }
        Linked_Tree_Node temp=node.next;
        node.next=NewNode;
        NewNode.next=temp;

    }


    //@m_it_01
//out algorthem
    public Linked_Tree_Node<Integer> Get_One_tree(Linked_Tree<Integer> linked_tree,Direction isSorted,Direction direction) {
        if(isSorted!=Direction.SORTED){
        linked_tree.head = mergeSort(linked_tree.head,direction);
    }
        while(linked_tree.size>1){
            Linked_Tree_Node leftnode=linked_tree.getHead();
            Linked_Tree_Node rightnode=linked_tree.getHead().next;

            //int leftvalue=(int)leftnode.value;
            //int rightvalue=(int)rightnode.value;

            Linked_Tree_Node result=linked_tree.creatNode(((int)leftnode.value)+((int)rightnode.value));

            result.left=leftnode;
            result.right=rightnode;
            //leftnode.next=null;
            //rightnode.next=null;
            DeleteFirst();
            DeleteFirst();

            linked_tree.inser_with_Sort(result);
            // bismallah al rahman al raheem
          //resort our listed tree
            linked_tree.head=mergeSort(linked_tree.head,direction);
            // we have sorted it
            //must use had not have

        }

        return linked_tree.head;
//@m_it_01
    }

/************************************------------@copyright for @m_it_01-----------------***********************************/

}
