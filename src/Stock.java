import java.util.Map;
import java.util.TreeMap;

/**
 * Created by tomgr on 29.07.2016.
 */
public abstract class Stock {

    Map<Part, Integer> parts = new TreeMap<Part, Integer>();
    Observation observers;

    public Stock(){

    }

    public int get(Part part){

        if (!this.parts.containsKey(part)){

            return -1;
        }
        else {

            return this.parts.get(part);
        }
    }

    public boolean set(Part part, int count){

        if (count < 0 || !this.parts.containsKey(part)){

            return false;
        }
        else {

            this.parts.put(part, count);
            return true;
        }
    }

    public void insert(Part part, int count) throws NullPointerException, IllegalArgumentException{

        if (part == null){
            throw  new NullPointerException("Part cannot be NULL!");
        }

        if (count < 1){
            throw new IllegalArgumentException("Count has to be bigger than 0!");
        }

        if (this.parts.containsKey(part)){

            int actualcount = this.parts.get(part);
            actualcount = actualcount + count;
            this.parts.put(part, actualcount);
        }
        else {

            this.parts.put(part, count);
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
            return true;
        }
    }

    public void register(Observation observer) throws NullPointerException{

        if (observer == null){
            throw new NullPointerException("Observer cannot be NULL!");
        }

    }

    public void notify(Part part) throws NullPointerException{

        if (part == null){
            throw new NullPointerException("Part cannot be NULL!");
        }

    }
}
