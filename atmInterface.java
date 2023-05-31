import java.util.*;

class bankacc {
    static void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("**************************************************");
        System.out.println("Enter your name :");
        ATMinter.name = sc.nextLine();
        System.out.println("---------------------------");
        System.out.println("Enter username :");
        String user = sc.nextLine();
        System.out.println("---------------------------");
        System.out.println("Enter password :");
        String pass = sc.nextLine();
        System.out.println("---------------------------");
        System.out.println("Enter your Account number :");
        ATMinter.accnumber = sc.nextLine();
        System.out.println("---------------------------");
        System.out.println("REGISTRATION SUCCESSFULLY DONE!");
        System.out.println("**************************************************");
        ATMinter.prompt();
        while (true) {
            display(ATMinter.name);
            int choice = sc.nextInt();
            if (choice == 1) {
                login(user, pass);
                break;
            } else {
                if (choice == 2) {
                    System.exit(0);
                } else {
                    System.out.println("Bad value! Enter again!");
                }
            }
        }
    }

    static void display(String name) {
    }

    static void login(String user, String pass) {
    }
}

class transaction {
    static void withdrawcash() {
        Scanner sc = new Scanner(System.in);
        System.out.println("**************************************************");
        System.out.println("Enter amount to withdraw from your account :");
        int wdcash = sc.nextInt();
        if (wdcash <= ATMinter.balance) {
            ATMinter.balance = ATMinter.balance - wdcash;
            ATMinter.history.add(Integer.toString(wdcash));
            ATMinter.history.add("Withdraw");
            System.out.println("Amount Rs" + wdcash + "/-withdraw successfully");
            System.out.println("**************************************************");
        } else {
            System.out.println("insufficient balance to withdraw the cash");
            System.out.println("**************************************************");
        }
        ATMinter.prompt();
    }

    static void depositcash() {
        Scanner sc = new Scanner(System.in);
        System.out.println("**************************************************");
        System.out.print("Enter amount to deposit in your account :");
        int dpcash = sc.nextInt();
        ATMinter.updatebalance(dpcash);
        ATMinter.history.add(Integer.toString(dpcash));
        ATMinter.history.add("Deposit");
        System.out.println("Amount Rs." + dpcash + "/- deposit successful!");
        System.out.println("**************************************************");
        ATMinter.prompt();
    }

    static void transfermoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("****************************************************");
        System.out.println("Enter the receiving body:");
        String s = sc.nextLine();
        System.out.println("Enter the account number of the receiving body");
        int num = sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int tcash = sc.nextInt();
        if (tcash <= ATMinter.balance) {
            ATMinter.balance = ATMinter.balance - tcash;
            ATMinter.history.add(Integer.toString(tcash));
            ATMinter.history.add("transferred");
            System.out.println("Amount Rs." + tcash + "/- transferred successfully");
        } else {
            System.out.println("insufficient balance to transfer the cash");
            System.out.println("**************************************************");
        }
    }
}

class checkbal {
    static void checkbalancehistory() {
        System.out.println("****************************************************");
        System.out.println("The available balance in the bank account :");
        ATMinter.showbalance();
        System.out.println("****************************************************");
        ATMinter.prompt();
    }
}

class transhis {
    static void transactionhistory() {
        System.out.println("**************************************************");
        System.out.println("Transaction History :");
        int cnt = 0;
        if (ATMinter.balance > 0) {
            for (int i = 0; i < (ATMinter.history.size() / 2); i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(ATMinter.history.get(cnt) + " ");
                    cnt++;
                }
                System.out.println("**************************************************");
            }
        } else {
            System.out.println("your account is empty");
        }
        ATMinter.prompt();
    }
}

class ATMinter {
    public static String name;
    public static int balance = 0;
    public static String accnumber;
    public static ArrayList<String> history = new ArrayList<String>();

    static void updatebalance(int dcash) {
        balance = balance + dcash;
    }

    static void showbalance() {
        System.out.println(balance);
    }

    public static void starting() {
        System.out.println("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO XYZ BANK ATM SERVICE");
        System.out.println("**************************************************");
        System.out.println("select option :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice");
        int choice = sc.nextInt();
        if (choice == 1) {
            bankacc.register();
        } else {
            if (choice == 2) {
                System.exit(0);
            } else {
                System.out.println("select a value only from the given options :");
                starting();
            }
        }
    }

    static void prompt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME " + ATMinter.name + "!");
        System.out.println("---------------------");
        System.out.println("Select option : ");
        System.out.println("> Withdraw ............(press 1)");
        System.out.println("> Deposit .............(press 2)");
        System.out.println("> Transfer ............(press 3)");
        System.out.println("> Check balance .......(press 4)");
        System.out.println("> Transaction History..(press 5)");
        System.out.println("> Exit ................(press 6)");
        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdrawcash() ;
            case 2:
                transaction.depositcash();
            case 3:
                transaction.transfermoney();
            case 4:
                checkbal.checkbalancehistory();
            case 5:
                transhis.transactionhistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        starting();
    }
}