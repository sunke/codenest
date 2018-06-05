import { PatternDemo } from "./pattern";

let name = "Decorator Design Pattern";

let description = `
Adds additional functionalites to an object.
`;

//----------------------------------------------------------------------------------

interface Shape {
    draw(): void;
}

class Circle implements Shape {
    draw(): void {
        console.log("draw a circle")
    }
}

class CircleDecorator implements Shape {

    constructor(private circle: Circle) {};

    setColor(color: string) {
        console.log("Set color to", color);
    }

    draw(): void {
        this.circle.draw();
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let circle = new Circle();
    circle.draw();

    let decorator = new CircleDecorator(circle);
    decorator.setColor("red");
    decorator.draw();
});