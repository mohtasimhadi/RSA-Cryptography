package RSA;

import java.util.Random;
import java.util.Scanner;

public class RSA {

    static int gcd(int a, int b) {
        int g = 0,i;
        for(i=1; i <= a && i <= b; ++i)
        {
            if(a%i==0 && b%i==0)
                g = i;
        }
        return g;
    }

    static void encryption(int e, int d, int N)
    {
        String ch;
        int p,i;

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the message you want to encrypt:");
        ch=s.nextLine();
        char[] a = ch.toCharArray();

        System.out.println("Your encrypted message will be:");

        for(i=0;i<ch.length();i++) {

            if (a[i] >= 'A' && a[i] <= 'Z') {
                p = (int) (Math.pow((a[i] - 'A'),e) % N);
                char c = (char) (p + 'A');
                System.out.print(c);
            }

            else if (a[i] >= 'a' && a[i] <= 'z') {
                p = (int) (Math.pow((a[i] - 'a'), e) % N);
                char c = (char) (p + 'a');
                System.out.print(c);
            }

            else
                System.out.print(a[i]);
        }
    }

    public static void main(String[] args){
        int p, q, N, Q, e, d;
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the value of first prime no. ");
        p = s.nextInt();

        System.out.println("Enter the value of second prime no. ");
        q = s.nextInt();

        N=p*q;
        Q=(p-1)*(q-1);

        for(e=2;e<Q;e++){
            if(gcd(e,Q)==1)
                break;
        }

        for(d=r.nextInt()%100000;;d++){
            if(d!=1 && (d*e)%Q==1){
                break;
            }
        }

        encryption(e,d,N);
    }
}
