import { PatternDemo } from "./pattern";

let name = "Chain of Responsibility Design Pattern";

let description = `
Chain serveral handler objects together to make every handler has possibility
to handle requests.
`;

//----------------------------------------------------------------------------------

abstract class Handler {
    handler: Handler;

    abstract process(message: string);

    chain(handler: Handler): Handler {
        this.handler = handler
        return this.handler;
    };
}

class HandlerTextRequest extends Handler {
    process(message: string) {
        if (message == "text") {
            console.log("Process text ...");
        } else if (this.handler != null) {
            this.handler.process(message);
        }
    }
}

class HandlerImageRequest extends Handler {
    process(message: string) {
        if (message == "image") {
            console.log("Process image ...");
        } else if (this.handler != null) {
            this.handler.process(message);
        }
    }
}

class HandlerVideoRequest extends Handler {
    process(message: string) {
        if (message == "video") {
            console.log("Process video ...");
        } else if (this.handler != null) {
            this.handler.process(message);
        }
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let chain = new HandlerTextRequest();
    chain.chain(new HandlerImageRequest).chain(new HandlerVideoRequest);

    chain.process("video");
    chain.process("image");
    chain.process("text");
    chain.process("audio"); // no handler able to process audio
});