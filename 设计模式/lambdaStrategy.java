package org.lc;

public class Solution {
    public static void main(String[] args) {
        new Solution().new Consumer<Integer,Object>().iterate(new Integer[]{1,2,3}, (Integer val)-> System.out.println(val));

        new Solution().new Consumer<String,Object>().iterate(new String[]{" g","o "," d "}, (String val) -> {
            val=val.trim();
            System.out.println(val);
            return val;
        });
    }
    interface DoReturn<P,R>{
        R iterateAndReturn(P p);

    }
    interface DoAction<P,R>{
        void iterateAndDo(P p);
    }
    class Consumer<P,R>{

        void iterate(P[] vals, DoReturn<P,R> function){
            for(P v: vals){
                function.iterateAndReturn(v);
            }
        }
        void iterate(P[] vals, DoAction<P,R> function){
            for(P v: vals){
                function.iterateAndDo(v);
            }
        }
    }
}

/*
Strategy Interface (Do<P, R>): This defines the common method (iterate) that different implementations will provide.

Concrete Strategy (Lambda Expression): You provide a specific implementation of the iterate method via a lambda expression, which can be easily swapped out for another implementation.

Context (Consumer<P, R>): This class uses a Do implementation to perform the task. It doesn't need to know the details of the specific algorithm being used.
* */
