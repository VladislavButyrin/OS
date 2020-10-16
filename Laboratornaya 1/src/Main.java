public class Main {
    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        Core core = new Core(myStack);
        System.out.println();
        //first
        myStack.push("str");

        myStack.push(1);
        core.callSysCall(1);
        System.out.println();
        //second
        myStack.push(1);
        myStack.push("str");
        myStack.push("str");
        core.callSysCall(2);
        System.out.println();

        //third
        myStack.push(1.5);
        myStack.push("str");
        myStack.push(1);
        core.callSysCall(3);

        System.out.println();

        //fourth
        myStack.push(1.5);
        myStack.push("str");
        core.callSysCall(4);
        System.out.println();

        //fifth
        myStack.push(1);
        myStack.push("str");
        core.callSysCall(5);
        System.out.println();

        //wrong System Call
        core.callSysCall(0);
        System.out.println();
        //wrong number
        core.callSysCall(3);
        System.out.println();
        //wrong type
        myStack.push("str");
        myStack.push(1);
        core.callSysCall(2);
        System.out.println();


    }
}
