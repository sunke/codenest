export { PatternDemo };

class PatternDemo {

    static show(name: string, description: string, demo: () => void): void {
        console.log("--------------------------------------------------------------------------------------------");
        console.log(name);
        console.log("--------------------------------------------------------------------------------------------");
        console.log(description);
        console.log("--------------------------------------------------------------------------------------------");

        demo();
    }
}