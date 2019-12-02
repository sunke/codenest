import { PatternDemo } from "./pattern";

let name = "State Design Pattern";

let description = `
Provide a cleaner way for an object to change its behavior at runtime 
without resorting to large monolithic conditional statements.
`;

//----------------------------------------------------------------------------------
interface State {
    nextState(fan: Fan): State;
}

class OffState implements State {
    nextState(fan: Fan): State {
        console.log("Change to low speed state.");
        return new LowSpeedState();
    }
}

class LowSpeedState implements State {
    nextState(fan: Fan): State {
        console.log("Change to high speed state.");
        return new HighSpeedState();
    }
}

class HighSpeedState implements State {
    nextState(fan: Fan): State {
        console.log("Change to off state.");
        return new OffState();
    }

}

class Fan {
    private state: State;
    
    constructor() {
        this.state = new OffState();
        console.log("Initial state is off.");
    }

    pull() {
        this.state = this.state.nextState(this);
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let fan = new Fan();
    fan.pull(); // switch to low speed
    fan.pull(); // switch to high speed
    fan.pull(); // switch off
    fan.pull(); // switch to low speed
});