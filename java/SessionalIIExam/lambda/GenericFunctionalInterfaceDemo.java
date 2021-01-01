package lambda;

interface SomeTest<T>{
    boolean test(T n, T m);
}

public class GenericFunctionalInterfaceDemo {
    public static void main(String[] args){
        SomeTest<Integer> isFactor = (n,d) -> (n%d) == 0;

        if(isFactor.test(10,2))
            System.out.println("2 is factor of 10.");
        System.out.println();

        SomeTest<Double> isFactorD = (n,d) -> (n%d) == 0;
        if(isFactorD.test(212.0, 4.0))
            System.out.println("4.0 is factor of 212.0.");
        System.out.println();

        SomeTest<String> isIn = (a,b) -> a.indexOf(b) != -1;
        String str = "Generic Functional Interface";

        System.out.println("Testing string: " + str);
        if(isIn.test(str,"face"))
            System.out.println("'face' is found");
        else
            System.out.println("'face' is not found");
    }
}
