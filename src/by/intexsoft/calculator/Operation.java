package by.intexsoft.calculator;

/**
 * Created by Admin on 20.07.2015.
 */
public enum Operation implements Callable {
    ADD {
        @Override
        public int call(int a, int b) {
            return a + b;
        }
    },
    MULTIPLY {
        @Override
        public int call(int a, int b) {
            return a * b;
        }
    },
    DELETE {
        @Override
        public int call(int a, int b) {
            return a - b;
        }
    }
}
