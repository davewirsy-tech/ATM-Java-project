import java.util.Scanner;

class Account {
    private double balance; // private = only this class can touch it directly

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() { // 
        return balance;
    }

    public void deposit(double depositamount) {
        balance = balance + depositamount;
        System.out.println("New balance:" + balance);
    }

    public void withdraw(double withdrawamount) {
        if (withdrawamount > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance = balance - withdrawamount;
            System.out.println("New balance" + balance);
        }
    }

    public void transferTo(Account other, double transferamount) {
        if (transferamount > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance = balance - transferamount;
            other.balance = other.balance + transferamount;
            System.out.println("Transfer successful.New balance:" + balance);
        }
    }

    public void checkBalance() {
        System.out.println("Your balance" + balance);
    }
}


// =====  ATM class: same as your original file/class name, still holds main() ======
public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your initial account balance:");
        double mybalance = sc.nextDouble();

        // Create Account objects instead of plain double variables
        Account myAccount = new Account(mybalance);
        Account otherAccount = new Account(0);

        int choice = 0;

        while (choice != 5) {
            System.out.println("========= Simple ATM ================");
            System.out.println("1.Check balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Transfer to other account");
            System.out.println("5.Exit");
            System.out.print("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    myAccount.checkBalance();
                    break;

                case 2:
                    System.out.println("Enter amount to deposit:");
                    double depositamount = sc.nextDouble();
                    myAccount.deposit(depositamount);
                    break;

                case 3:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawamount = sc.nextDouble();
                    myAccount.withdraw(withdrawamount);
                    break;

                case 4:
                    System.out.println("Enter amount to transfer:");
                    double transferamount = sc.nextDouble();
                    myAccount.transferTo(otherAccount, transferamount);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
