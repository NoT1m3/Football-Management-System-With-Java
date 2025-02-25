package jumperforgoalposts;

import java.io.Serializable;

public class Manager implements Serializable {
    private String name;
    private boolean isActive;

    public Manager(String name) {
        this.name = name;
        this.isActive = true;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
