package solution;

import java.util.HashMap;
import java.util.Scanner;

public class tryf {
    static public int roman_TO_int(String roman){
        HashMap<Character,Integer> romans = new HashMap<>(){{
            put('I',1); put('V',5);put('X',10); put('L',50);put('C',100);put('D',500);
            put('M',1000);
        }};
        int s = 0;
        for (int i = 0; i < roman.length(); i++) {
            if (i==roman.length()-1 || romans.get(roman.charAt(i))>=romans.get(roman.charAt(i+1)) ){
                s+= romans.get(roman.charAt(i)); // we add the value only if the char is the last one
                // or it is greater or equal the next one to him
                // like VIII = V=5 > I=1 so it is 5 and I=1==I=1 so it is 6 I=1==I=1 so it is 7
                // and the last value is I=1 so it is 8 and it is true
            }else{
                s-=romans.get(roman.charAt(i));
            }   // all the otherwise we need to sub the value like IV : I=1 < V=5 so it is like -1+5
            // which is 4 and it is true
        }
        return s;
    }
    public static void main(String[] args) {

        String day = "V" , month = "III" , year = "MCMLXXXV" ;
        System.out.println("1100 since " + roman_TO_int(day) + "/" + roman_TO_int(month) + "/" + roman_TO_int(year));
    }
}
