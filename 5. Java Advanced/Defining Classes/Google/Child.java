package Google;

public class Child {
    private String childrenName;
    private String childrenBirthday;

    public Child(String childrenName, String childrenBirthday) {
        this.childrenName = childrenName;
        this.childrenBirthday = childrenBirthday;
    }

    @Override
    public String toString(){
        return childrenName + " " + childrenBirthday;
    }
}
