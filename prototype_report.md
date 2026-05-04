# Prototype Design Pattern — Main.java (Ghost/Monster)

---

## Program Description & Structure

This program is a Java implementation that demonstrates the Prototype pattern through a simple monster system. The idea is straightforward: instead of building a new object from scratch every time you need one, you start with an existing object and clone it.

The code is split across a `Monster` interface, a `Ghost` class that implements it, and a `Main` class where everything runs. It's intentionally small — just enough to show how cloning works and why it's useful.

---

## The Prototype Pattern — What It Is and Where It's Applied

The Prototype pattern is built around one idea: if you already have a fully configured object, why go through the trouble of creating a new one from scratch? Just copy it.

In this program, the `Monster` interface defines the blueprint — every monster must be able to `clone()` itself and `scream()`. The `Ghost` class is where the actual cloning logic lives, and it does it through a copy constructor: a second constructor that takes an existing `Ghost` and copies its fields over.

```java
public Ghost(Ghost target) {
    if (target != null) {
        this.type = target.type;
        this.health = target.health;
    }
}

@Override
public Monster clone() {
    return new Ghost(this);
}
```

When `clone()` is called, it passes the current object into the copy constructor and returns a brand new `Ghost` with all the same values — completely independent from the original.

In `main`, this is demonstrated cleanly:

```java
Ghost prototypeGhost = new Ghost("Shadow Ghost", 100);

Monster ghost1 = prototypeGhost.clone();
Monster ghost2 = prototypeGhost.clone();

ghost1.scream(); // I am a Shadow Ghost with 100 HP! *Boo!*
ghost2.scream(); // I am a Shadow Ghost with 100 HP! *Boo!*
```

One original is created, and two independent clones are produced from it — no constructors called manually, no repeated setup.

---

## Why Prototype? — Justification

The pattern was chosen here because it solves a very practical problem: what do you do when creating an object is repetitive or expensive, and you need several copies of it with the same starting configuration?

Without cloning, you'd have to write `new Ghost("Shadow Ghost", 100)` every time you wanted another one. That might seem harmless in a small example, but in a real game where enemies have dozens of attributes — stats, behaviors, equipment, state — repeating that setup manually every time is tedious and easy to get wrong. If the initial configuration changes, you'd have to update it everywhere.

The Prototype pattern solves this by letting the object itself carry the knowledge of how to copy itself. You set up one well-configured prototype, and from that point on, cloning is all you need. It's clean, reliable, and scales naturally as the object gets more complex.

---

*Report prepared for the Software Architecture course.*
