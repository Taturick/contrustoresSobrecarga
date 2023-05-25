package Aplication;

import java.util.Locale;
import java.util.Scanner;

import Entities.Account;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account account;

        System.out.print("Enter account number: ");
        int number = sc.nextInt();
        System.out.printf("Enter account holder: ");
        sc.nextLine();
        String holder = sc.nextLine();

        char response;
        do {
            System.out.println("Is there an initial deposit (Y/N)?");
            response = sc.nextLine().toUpperCase().charAt(0);
            if (response != 'Y' && response != 'N') {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (response != 'Y' && response != 'N');

        if (response == 'Y') {
            System.out.println("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(number, holder, initialDeposit);
        } else {
            account = new Account(number, holder);
        }

        System.out.println();
        System.out.println("Account data:");
        System.out.println(account);

        System.out.println();
        System.out.printf("Enter a deposit value: ");
        double depositValue = sc.nextDouble();
        account.deposit(depositValue);
        System.out.println("Updated account data: ");
        System.out.println(account);

        System.out.println();
        System.out.printf("Enter a withdrawal value: ");
        double withdrawValue = sc.nextDouble();
        account.withdraw(withdrawValue);
        System.out.println("Updated account data: ");
        System.out.println(account);

        sc.close();
    }
}
