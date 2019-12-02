import { PatternDemo } from "./pattern";

let name = "Flyweight Design Pattern";

let description = `
For a large number of objects reducing the memory usage through moving memory
expensive states to an external object called extrinsic state and sharing this 
extrinsic state between the objects.  
`;

//----------------------------------------------------------------------------------

// extrinsic state class
class Engine { 
    constructor(public name: string) {};
}

class Car {
    constructor(public model: string, public engine: Engine, public seat: number) {
        console.log("Car:", this.model, "|", this.engine.name, "|", this.seat);
    };
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let engine1 = new Engine("1.6 GDI");
    let car1 = new Car("i30", engine1, 5);
    let car2 = new Car("i40", engine1, 5);
});