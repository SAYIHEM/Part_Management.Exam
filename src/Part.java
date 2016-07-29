/**
 * Created by tomgr on 29.07.2016.
 */
public abstract class Part {

    String id;
    String name;

    public Part(){

    }

    public Part(String id, String name) throws IllegalArgumentException{

        if (id == "" || name == ""){
            throw new IllegalArgumentException("ID or Name cannot be empty!");
        }

        this.id = id;
        this.name = name;
    }

    public String getId(){

        return this.id;
    }

    public String getName(){

        return this.name;
    }
}
