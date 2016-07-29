import java.util.IllegalFormatCodePointException;

/**
 * Created by tomgr on 29.07.2016.
 */
public class ReceivingStock extends Stock{

    int minStockItems;
    int maxStockItems;

    public ReceivingStock(){

    }

    public ReceivingStock(int minStockItems, int maxStockItems) throws IllegalArgumentException{

        if (minStockItems < 1 || maxStockItems < 1){
            throw new IllegalArgumentException("min or max StockItems has to be bigger than 0!");
        }

        this.minStockItems = minStockItems;
        this.maxStockItems = maxStockItems;
    }

    public void insert(Part part, int count) throws NullPointerException, IllegalArgumentException{

        if (part == null){
            throw  new NullPointerException("Part cannot be NULL!");
        }

        if (count < 1){
            throw new IllegalArgumentException("Count has to be bigger than 0!");
        }

        if (this.parts.containsKey(part)){

            int actualCount = this.parts.get(part);
            actualCount = actualCount + count;
            this.parts.put(part, actualCount);

            if (actualCount < this.minStockItems || actualCount > this.maxStockItems){

                this.notify(part);
            }
        }
        else {

            this.parts.put(part, count);

            if (count < this.minStockItems || count > this.maxStockItems){

                this.notify(part);
            }
        }
    }

    public boolean delete(Part part, int count) throws NullPointerException, IllegalArgumentException{

        if (part == null){
            throw  new NullPointerException("Part cannot be NULL!");
        }

        if (count < 1){
            throw new IllegalArgumentException("Count has to be bigger than 0!");
        }

        if (!this.parts.containsKey(part) || this.parts.get(part) - count < 0){

            return false;
        }
        else {

            int actualCount = this.parts.get(part);
            actualCount = actualCount - count;
            this.parts.put(part, actualCount);

            if (actualCount < this.minStockItems || actualCount > this.maxStockItems){

                this.notify(part);
            }

            return true;
        }
    }

    public void notify(Part part){

        for (Observation observer:
             this.observers) {

            observer.alarm(part);
        }

        }
    }
