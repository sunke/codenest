import { PatternDemo } from "./pattern";

let name = "Observer Design Pattern";

let description = `
Defines a Subject-Observers relations between objects so that when the Subject object
changes its state, all the Observer objects are notified and updated automatically.
`;

//----------------------------------------------------------------------------------

class Subject {
    private observers: Observer[] = [];

    constructor(public name: string) { }

    register(observer: Observer): void {
        this.observers.push(observer);
        console.log(this.name, "registers", observer.name);
    }

    unregister(observer: Observer): void {
        let pos: number = this.observers.indexOf(observer);
        if (pos != -1) {
            this.observers.splice(pos, 1);
            console.log(this.name, "unregisters", observer.name);
        }
    }

    notify(): void {
        for (let observer of this.observers) {
            observer.watch(this);
        }
    }
}

class Observer {

    constructor(public name: string) { };

    watch(subject: Subject): void {
        console.log(subject.name, "notifies", this.name);
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let subject1 = new Subject("subject1");
    let subject2 = new Subject("subject2");
    let observer1 = new Observer("observer1");
    let observer2 = new Observer("observer2");

    subject1.register(observer1);
    subject2.register(observer1);
    subject2.register(observer2);

    subject1.notify();
    subject2.notify();

    subject2.unregister(observer1);
    subject2.notify();
});