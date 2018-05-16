export { Subject, Observer };

class Subject {
    private observers: Observer[] = [];

    constructor(public name: string) {
        console.log("An subject ", name, " is created.");
    }
    
    register(observer: Observer): void {
        this.observers.push(observer);

        console.log(observer, "is registered.");
    }

    unregister(observer: Observer): void {
        let pos: number = this.observers.indexOf(observer);
        if (pos != -1) {
            this.observers.splice(pos, 1);
            console.log(observer, "is unregistered.");
        }
    }

    notify(): void {
        for (let observer of this.observers) {
            observer.watch(this);
        }
    }
}


class Observer {

    constructor(private name: string) {
        this.name = name;
    }

    watch(subject: Subject): void {
        console.log(subject.name, " notified ", this.name);
    }
}