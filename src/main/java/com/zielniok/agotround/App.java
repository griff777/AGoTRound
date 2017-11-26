package com.zielniok.agotround;
import java.util.Arrays;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        int[][][] x = new int[5][][];
        x[2] = new int[6][];
        x[1] = new int[34][];
        x[2][2] = new int[5];

        int[][] y = new int[5][5];

        int[] f = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(f));

        String s1 = "java";
        StringBuilder s2 = new StringBuilder("java");

        if (s1.equals(s2)) {
            System.out.println("java");
        }

        s2.equals(s1);

        //nums(2);
        //nums(2, 2);
        //nums(2, 3,4,5);
        nums(2, null);

        //pums(2);
        //pums(2, "");
        pums(2, null);


        //System.out.println( "Hello World!" );
    }

    public static void nums(int a, int... num){
        //System.out.println( "Hello World!" );
    }
    public static void pums(int a, String... num){
        //System.out.println( "Hello World!" );
        System.out.println( num[0] );
    }

}
