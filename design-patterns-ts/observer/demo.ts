import { Observer, Subject } from './observer';

function demo(): void {
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
}

demo();