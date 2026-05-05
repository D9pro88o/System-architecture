// 1. The Prototype Interface
interface Monster {
    Monster clone(); // Our cloning method
    void scream();
}

// 2. A Concrete Prototype
class Ghost implements Monster {
    private String type;
    private int health;

    public Ghost(String type, int health) {
        this.type = type;
        this.health = health;
    }

    // Copy Constructor (Alternative way to clone)
    public Ghost(Ghost target) {
        if (target != null) {
            this.type = target.type;
            this.health = target.health;
        }
    }

    @Override
    public Monster clone() {
        // We use the copy constructor to create a new instance
        return new Ghost(this);
    }

    @Override
    public void scream() {
        System.out.println("I am a " + type + " with " + health + " HP! *Boo!*");
    }
}

// 3. Usage
public class Main {
    public static void main(String[] args) {
        // Create an "Original" object
        Ghost prototypeGhost = new Ghost("Shadow Ghost", 100);

        // Clone it
        Monster ghost1 = prototypeGhost.clone();
        Monster ghost2 = prototypeGhost.clone();

        ghost1.scream();
        ghost2.scream();
    }
}
