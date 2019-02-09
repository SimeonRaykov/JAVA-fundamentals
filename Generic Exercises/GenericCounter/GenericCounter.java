package GenericCounter;

public class GenericCounter <T extends Comparable> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public GenericCounter(T t) {
        this.t = t;
    }


}
