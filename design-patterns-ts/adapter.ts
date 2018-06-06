import { PatternDemo } from "./pattern";

let name = "Adapter Design Pattern";

let description = `
Converts the incompatible interface of a class (Adaptee) into the interface 
clients require.
`;

//----------------------------------------------------------------------------------

interface Expect {
    expectCall(): void;
}

class Adaptee {
    incompatibleCall(): void {
        console.log("Adaptee.incompatibleCall() is called.")
    }
}

class Adaptor implements Expect {
    expectCall(): void {
        console.log("Adaptor.targetCall() executes.")
        new Adaptee().incompatibleCall();
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let adaptor = new Adaptor();
    adaptor.expectCall();
});