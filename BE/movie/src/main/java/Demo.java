public class Demo {

    enum Operation {
        ADD {
            public int perform(int a, int b) {
                return a + b;
            }
        },
        SUBTRACT {
            public int perform(int a, int b) {
                return a - b;
            }
        },
        MULTIPLY {
            public int perform(int a, int b) {
                return a * b;
            }
        };
        public abstract int perform(int a, int b);
    }
        public static void main(String[] args) {
            Operation operation = Operation.ADD;
            int result = operation.perform(3, 2);
            System.out.println("Result: " + result);
        }


}
