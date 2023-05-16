import java.io.IOException;
import java.util.Scanner;

public class Bankaccount{
    //attribut

    int balance;
    int previousTransaction;


    //construktor

    public Bankaccount(){
        showMenu();
    }
    //metoder
    public void deposit (int amount) {
        if (amount > 0) {
            balance = balance + amount;
            previousTransaction = amount;

        }
    }

    public void withdraw(int amount){
        if(amount > 0 && balance >amount){
            balance = balance - amount;
            previousTransaction = -amount;
        } else if (amount > balance){
            System.out.println("Du har inte pengar på kontot");
        } else if (amount ==0){
            System.out.println("Välj en Summa");
        } else {
            System.out.println("Vänligen välj en valuta mellan 0 och 999");
        }
    }
    public void showMenu(){
        char option = '\0';
        System.out.println("Welcome: "+"");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");

        do {
            System.out.println("1 : Check your Balance");
            System.out.println("2 : Deposit");
            System.out.println("3: Withdraw");
            System.out.println("4 : Previous Transaction");
            System.out.println("5 : Exit the system");
            System.out.println();
            System.out.println("-------------------------");
            System.out.println("Enter Your Option");
            System.out.println("-------------------------");
            option = scanner.next().charAt(0);
            System.out.println("\n");


            switch (option) {
                case '1':
                    System.out.println("-------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("-------------------------");
                    System.out.println("\n");
                    break;

                case '2':
                    while (true) {

                        System.out.println("-------------------------");
                        System.out.println("Enter an amount to deposit: ");
                        System.out.println("-------------------------");
                        try {
                            int amount = scanner.nextInt();
                            if (amount > 0) {
                                deposit(amount);
                                break;
                            } else {
                                System.out.println("Du har inte resurserna för detta");

                            }
                        } catch (Exception e) {
                            scanner.next();
                            System.out.println("Invalid");
                        }
                    }
                    break;

                case '3':
                    System.out.println("-------------------------");
                    System.out.println("Enter an amount to withdraw ");
                    System.out.println("-------------------------");
                    System.out.println("\n");
                    try{
                        int amount2 = scanner.nextInt();
                        withdraw(amount2 );
                    }
                    catch(Exception e){
                        scanner.next();
                        System.out.println("Invalid");
                    }

                    break;

                case '4':
                    System.out.println("-------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------");
                    System.out.println("\n");
                    break;

                case '5':
                    System.out.println("-------------------------");
                    break;

                default:
                    System.out.println("Invalid option");
                    break;


            }
        } while (option != '5');
        System.out.println("Thank You");
    }
    //getset
    public void getPreviousTransaction(){
        if(previousTransaction >0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }
}
