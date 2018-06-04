import { PatternDemo } from "./pattern";

let name = "Factory Design Pattern";

let description = `
Abstracts the creation of a family of objects into a common interface.
`;

//----------------------------------------------------------------------------------

interface Button {
}

interface Label {
}

interface Factory {
    createButton(): Button;
    createLabel(): Label;
}

class WindowsFactory implements Factory {
    private static WindowsButton = class implements Button {
        constructor() {
            console.log("Windows Button"); 
        }
    }

    private static WindowsLabel = class implements Label {
        constructor() {
            console.log("Windows Label"); 
        }
    }

    createButton(): Button {
        return new WindowsFactory.WindowsButton();
    }

    createLabel(): Label {
        return new WindowsFactory.WindowsLabel();
    }
}

class UbuntuFactory implements Factory {
    private static UbuntuButton = class implements Button {
        constructor() {
            console.log("Ubuntu Button"); 
        }
    }

    private static UbuntuLabel = class implements Label {
        constructor() {
            console.log("Ubuntu Label"); 
        }
    }

    createButton(): Button {
        return new UbuntuFactory.UbuntuButton();
    }

    createLabel(): Label {
        return new UbuntuFactory.UbuntuLabel();
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let winFactory = new WindowsFactory();
    let ubuFactory = new UbuntuFactory();

    winFactory.createButton();
    winFactory.createLabel();
    ubuFactory.createButton();
    ubuFactory.createLabel();
});