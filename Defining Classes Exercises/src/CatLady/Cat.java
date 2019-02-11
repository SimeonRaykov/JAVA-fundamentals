package CatLady;

import java.text.DecimalFormat;

public class Cat {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DecimalFormat getFormat(){
        DecimalFormat df = new DecimalFormat("#.00");
        return df;
    }

}
