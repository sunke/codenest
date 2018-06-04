import { PatternDemo } from "./pattern";

let name = "Singleton Design Pattern";

let description = `
Ensure a class has only one instance.
`;

//----------------------------------------------------------------------------------

class Singleton {

    private static instance = null;

    private constructor(public id: number) {};

    static build(): Singleton {
        if (this.instance == null) {
            this.instance = new Singleton(Math.random());
        }
        return this.instance;
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let obj1 = Singleton.build();
    let obj2 = Singleton.build();

    obj1.id === obj2.id ? console.log("obj1 == obj2") : console.log("obj1 != obj2");
});