// Strategy Design Pattern Implementation
// The strategy design pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
// This allows the algorithm to vary independently from clients that use it.
// This pattern let us change the algorithm's behavior of object at runtime without changing the object itself.

public class StrategyDesign {

    // Strategy interface
    interface Strategy {

        int execute(int a, int b);
    }

    // Concrete strategy for addition
    static class Addition implements Strategy {

        @Override
        public int execute(int a, int b) {
            return a + b;
        }
    }

    // Concrete strategy for subtraction
    static class Subtraction implements Strategy {

        @Override
        public int execute(int a, int b) {
            return a - b;
        }
    }

    // Concrete strategy for multiplication
    static class Multiplication implements Strategy {

        @Override
        public int execute(int a, int b) {
            return a * b;
        }
    }

    // Context class that uses a Strategy
    static class Context {

        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public int executeStrategy(int a, int b) {
            return strategy.execute(a, b);
        }
    }

    // Main method to demonstrate the Strategy pattern
    public static void main(String[] args) {
        Context context = new Context(new Addition());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context.setStrategy(new Subtraction());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context.setStrategy(new Multiplication());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
