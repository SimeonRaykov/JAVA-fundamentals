package AshesOfRoses;

import AshesOfRoses.Rose;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Region {

    private String name;
    private List<Rose> roses;

    public Region(String name) {
        if (Character.isUpperCase(name.charAt(0))) {
            boolean isInvalid = false;
            for (int i = 1; i < name.length(); i++) {
                if (!Character.isLowerCase(name.charAt(i))) {
                    isInvalid = true;
                }
            }
            if (!isInvalid) {
                this.name = name;
                this.roses = new ArrayList<>();
            } else {
                throw new IllegalArgumentException("Name of region is incorrect");
            }
        } else {
            throw new IllegalArgumentException("Name of region is incorrect");
        }
    }

    public int getRosesCount() {
        int count = 0;
        for (Rose rose : roses) {
            count += rose.getCount();
        }
        return count;
    }

    public void addRose(Rose rose) {
        if (!this.containsRose(rose.getName())) {
            this.roses.add(rose);
        }
    }

    public Rose getRose(String rose) {
        for (Rose rose1 : roses) {
            if (rose1.getName().equals(rose)) {
                return rose1;
            }
        }
        return null;
    }

    public boolean containsRose(String rose) {
        for (Rose rose1 : roses) {
            if (rose1.getName().equals(rose)) {
                return true;
            }
        }
        return false;
    }


    public String getName() {
        return name;
    }

    public List<Rose> getRoses() {
        return Collections.unmodifiableList(roses);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName());

        return sb.toString();
    }
}
