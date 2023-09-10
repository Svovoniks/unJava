
public class Main {
    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println();

        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println();

        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println();

        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        System.out.println();

        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println();

        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println();

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println();

        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        System.out.println();

        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println();

        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));

        System.out.println();
    }

    public static double convert(int gallons) {
        return gallons * 3.785d;
    }

    public static int fitCalc(int time, int level) {
        return time * level;
    }

    public static int containers(int boxes, int sacks, int barrels) {
        return boxes * 20 + sacks * 50 + barrels * 100;
    }

    public static String triangleType(int x, int y, int z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "not a triangle";
        }
        if (x == y && y == z) {
            return "isosceles";
        }
        if (x == y || x == z || y == z) {
            return "equilateral";
        }
        return "different-sided";
    }

    public static int ternaryEvaluation(int x, int y) {
        return x > y ? x : y;
    }

    public static int howManyItems(double n, double w, double h) {
        return (int) (n / (w * h * 2));
    }
    public static int factorial(int num) {
        int factor = 1;
        for (int i  = 1; i <= num; i++) factor *= i;
        return factor;
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    public static int ticketSaler(int count, int cost) {
        return (int) (count * cost * 0.72);
    }
    public static int tables(int students, int tables) {
        return students > tables * 2 ? (int) Math.ceil(students % (tables * 2) / 2d) : 0;
    }





}