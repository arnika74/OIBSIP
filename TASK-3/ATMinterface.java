

import java.util.Scanner;

class BankAccount {

    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 10000f;
    int transactions = 0;
    String transactionHistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter your Name: ");
        this.name = sc.nextLine();
        System.out.println("\n Enter your User Name: ");
        this.userName = sc.nextLine();
        System.out.println("\n Enter your Password: ");
        this.password = sc.nextLine();
        System.out.println("\n Enter your Account Number: ");
        this.accountNo = sc.nextLine();
        System.out.println("\n Registration Successful. Please Log in to your Bank account.");
    }

    public boolean login(){
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while( !isLogin ){
            System.out.println("\n Enter your User Name: ");
            String UserName = sc.nextLine();
            if (UserName.equals(userName)) {
                while (!isLogin) {
                    System.out.println("\n Enter your Password: ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\n Login Successful. Welcome "+this.name);
                        isLogin = true;
                    }
                     else {
                    System.out.println("\n Invalid Password. Please try again.");
                    }
                }
            } 
            else {
                System.out.println("\n Invalid User Name. Please try again.");
            }
        } 
        return isLogin; 
    }

    public void withdraw() {
        System.out.println("\n Enter amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
          if (balance >= amount) {
            transactions++;
            balance -= amount;
            System.out.println("\n Amount withdrawn successfully. Remaining balance: " + balance);
            String str = amount + "Rs Withdrawn\n";
            transactionHistory += str;
          } else {
            System.out.println("\n Insufficient balance.");
          }
        } catch (Exception e) {

        }    
    }

    public void deposit() {
        System.out.println("\n Enter amount to deposit: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if ( amount <= 10000f) {
               transactions++;
               balance += amount;
               System.out.println("\n Amount deposited successfully. Current balance: " + balance);
               String str = amount + "Rs Deposited\n";
               transactionHistory += str;
            }
            else {
                System.out.println("\n You can deposit maximum 10000Rs at a time.");
            }
        } catch (Exception e) {

        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter Recipient Name: ");
        String re = sc.nextLine();
        System.out.println("\n Enter amount to transfer: ");
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
            if (amount <= 50000f) {
            transactions++;
            balance -= amount;
            System.out.println("\n Amount transferred successfully. Remaining balance: " + balance);
            String str = amount + "Rs Transferred to " + re + "\n";
            transactionHistory += str;
            } else {
            System.out.println("\n Sorry. The limit is 50000Rs");
            }
            } else {
                System.out.println("\n Insufficient balance.");
            }
        } catch (Exception e) {

        }
    }

    public void checkBalance() {
        System.out.println("\n Current balance: " + balance);
    }

    public void transHistory() {
        if(transactions == 0) {
            System.out.println("\n No transactions yet.");
        }
        else {
            System.out.println("\n Transaction History: " + transactionHistory);
        }
    }
}
public class ATMinterface {
     public static int takenIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                input = new Scanner(System.in).nextInt();
                flag = true;

                if(flag && input > limit || input < 1) {
                    System.out.println("Choose the number between 1 and " + limit);
                    flag = false;
                }
            } catch (Exception e) {
               System.out.println("Enter only int value.");
               flag = false;
            }
        //return input;
        } return input;
    }
    public static void main(String[] args) {
        System.out.println("\n**********WELCOME TO JAIN ATM INTERFACE**********");
        System.out.println("\n1.Register \n2.Exit");
        System.out.println("\nChoose an option: ");
        int choose = takenIntegerInput(2);

        if(choose == 1) {
            BankAccount user = new BankAccount();
            user.register();
            while (true) { 
                System.out.println("\n1.Login \n2.Exit");
                System.out.println("Enter your choice: ");
                int ch = takenIntegerInput(2);
                if (ch == 1) {
                    if(user.login()) {
                       System.out.println("\n**********WELCOME BACK" + user.name + " **********");
                       boolean isFinished = false;
                       while(!isFinished) {
                        System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.check balance \n5.Transaction History \n6.Exit");
                        System.out.println("Enter your choice: ");
                        int c = takenIntegerInput(6);
                        switch(c) {
                            case 1: 
                              user.withdraw(); 
                              break;
                            case 2: 
                              user.deposit(); 
                              break;
                            case 3: 
                              user.transfer(); 
                              break;
                            case 4: 
                              user.checkBalance(); 
                              break;
                            case 5: 
                              user.transHistory(); 
                              break;
                            case 6: 
                              isFinished = true; 
                              break;
                            }
                        }
                    } else {
                        System.exit(0);
                    }
                } else {
                    System.exit(0);
                }   
            }
        }
    }
}