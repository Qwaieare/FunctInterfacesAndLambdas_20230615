import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) {

        System.out.println("Задание №1 Predicate<T>");
        Predicate<Integer> number = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number >= 0;
            }
        };
        System.out.println(number.test(10));
        System.out.println(number.test(-10));
        System.out.println(number.test(0));

        System.out.println();
        Predicate<Integer> positive = num -> num >= 0;
        System.out.println(positive.test(12));
        System.out.println(positive.test(-14));
        System.out.println(positive.test(0));


        System.out.println();
        System.out.println("Задача №2 Consumer<T>");
        Consumer<String> greeting = new Consumer<>() {
            @Override
            public void accept(String name) {
                System.out.println("Hello " + name + "!!!");
            }
        };
        String name = "Alisa";
        greeting.accept(name);

        System.out.println();
        Consumer<String> talking = appeal -> System.out.println("Hello " + appeal + "!!!");
        talking.accept("Milisenta");


        System.out.println();
        System.out.println("Задача №3 Function<T, R>");
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double t) {
                return Math.round(t);
            }
        };
        System.out.println(function.apply(3.7));

        System.out.println();
        Function<Double, Long> rounded = n -> Math.round(n);
        System.out.println(rounded.apply(1.8));


        System.out.println();
        System.out.println("Задача №4 Suplier<T>");
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        System.out.println(supplier.get());

        System.out.println();
        Supplier<Integer> randomInteger = () -> (int) (Math.random() * 100);
        System.out.println(randomInteger.get());


        System.out.println();
        System.out.println("Задача №5 TernaryOperator");
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<String, Integer> ifFalse = String::length;
        Function<String, Integer> safe = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safe);
    }

        public static <T, U > Function < T, U > ternaryOperator(
                Predicate < ? super T > condition,
                Function < ? super T, ? extends U > ifTrue,
                Function < ? super T, ? extends U > ifFalse){

            return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);


        }
    }
