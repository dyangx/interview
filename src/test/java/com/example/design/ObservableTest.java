package com.example.design;

import org.junit.Test;
import rx.Observable;


public class ObservableTest {

    @Test
    public void test1(){

        Observable.just("hello").subscribe(s -> System.out.println("just string->"+s));
        Observable.just(1,2,3,4).subscribe(s -> System.out.println("just string->"+s));
//        Observable.just("")
    }


}
class Solution {
    // 1 4  5
    public static String addSpaces(String s, int[] spaces) {
        int[] arr = new int[s.length()+spaces.length];
        int x = 0;
        for(int n = 0;n<s.length();n++){
            int m = Math.min(x,spaces.length-1);
            if(spaces[m] == n) {
                arr[n+x] = ' ';
                x++;
            }
            arr[n+x] = s.charAt(n);

        }
        return new String(arr,0,arr.length);
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6};
        String x = addSpaces("spacing",a);
        System.out.println(x);

        char[] aa= {97};
        char c = aa[0];
        System.out.println(new String(aa));
        System.out.println((int)'a');
    }
}
