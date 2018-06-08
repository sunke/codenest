import { PatternDemo } from "./pattern";

let name = "Decorator Design Pattern";

let description = `
Adds additional functionalites on the orginal class.
`;

//----------------------------------------------------------------------------------

interface Shape {
    draw(): void;
}

class Circle implements Shape {
    draw(): void {
        console.log("Draw a circle")
    }
}

class CircleDecorator implements Shape {

    constructor(private circle: Circle) {};

    setColor(color: string) {
        console.log("Set color to", color);
    }

    draw(): void {
        this.setColor("black");
        this.circle.draw();
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let decorator = new CircleDecorator(new Circle());
    decorator.draw();
});