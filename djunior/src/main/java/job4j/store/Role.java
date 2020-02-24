package job4j.store;

public class Role extends Base {

    private String name;

    protected Role(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Role: "+this.name+"; "+"id - "+this.getId();
    }
}
