@FunctionalInterface
interface Checkable {
    public boolean check(int num);
}

interface Changable {
    public double change(int num);
}

public class DemoLambda {
    public static void main(String... args) {
        int[] arrayNum = new int[] { 2, -1, 5, 6, 3, 9, 1, -2, 10, 7, 4 };

        // Make a lambda expression to check if the num is positive (full format)
        Checkable checkPositive = (int num) -> {
            return num > 0;
        };
        System.out.println("All valid products");
        for (int num : arrayNum)
            if (checkPositive.check(num))
                System.out.println(num);

        //////////////////////////////////////////////////////////////////////////

        // Make a lambda expression to check if the num satisfy a condition (short
        // format)
        Checkable checkExpensive = num -> num > 4;
        System.out.println("All expensive products");
        for (int num : arrayNum)
            if (checkExpensive.check(num))
                System.out.println(num);

        //////////////////////////////////////////////////////////////////////////

        // Make a lambda expression to change the value of num (additional statement in
        // body)
        Changable discount = num -> {
            if (checkExpensive.check(num))
                return (double) (num * 0.9);
            return -1.0;
        };
        System.out.println("All products after discount");
        for (int num : arrayNum)
            if (discount.change(num) > 0.0)
                System.out.println(discount.change(num));
    }

}
