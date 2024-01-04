import java.util.Scanner;

public class main {

  public static void main(String[] args) throws Exception {
    int ATMNUMBER_ = 12345;
    int ATMPIN_ = 123;
    ATMoperationInterface op = new AtmOperation();

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter ATM number : ");
    int atmNumber = sc.nextInt();

    if (ATMNUMBER_ == atmNumber) {
      System.out.println("Enter Pin");
      int atmPin = sc.nextInt();
      if (ATMPIN_ == atmPin) {
        do {
          System.out.println(
            "1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Statement\n5.Exit"
          );
          System.out.println("Enter Choice : ");
          int choice = sc.nextInt();
          switch (choice) {
            case 1:
              op.viewBalance();
              break;
            case 2:
              System.out.println("Enter amount to be withdraw ");
              double withdrawAmount = sc.nextDouble();
              op.withdrawAmount(withdrawAmount);
              break;
            case 3:
              System.out.println("Enter Amount to Deposit :");
              double depositAmount = sc.nextDouble();
              op.depositAmount(depositAmount);
              break;
            case 4:op.viewMiniStatement();
              break;
            case 5:
              System.out.println(
                "Collect your ATM Card\nThank you for using ATM Machine!!"
              );
              System.exit(0);
              break;
            default:
              System.out.println("Wrong Choice");
              break;
          }
        } while (true);
      } else {
        System.out.println("Incorrect Atm pin");
        System.exit(0);
      }
    } else {
      System.out.println("Incorrect Atm Number");
      System.exit(0);
    }
  }
}
