class ClassBase {
    public void print() {
        System.out.println("the base");
    }
}

interface InterfaceBase {
    public void print();
}

public class DemoAnonymous {
    public static void main(String... args) {
        int a = 2;
        a += 3;
        final int b = 3;

        // Example for class
        ClassBase anonymousFromClass = new ClassBase() {
            // Can't have static initializer
            // static {}

            // Can only use final and effective final var
            // a = 4;
            public void print() {
                System.out.println(b);
            }
        };

        anonymousFromClass.print();

        // Example for interface
        InterfaceBase anonymousFromInterface = new InterfaceBase() {
            public void print() {
                System.out.println(b);
            }
        };
        anonymousFromInterface.print();
    }

    public static void TryToUseAnonymous() {
        // Can't be used from somewhere out of its scope
        // anonymousFromClass.print();
    }
}
