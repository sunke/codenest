import { PatternDemo } from "./pattern";

let name = "Iterator Design Pattern";

let description = `
Provide a way to access the elements of an aggregate object sequentially
without exposing its underlying representation.
`;

//----------------------------------------------------------------------------------

interface Iterator {
    next(): any;
    hasNext(): boolean;
}

class RecordIterator implements Iterator {
    private pos: number = 0;

    constructor(private records: string[]) { }

    next() {
        return this.records[this.pos++];
    }

    hasNext(): boolean {
        return this.pos < this.records.length;        
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let iter = new RecordIterator(["rec1", "rec2", "rec3"]);

    while(iter.hasNext()) {
        console.log(iter.next());
    }
});