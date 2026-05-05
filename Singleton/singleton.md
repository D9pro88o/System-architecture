# Singleton Design Pattern — Counter.java

---

## Program Description & Structure

This program is a straightforward Java implementation built around one idea: demonstrating how the Singleton pattern works in practice. The whole thing lives in a single file, `Counter.java`, which keeps it simple and easy to follow without any extra noise getting in the way.

The class has its own `main` method so it can be run and tested on its own. The goal was never to build something complex — just enough to show the pattern clearly, nothing more.

---

## The Singleton Pattern — What It Is and Where It's Applied

The Singleton pattern is really about one thing: control. It makes sure that no matter how many times you try to get an instance of a class, you always get back the exact same object. Not a copy, not a new one — the same one.

In `Counter.java`, this is achieved through three things working together. First, the constructor is marked `private`, which means nothing outside the class can call `new Counter()` directly — that door is simply closed. Second, a `static` field inside the class holds the single instance. Third, a `getInstance()` method acts as the only way in — it checks if the instance already exists, creates it if it doesn't, and returns it either way.

```java
private Counter() {}

public static Counter getInstance() {
    if (instance == null) {
        instance = new Counter();
    }
    return instance;
}
```

To prove it actually works, the `main` method grabs two references — `c1` and `c2` — both through `getInstance()`. The check `c1 == c2` comes back `true`, confirming they're pointing at the same object in memory. Then it increments through `c1` five times and reads the count through `c2` — and it shows 5. That's the pattern doing exactly what it's supposed to.

```java
Counter c1 = Counter.getInstance();
Counter c2 = Counter.getInstance();

if (c1 == c2) {
    System.out.println("Same instance: true");
}

for (int i = 0; i < 5; i++) {
    c1.increment();
}

System.out.println("Count after 5 increments: " + c2.getCount()); // Prints 5
```

---

## Why Singleton? — Justification

The reason this pattern was chosen comes down to a very real problem: what happens when you need one shared resource across an entire program, but you can't guarantee that only one instance gets created?

Take the `Counter` as an example. If anyone could call `new Counter()` freely, each call would produce a completely separate object with its own count starting at zero. One part of the program increments its counter to 5, another part creates a fresh one and reads 0 — the data is all over the place and completely unreliable.

The Singleton pattern solves this cleanly. By locking down the constructor and controlling access through a single method, it becomes impossible to accidentally create a second instance. Every part of the program that asks for the counter gets the same one, which means the state is always consistent and there's no confusion about which counter is the "real" one.

It's a pattern that shows up constantly in real-world software — logging systems, configuration managers, database connection pools — anywhere you have something that genuinely needs to exist only once.

---

*Report prepared for the Software Architecture course.*
