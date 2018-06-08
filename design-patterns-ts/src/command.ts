import { PatternDemo } from "./pattern";

let name = "Command Design Pattern";

let description = `
Encapsulates a action and its parameters into a command object.
`;

//----------------------------------------------------------------------------------

interface Command {
    execute(): void;
}

class BackupCommand implements Command {
    execute(): void {
        console.log("Execute backup.");
    }
}

class RestoreCommand implements Command {
    execute(): void {
        console.log("Execute restore.");
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let commands: Command[] = [];
    commands.push(new BackupCommand());
    commands.push(new RestoreCommand());

    for (let command of commands) {
        command.execute();
    }
});