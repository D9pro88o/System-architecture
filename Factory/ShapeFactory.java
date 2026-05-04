// Factory Method Pattern in Java

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle drawn.");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square drawn.");
    }
}

public class ShapeFactory {
    public enum Type {
        CIRCLE,
        SQUARE
    }

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

    public static void main(String[] args) {
        // Demonstrate Factory Method pattern
        Shape circle = ShapeFactory.createShape(ShapeFactory.Type.CIRCLE);
        Shape square = ShapeFactory.createShape(ShapeFactory.Type.SQUARE);
        circle.draw();
        square.draw();
    }
}