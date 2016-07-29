/**
 * Created by tomgr on 29.07.2016.
 */
public class Purchasing implements Observation{

    ReceivingStock receivingStock;

    public Purchasing(){

    }

    public Purchasing(ReceivingStock receivingStock) throws NullPointerException{

        if (receivingStock == null){
            throw new NullPointerException("ReceivingStock cannot be NULL!");
        }

        this.receivingStock = receivingStock;
    }

    public void buy(Part part, int count) throws NullPointerException, IllegalArgumentException{

        if (part == null){
            throw new NullPointerException("Part cannot be NULL!");
        }

        if (count < 1){
            throw new IllegalArgumentException("count has to be bigger than 0!");
        }

        // .....
    }

    public ReceivingStock getStock(){

        return this.receivingStock;
    }

    @Override
    public void alarm(Part part) {

    }
}
