package DATA;

import java.util.Scanner;
/************************************------------@copyright for @m_it_01-----------------***********************************/

public class Knapsack {
    private Scanner input;
    public Item[] items;
    public int Size;

    public Knapsack(){
        input=new Scanner(System.in);
    }
    /************************************------------@copyright for @m_it_01-----------------***********************************/

    public  Item[] Create_Items(){
        System.out.print("Enter Number Of Items :");
        Size=input.nextInt();
        this.items=new Item[Size];
        if(Size>0) {
            for (int i = 0; i < Size; i++) {

                System.out.print("Enter Id :");
                int id = input.nextInt();

                System.out.print("Enter Weight :");
                Double weight = input.nextDouble();

                System.out.print("Enter Provit :");
                Double prov = input.nextDouble();

                Item item = new Item(id, weight, prov);
                Double provit_to_weith = prov / weight;
                item.provit_to_weigh = provit_to_weith;

                items[i] = item;

                System.out.println();

            }
        }
        return items;
    }
    public void printAllItems(){
        for(Item item:items){
            System.out.println(item.toString());
            System.out.println();
        }
    }
    /************************************------------@copyright for @m_it_01-----------------***********************************/

    public Item[] full_knap_test(){
        Size=3;
        int num=1;
        this.items=new Item[Size];
        items[0]=new Item(1,18,25);
        items[1]=new Item(2,15,24);
        items[2]=new Item(3,10,15);
        return items;

    }

    public Double[] Knapsackalgo(Item[] items,Double Capacty) {
        Double[] result = new Double[items.length + 1];
        for (int j = 0; j < result.length; j++) {
            result[j] = 0.0;
        }
        Double maxProvit = 0.0;
        if (items.length>1){
            int i = 0;
        for (i = 0; i < result.length; i++) {
            if (items[i].weight > Capacty) {
                break;
            } else {
                result[i] = 1.0;
                Capacty -= items[i].weight;
                maxProvit += items[i].provit;
            }
        }
        if (i < result.length) {
            result[i] = Capacty / items[i].weight;
            maxProvit += items[i].provit * result[i];
        }
    }
        result[result.length-1]=maxProvit;

        return result;
    }
    /************************************------------@copyright for @m_it_01-----------------***********************************/


}
