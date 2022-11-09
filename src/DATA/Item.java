package DATA;
/************************************------------@copyright for @m_it_01-----------------***********************************/
//@m_it_01
public class Item {
    private int ID;
    public double weight;
    public double provit;
    public double provit_to_weigh;
//@m_it_01

    public Item(int ID, double weight, double provit) {
        this.ID = ID;
        this.weight = weight;
        this.provit = provit;
        this.provit_to_weigh=provit/weight;
    }
//@m_it_01

    @Override
    public String toString() {
        return "ID :"+ID+"\nWeight :"+weight+"\nProvit :"
                +provit+"\nprovit_to_weigh :"+ provit_to_weigh+"";
    }
    /************************************------------@copyright for @m_it_01-----------------***********************************/

}
