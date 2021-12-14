/*
 * Aman Choudhri
 * ac4972
 * Fail2Ban.java
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Fail2Ban {
    public static void main(String[] args) {
        // check num of args
        if (args.length != 2) {
            System.err.println("Invalid argument length! " +
                               "Usage: java Fail2Ban [log file] [output file]");
            System.exit(-1);
        }
        // load input file
        File inputF;
        Scanner in = null;
        try {
            inputF = new File(args[0]);
            in = new Scanner(inputF);
        } catch (FileNotFoundException e) {
            System.err.println("File " + args[0] + " not found!");
            System.exit(-1);
        }
        // check out file for exception now
        // this way we don't run the whole program only to find out that
        // the output file is invalid
        PrintWriter out = null;
        try {
            out = new PrintWriter(args[1]);
        } catch (FileNotFoundException e) {
            System.err.println("File " + args[1] + " not found!");
            System.exit(-1);
        }
        // initialize hashmap storing # of invalid attempts per ip addr
        HashMap<String, Integer> numInvalid = new HashMap<>();
        // process each line of file
        while (in.hasNextLine()) {
            String entry = in.nextLine();
            // if attempt is invalid, update ip addr's num of invalid attempts
            if (entry.contains("Invalid")) {
                String[] tokens = entry.split(" ");
                String ipAddr = tokens[tokens.length - 1];
                if (!numInvalid.containsKey(ipAddr)) {
                    numInvalid.put(ipAddr, 1);
                } else {
                    numInvalid.put(ipAddr, numInvalid.get(ipAddr) + 1);
                }
            }
        }
        // output results to file
        for (String ip : numInvalid.keySet()) {
            if (numInvalid.get(ip) >= 3) {
                out.println(ip);
            }
        }
        out.close();
    }
}
