package GenericSwap;

public class BoxSwap<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public BoxSwap(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return t.getClass().getName()+": "+getT().toString();
    }
}
