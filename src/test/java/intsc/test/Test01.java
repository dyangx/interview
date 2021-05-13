package intsc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Test01 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.err.println(s);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine();
        System.out.println(s);

    }
}
