/**
 * Created by tomgr on 29.07.2016.
 */
public class Factory {

    Purchasing purchasing;
    ReceivingStock receivingStock;

    public Factory(){

    }

    public Factory(Purchasing purchasing, ReceivingStock receivingStock) throws NullPointerException{

        if (purchasing == null || receivingStock == null){
            throw new NullPointerException("Purchasing or receivingStock cannot be NULL!");
        }

        this.purchasing = purchasing;
        this.receivingStock = receivingStock;
    }

    public Purchasing getPurchasing(){

        return this.purchasing;
    }

    public ReceivingStock getStock(){

        return this.receivingStock;
    }

    public void create(PartType partType, String id, String name) throws NullPointerException, IllegalArgumentException{

        if (partType == null){
            throw new NullPointerException("Parttype cannot be NULL!");
        }

        if (id == "" || name == ""){
            throw new IllegalArgumentException("ID or Name cannot be empty!");
        }

        if (partType == PartType.COMPONENTS){

            this.receivingStock.insert(new Components(id, name), 1);
        }
        else if (partType == PartType.RESOURCE){

            this.receivingStock.insert(new Resource(id, name), 1);
        }
        else if (partType == PartType.SINGLE_COMPONENT){

            this.receivingStock.insert(new SingleComponent(id, name), 1);
        }
    }
}
