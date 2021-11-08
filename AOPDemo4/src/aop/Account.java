package aop;

public class Account {
    
    private String name;
    private String level;

    public Account(){}

    public Account(String name, String level){
        super();
        this.name = name;
        this.level = level;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString(){
        return "Account [name="+name+", level="+level+"]";
    }    

}