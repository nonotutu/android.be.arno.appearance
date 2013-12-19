package be.arno.appearance;

public class Item {
	 
    private String name;
    private String prop;
    
    public Item(String name, String prop) {
    	this.name = name;
    	this.prop = prop;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    public String getProp() {
        return prop;
    }
 
    public void setProp(String prop) {
        this.prop = prop;
    }
 
    @Override
    public String toString() {
        return name;
    }
}