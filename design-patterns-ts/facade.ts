import { PatternDemo } from "./pattern";

let name = "Facade Design Pattern";

let description = `
Wraps complicated or deprecated classes with an unified interface.
`;

//----------------------------------------------------------------------------------

class OldClass1 {
    operation(): void {
        console.log("Call OldClass1.operation()");
    }
}

class OldClass2 {
    operation(): void {
        console.log("Call OldClass2.operation()");
    }
}

class Facade {
    constructor(private oldClass1: OldClass1, private oldClass2: OldClass2) { };

    operation(): void {
        this.oldClass1.operation();
        this.oldClass2.operation();
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    new Facade(new OldClass1(), new OldClass2()).operation();
});