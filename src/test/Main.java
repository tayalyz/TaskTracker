package test;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Test<Integer> ob = new Test<>(666);
        ob.showType();

        Test<Double> obStr = new Test<>(1d);
        obStr.showType();
    }

    public static Optional<String> task1(String s) {
        return Optional.ofNullable(s);
    }

//    public static String task2(Optional<String> op) {
////        return op.ifPresent();
//    }


}

/*
    Содание Op

* */



