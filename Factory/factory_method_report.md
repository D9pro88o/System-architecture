# Factory Method Design Pattern — ShapeFactory.java

---

## Program Description & Structure

This program is a clean Java implementation that shows the Factory Method pattern in action. It's built around shapes — `Circle` and `Square` — but the point isn't really about shapes. The point is about how objects get created, and who gets to decide that.

Everything lives in `ShapeFactory.java`. There's a shared `Shape` interface, two concrete classes that implement it, a factory that handles all the creation logic, and a `main` method to tie it all together and show it working.

---

## The Factory Method Pattern — What It Is and Where It's Applied

The Factory Method pattern is about separating the act of creating an object from the act of using it. Instead of letting the rest of the program worry about which class to instantiate and how, you hand that responsibility to one place — the factory — and everyone else just asks for what they need.

In `ShapeFactory.java`, the `Shape` interface defines a simple contract: anything that implements it has to provide a `draw()` method. `Circle` and `Square` both fulfill that, each in their own way. But the important part is what happens inside `ShapeFactory.createShape()`.

```java
public static Shape createShape(Type type) {
    switch (type) {
        case CIRCLE:
            return new Circle();
        case SQUARE:
            return new Square();
        default:
            return null;
    }
}
```

The caller just passes in a type — `CIRCLE` or `SQUARE` — and gets back a ready-to-use `Shape` object. It never touches `new Circle()` or `new Square()` directly. It doesn't need to know those classes even exist.

In `main`, this plays out simply and clearly:

```java
Shape circle = ShapeFactory.createShape(ShapeFactory.Type.CIRCLE);
Shape square = ShapeFactory.createShape(ShapeFactory.Type.SQUARE);
circle.draw(); // Circle drawn.
square.draw(); // Square drawn.
```

The calling code only ever deals with `Shape` — the factory quietly handles everything behind the scenes.

---

## Why Factory Method? — Justification

The problem this pattern solves becomes obvious the moment you imagine a program without it. If every part of the code that needs a shape writes `new Circle()` or `new Square()` directly, you've scattered object creation all over the place. The moment you rename a class, change how it's constructed, or add a new shape type, you have to hunt down and update every single spot where that happened. That's messy, error-prone, and hard to maintain as the project grows.

The Factory Method fixes this by giving creation one home. All the logic for deciding which object to build lives in `createShape()`, and nowhere else. If a new shape like `Triangle` needs to be added tomorrow, you add the class and update the factory — everything else stays untouched. It's a pattern that shows up constantly in real software for exactly this reason: it keeps the code flexible without making it complicated.

---

*Report prepared for the Software Architecture course.*
