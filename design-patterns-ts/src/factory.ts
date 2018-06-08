import { PatternDemo } from "./pattern";

let name = "Factory Design Pattern";

let description = `
Create an object without exposing its creation logic to the client 
and refer to the newly created object using a common interface.
`;

//----------------------------------------------------------------------------------

interface Shape {
    draw(): void;
}

class Circle implements Shape {
    draw(): void {
        console.log("Draw circle");
    }
}

class Square implements Shape {
    draw(): void {
        console.log("Draw square");
    }
}

class ShapeFactory {
    static createShape(name: string): Shape {
        switch(name) {
            case "circle": return new Circle(); // this creation logic can be complexity
            case "square": return new Square();
        }
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let circle = ShapeFactory.createShape("circle");
    let square = ShapeFactory.createShape("square");

    circle.draw();
    square.draw();
});