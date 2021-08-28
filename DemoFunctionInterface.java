//Without @FunctionalInterface
interface NoAnnotation {
    public void method1();

    public void method2();
}

// With annotation
@FunctionalInterface
interface WithAnnotation {
    public void onlyOne();
    // CAN'T COMPILE
    // public void otherOne();
}

interface CheckTheRule {
    public void singleMethod();

    @Override
    String toString(); // Acceptable because it's from Object class

    // default and static can still be used
    default void printDefault() {
        System.out.println("i'm the default method");
    }

    static void printStatic() {
        System.out.println("i'm the static method");
    }
}

// For the inherite rule
interface TheSuperInterface {
    public void singleMethod();
}

@FunctionalInterface
interface TheSubInterface extends TheSuperInterface {
    // CAN'T COMPILE
    // public void anotherOne();
}

public class DemoFunctionInterface {
    public static void main(String... args) {
        // Use default and static method
        // Default
        CheckTheRule check = new CheckTheRule() {
            public void singleMethod() {
            }
        };
        check.printDefault();

        // Static
        CheckTheRule.printStatic();
    }
}
