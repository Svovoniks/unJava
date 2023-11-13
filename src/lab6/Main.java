package lab6;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());


        Sales sales = new Sales();
        sales.addSale("item", 1, 1);
        sales.addSale("item2", 1, 1);
        sales.addSale("item2", 1, 1);
        sales.addSale("item", 1, 1);

        sales.printAllSales();

        System.out.println(sales.getTopItem());
        System.out.println(sales.getTotalItemsSold());
        System.out.println(sales.getTotalRevenue());
    }
}
