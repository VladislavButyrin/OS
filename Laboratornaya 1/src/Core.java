import java.util.HashMap;

public class Core {
    private MyStack myStack;
    private HashMap<Integer, SystemCall> sysHashMap;

    public void callSysCall(int key) {
        try {
            if (sysHashMap.get(key) == null) {
                throw new KeyNotFoundException();
            }
            System.out.println("Try: System Call " + key);
            System.out.println("System Call work with:");
            for (int i = 0; i < sysHashMap.get(key).getParametersCount(); i++) {
                Object tmp = myStack.pop();
                if(tmp == null){
                    throw new ArgumentsErrorException();
                }
                switch (sysHashMap.get(key).getParameters()[i]) {
                    case "Integer":
                        int tryToCastInt = (int) tmp;
                        System.out.println("Integer");
                        System.out.println("Value: " + tryToCastInt);

                        break;
                    case "String":
                        String tryToCastString = (String) tmp;
                        System.out.println("String");
                        System.out.println("Value: " + tryToCastString);
                        break;
                    case "Double":
                        Double tryToCastDouble = (Double) tmp;
                        System.out.println("Double");
                        System.out.println("Value: " + tryToCastDouble);
                        break;
                }
            }
        } catch (ClassCastException e) {
            System.out.println("Call " + key + " return error:\ninvalid parameter type");
        } catch (ArgumentsErrorException e) {
            System.out.println("Call " + key + " return error:\nIncorrect number of input parameters");
        } catch (KeyNotFoundException e) {
            System.out.println("Call " + key + " return error:\nSystem Сall with identifier " + key + " not found");
        }
    }

    private void initSysCalls() {
        sysHashMap = new HashMap<>(5);
        sysHashMap.put(1, new SystemCall("Integer", "String"));
        sysHashMap.put(2, new SystemCall("String", "String", "Integer"));
        sysHashMap.put(3, new SystemCall("Integer", "String", "Double"));
        sysHashMap.put(4, new SystemCall("String", "Double"));
        sysHashMap.put(5, new SystemCall("String", "Integer"));
    }

    public Core(MyStack myStack) {
        initSysCalls();
        setMyStack(myStack);
    }
    public void setMyStack(MyStack myStack) {
        this.myStack = myStack;
    }
    static class KeyNotFoundException extends Exception {
    }
    static class ArgumentsErrorException extends Exception {
    }
}

