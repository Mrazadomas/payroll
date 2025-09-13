package org.example;
import java.util.Scanner;
import java.text.DecimalFormat;;

public class Payroll {

    public double rate;
    public double hours;
    public int children;
    DecimalFormat df = new DecimalFormat("#.00");
    DecimalFormat cf = new DecimalFormat("#");

    public void greeting() {
        System.out.println("Welcome to the Payroll Program!\n\n");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("What is your pay rate? ");
            rate = scanner.nextDouble();
            if (rate < 0) {
                System.out.println("Please enter a valid pay rate.");
            }
        } while (rate < 0);
        System.out.print("\n\nHow many hours did you work this week? ");
        hours = scanner.nextDouble();
        System.out.print("\n\nHow many children do you have? ");
        children = scanner.nextInt();
        if (children < 0) {
            children = 0;
        }
        scanner.close();
    }

    public void payroll() {
        double gross;
        double net;
        double netT;
        double ot = 0;
        double tempH;
        if (hours > 40) {
            ot = hours - 40;
            tempH = hours - ot;
            gross = (ot * (rate * 1.5)) + (tempH * rate);
        } else {
            gross = hours * rate;
        }
        double SocSec = gross * 0.06;
        double fed = gross * 0.14;
        double state = gross * 0.05;
        double union = 10;
        double ins;
        if (children >= 3) {
            ins = 35;
        } else {
            ins = 15;
        }
        netT = gross - SocSec - fed - state - union - ins;
        if (netT < 0) {
            net = gross - SocSec - fed - state;
        } else {
            net = netT;
        }
        System.out.println("\n\nPayroll Stub: ");
        System.out.println("\nHours: " + cf.format(hours));
        System.out.println("\nRate: $" + df.format(rate));
        System.out.println("\nGross: $" + df.format(gross));
        System.out.println("\n\nDeductions: ");
        System.out.println("\n\nNumber of Dependents: " + children);
        System.out.println("\n\nSocial Security: $" + df.format(SocSec));
        System.out.println("\nFederal Tax: $" + df.format(fed));
        System.out.println("\nState Tax: $" + df.format(state));
        if (netT > 0) {
            System.out.println("\nUnion Fee: $" + df.format(union));
            System.out.println("\nHealth Insurance: $" + df.format(ins));
        }
        System.out.println("\n\nNet Pay: $" + df.format(net));
        if (netT < 0) {
            System.out.println("\n\nEmployee still owes: ");
            System.out.println("\nUnion Fee: $" + df.format(union));
            System.out.println("\nHealth Insurance: $" + df.format(ins));
        }
        System.out.println("\n\nThanks for using the Payroll program!");

    }


}   
