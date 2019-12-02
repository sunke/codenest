import { PatternDemo } from "./pattern";

let name = "Builder Design Pattern";

let description = `
Delegates a creation of a complex object to a separate Builder object.
`;

//----------------------------------------------------------------------------------

class Car {
    constructor(private brand: string, private model: string, private engine: string, private year: number) {
        console.log("Create car: ", this.brand, "|", this.model, "|", this.engine, "|", this.year);
    };
}

class CarBuilder {
    public brand: string;
    public model: string;
    public engine: string;
    public year: number;

    public setBrand(brand: string): CarBuilder {
        this.brand = brand;
        return this;
    }

    public setModel(model: string): CarBuilder {
        this.model = model;
        return this;
    }

    public setEngine(engine: string): CarBuilder {
        this.engine = engine;
        return this;
    }

    public setYear(year: number): CarBuilder {
        this.year = year;
        return this;
    }

    public build(): Car {
        return new Car(this.brand, this.model, this.engine, this.year);
    }
}


//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let car1 = new CarBuilder().setBrand("Toyota").setModel("Aygo").setEngine("1.0 VVT-i").setYear(2017).build();
    let car2 = new CarBuilder().setBrand("Toyota").setModel("Prius").setEngine("1.8 Hybrid").setYear(2018).build();
    let car3 = new CarBuilder().setBrand("Hyundai").setModel("i30").setEngine("1.6 GDi").setYear(2012).build();
    let car4 = new CarBuilder().setBrand("Hyundai").setModel("i30").setEngine("1.0 T-GDi").setYear(2018).build();
});