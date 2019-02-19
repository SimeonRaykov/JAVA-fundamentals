package repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private Map<Integer, Person> data;
    private static int id;

    public Repository() {
        this.data = new HashMap<Integer, Person>();
        id = 0;
    }

    public void add(Person person) {
        this.data.put(id, person);
        id+=1;
    }

    public Person get(int id) {
        for (Integer integer : data.keySet()) {
            if (integer == id) {
                return this.data.get(integer);
            }
        }
        return null;
    }

    public boolean update(int id, Person newPerson) {
        if (this.data.get(id) == null) {
            return false;
        }
        this.data.put(id, newPerson);
        return true;

    }

    public boolean delete(int id) {
        if (this.data.get(id) == null) {
            return false;
        }
        this.data.remove(id);
        return true;
    }

    public int getCount() {
        return this.data.size();
    }


}
