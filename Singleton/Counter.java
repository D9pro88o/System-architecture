public class Counter {
    private static Counter instance;
    private int count = 0;

    // 1. Private Constructor: Prevents direct instantiation
    private Counter() {}

    // 2. Static getInstance method
    public static Counter getInstance() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        // Get the singleton instance
        Counter c1 = Counter.getInstance();
        Counter c2 = Counter.getInstance();

        // Check if they are the same instance
        if (c1 == c2) {
            System.out.println("Same instance: true");
        }

        // Increment through c1
        for (int i = 0; i < 5; i++) {
            c1.increment();
        }

        // Check count via c2
        System.out.println("Count after 5 increments: " + c2.getCount());
    }
}