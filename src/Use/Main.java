package Use;

import DATA.*;
import Sort.*;

import java.net.PortUnreachableException;
import java.util.Arrays;
import java.util.Scanner;

/************************************------------@copyright for @m_it_01-----------------***********************************/
//@m_it_01

public class Main {
    public static void main(String[] orgs){
//  int[] arr={90,3,57,89,3,1};
//  Sort sort_obj=new Sort();
//  System.out.println(Arrays.toString(arr));
//
//         sort_obj.quickSort_me(arr,0,arr.length-1, Direction.LOW_HIGH);
//        //sort_obj.sort(arr,Direction.LOW_HIGH);
//        System.out.println(Arrays.toString(arr));

      //  Linked_Tree<Integer> linked_tree=new Linked_Tree<>(30);
//        linked_tree.Rest();
//
        //linked_tree.appendFirst(linked_tree.creatNode(10));
//        linked_tree.appendLast(linked_tree.creatNode(10));
//        linked_tree.appendLast(linked_tree.creatNode(20));
//        linked_tree.appendLast(linked_tree.creatNode(40));
//        linked_tree.appendLast(linked_tree.creatNode(50));
        //linked_tree.Rest();

       //System.out.println("Size is : "+linked_tree.getSize());
        //linked_tree.insert_p(linked_tree.creatNode(9),5);
       // linked_tree.DeleteLast();

        //System.out.println("Size is by counter : "+linked_tree.CommputeSize());
        //linked_tree.appendLast(linked_tree.creatNode(440));
        //linked_tree.RefreshSize();
       // linked_tree.appendLast(linked_tree.creatNode(90));

//        Linked_Tree_Node<Integer> myNode=new Linked_Tree_Node<>(999,null);
//        myNode.left=linked_tree.getItem(linked_tree.getSize()-4);
//        linked_tree.appendFirst(myNode);
        //linked_tree.head=linked_tree.mergeSort(linked_tree.getHead());


        //linked_tree.printAllNodes();
        //System.out.println("-----------");

//        linked_tree.head=linked_tree.mergeSort(linked_tree.head,Direction.HIGH_LOW);
//        linked_tree.printAllNodes();
//        System.out.println("-----------");
  //linked_tree.printAllNodes();

       // Linked_Tree_Node<Integer> myNodetest=linked_tree.Get_One_tree(linked_tree,Direction.NOTSORTED);


        //System.out.println(myNodetest.left.left.left.next.value);

        //BTreePrinter.printNode(myNodetest);

        //linked_tree.Get_One_tree(linked_tree);
//      System.out.println("----------- after use algoth");
//        linked_tree.printAllNodes();


        //Linked_Tree_Node<Integer> testtree=linked_tree.Get_One_tree(linked_tree,Direction.NOTSORTED,Direction.LOW_HIGH);

        //BTreePrinter.printNode(testtree);



        // test thes nodes (5) 20,67,9,90,33
        //Start Linked tree nodes
        //to creat our Linked tree nodes
        Linked_Tree<Integer> mylinkedtree=intialLinkedTree();
        //to print our nodes
        mylinkedtree.printAllNodes();
        //to create  a root of our single tree
        Linked_Tree_Node<Integer> singletree=mylinkedtree.Get_One_tree(mylinkedtree,Direction.NOTSORTED,Direction.LOW_HIGH);
        System.out.println("Your Tree is :");
         BTreePrinter.printNode(singletree);
        //end of Linked tree nodes

        System.out.println("Knapsack Starting ......");



        //start Knapsack algo
        //you can use full_knap_test() to fill withot
        Knapsack knapsack=new Knapsack();
        //to sort items in knapsack items array
        Sort_Items sort_items=new Sort_Items();

        Item[] items= knapsack.full_knap_test();
        //Item[] items= knapsack.Create_Items();
        knapsack.printAllItems();
        startKnapsack(items,sort_items,knapsack);
        //end of knapsack algo

//    System.out.println("ss");

    }
//@m_it_01

    /************************************------------@copyright for @m_it_01-----------------***********************************/

    public static void startKnapsack(Item[] items,Sort_Items sort_items,Knapsack knapsack){

        boolean isstop=false;
        Scanner input=new Scanner(System.in);
        while(!isstop){
            String options="Chose an option"+"\n1.maxmize provit "+"\n2.minmize weight "+"\n3.maxmize p/w"+"\n4.Try anouther Items"
                    +"\n5.rechose test items"+"\nTo stop (-1)";
            System.out.println(options);
            int op=input.nextInt();
            if(op>0&&op<4) {
                if (op == 1) {
                    sort_items.sort_provit(items, Direction.HIGH_LOW);
                } else if (op == 2) {
                    sort_items.sort_weight(items, Direction.LOW_HIGH);
                } else if (op == 3) {
                    sort_items.sort_provit_to_w(items, Direction.HIGH_LOW);
                }
                System.out.println("------------");
                Double[] result=knapsack.Knapsackalgo(items,25.0);
                System.out.println(Arrays.toString(result));
//@m_it_01
            }
            else if(op==-1){
                isstop=true;
                System.out.println("Thank You For Using our system");
            }
            else if(op==4){
                items=knapsack.Create_Items();
            }
            else if(op==5){
                items=knapsack.full_knap_test();
                //@m_it_01
            }
            else{
                System.out.println("Please use one of option above ");
            }

        }
    }
    /************************************------------@copyright for @m_it_01-----------------***********************************/
//@m_it_01

    public static Linked_Tree<Integer> intialLinkedTree(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Number Of elemnt is Linked Tree :");
        int ElemntNumber=input.nextInt();
        Linked_Tree<Integer> linked_tree=new Linked_Tree<>();
        if(ElemntNumber>0){
        System.out.print("Enter Value :");
        int Value;
        for (int i=0;i<ElemntNumber;i++){
            System.out.print("Enter Value :");
             Value=input.nextInt();
             linked_tree.appendLast(linked_tree.creatNode(Value));
        }
        }
        //@m_it_01
        return linked_tree;
    }
}
/************************************------------@copyright for @m_it_01-----------------***********************************/
//@m_it_01
