/**
 * Created by tomgr on 29.07.2016.
 */
public class Components extends Part{

    String id;
    String name;

    public Components(){

    }

    public Components(String id, String name) throws IllegalArgumentException{

        if (id == "" || name == ""){
            throw new IllegalArgumentException("ID or Name cannot be empty!");
        }

        this.id = id;
        this.name = name;
    }
}
