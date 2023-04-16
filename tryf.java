import java.util.HashMap;
import java.util.Scanner;

public class tryf {
    public static void main(String[] args) {
        HashMap<Character,Integer> romans = new HashMap<>(){{
           put('I',1); put('V',5);put('X',10); put('L',50);put('C',100);put('D',500);
           put('M',1000);
        }};
        Scanner in = new Scanner(System.in);
        int s = 0;
        String x = in.next();
        for (int i = 0; i < x.length(); i++) {
            if (i==x.length()-1 || romans.get(x.charAt(i))>=romans.get(x.charAt(i+1)) ){
                s+= romans.get(x.charAt(i)); // we add the value only if the char is the last one
                // or it is greater or equal the next one to him
                // like VIII = V=5 > I=1 so it is 5 and I=1==I=1 so it is 6 I=1==I=1 so it is 7
                // and the last value is I=1 so it is 8 and it is true
            }else{
                s-=romans.get(x.charAt(i));
            }   // all the otherwise we need to sub the value like IV : I=1 < V=5 so it is like -1+5
            // which is 4 and it is true
        }

        System.out.println(s);
    }
}
