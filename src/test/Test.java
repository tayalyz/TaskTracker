package test;

import java.util.Map;

public class Test<T extends Number>{
    private Map<Integer, T> numbers;

    T ob;

    Test(T o){
        ob = o;
    }

    T getOb(){
        return ob;
    }

    void showType(){
        System.out.println(ob.getClass().getName()+" "+ob.getClass().getSimpleName());
    }
}
