/*
 * All rights reserved. Copyright Robert Roy 2016.
 */
package textfinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Robert Roy <www.robertsworkspace.com>
 */
public class TextFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String prefix = "";
        String suffix = "";
        String input = "";
        try {
            System.out.print("Leading String");
            prefix = br.readLine(); // text BEFORE every instance of desired text
            System.out.print("Trailing String");
            suffix = br.readLine(); // text AFTER every instance of desired text
            System.out.print("Enter String");
            input = br.readLine(); // text to search
        } catch (IOException ex) {
            System.out.println("This program has encountered an error.");
            System.exit(0);
        }
        //System.out.println(prefix);
        while (true) {
            int a = input.indexOf(prefix, 0); // find prefix
            int b = input.indexOf(suffix, a + prefix.length()); // find suffix after end of prefix
            if (a == -1 || b == -1) {
                break; // leave loop if can't find instance of at least one
            }
            String get = input.substring(a + prefix.length(), b);
            try {
                input = br.readLine(); // get user input
            } catch (IOException ex) {
                System.out.println("This program has encountered an error.");
                System.exit(0);
            }
            get = get.toLowerCase();
            get = get.trim();
            System.out.println(get);
        }
    }

}
