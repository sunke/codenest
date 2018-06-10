import { PatternDemo } from "./pattern";

let name = "Memento Design Pattern";

let description = `
Capture an object’s internal state and externalize it so that it can be restored 
to that state later.
`;

//----------------------------------------------------------------------------------

class Memento {
    constructor(public state: number) { };
}

class Editor {
    private state: number = 0;
    private stack: Array<[string, Memento]> = [];

    constructor() {
        console.log("Initial State:", this.state)
    };

    doAction(name: string) {
        this.stack.push([name, new Memento(this.state)]);
        this.state = Math.floor(Math.random() * 100);
        console.log("State after doAction", name, ":", this.state);
    }

    undoAction() {
        let t = this.stack.pop();
        this.state = t[1].state; 
        console.log("State after undoAction", t[0], ":", this.state);
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let editor = new Editor();

    editor.doAction("Copy");
    editor.doAction("Paste");
    editor.doAction("Delete")
    editor.undoAction();
    editor.undoAction();
    editor.undoAction();
});