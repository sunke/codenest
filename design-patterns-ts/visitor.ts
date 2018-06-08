import { PatternDemo } from "./pattern";

let name = "Visitor Design Pattern";

let description = `
Represent an operation to be performed on elements of an object structure.
Visitor lets you define a new option without changing the classes of the
elements on which it operates. Visitor pattern is commonly used in parser
implementations.
`;

//----------------------------------------------------------------------------------

interface Node {
    accept(visitor: Visitor);
    setChildRight(node: Node): Node;
    setChildLeft(node: Node): Node;
}

abstract class AbstractNode implements Node {
    childRight: Node = null;
    childLeft: Node = null;

    abstract accept(visitor: Visitor);

    setChildRight(node: Node): Node {
        this.childRight = node;
        return this;
    }

    setChildLeft(node: Node): Node {
        this.childLeft = node;
        return this;
    }
}

class NodeA extends AbstractNode {
    accept(visitor: Visitor) {
        visitor.visitNodeA(this);
    }
}

class NodeB extends AbstractNode {
    accept(visitor: Visitor) {
        visitor.visitNodeB(this);
    }
}

class NodeC extends AbstractNode {
    accept(visitor: Visitor) {
        visitor.visitNodeC(this);
    }
}

interface Visitor {
    visitNodeA(node: NodeA);
    visitNodeB(node: NodeB);
    visitNodeC(node: NodeC);
}

class TreeVisitor implements Visitor {
    visitNodeA(node: NodeA) {
        console.log("Visit NodeA");
        if (node.childLeft != null) {
            node.childLeft.accept(this);
        }
        if (node.childRight != null) {
            node.childLeft.accept(this);
        }
    }

    visitNodeB(node: NodeB) {
        console.log("Visit NodeB")
        if (node.childLeft != null) {
            node.childLeft.accept(this);
        }
        if (node.childRight != null) {
            node.childLeft.accept(this);
        }
    }

    visitNodeC(node: NodeC) {
        console.log("Visit NodeC");
        if (node.childLeft != null) {
            node.childLeft.accept(this);
        }
        if (node.childRight != null) {
            node.childLeft.accept(this);
        }
    }
}

//----------------------------------------------------------------------------------

PatternDemo.show(name, description, () => {
    let root = new NodeA();
    root.setChildLeft(new NodeB().setChildLeft(new NodeC()).setChildRight(null))
        .setChildRight(new NodeC().setChildLeft(null).setChildRight(new NodeC()));

    root.accept(new TreeVisitor());
});