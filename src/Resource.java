/**
 * Created by tomgr on 29.07.2016.
 */
public class Resource extends Part{

    String id;
    String name;

    public Resource(){

    }

    public Resource(String id, String name) throws IllegalArgumentException{

        if (id == "" || name == ""){
            throw new IllegalArgumentException("ID or Name cannot be empty!");
        }

        this.id = id;
        this.name = name;
    }
}
