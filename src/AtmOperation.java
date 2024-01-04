import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AtmOperation implements ATMoperationInterface {

  ATM atm = new ATM();
  List<String> status = new ArrayList<String>();
  List<LocalDateTime> transactionTime = new ArrayList<LocalDateTime>();
  List<Double> amountTrack = new ArrayList<Double>();
  List<Double> runningAmount = new ArrayList<Double>();

  @Override
  public void depositAmount(double depositAmount) {
    System.out.println(depositAmount + " Deposited Successfully!");
    atm.setBalance(atm.getBalance() + depositAmount);
    status.add("Deposited");
    transactionTime.add(LocalDateTime.now());
    amountTrack.add(depositAmount);
    runningAmount.add(atm.getBalance());
    viewBalance();
  }

  @Override
  public void viewBalance() {
    System.out.println("Available Balance is : " + atm.getBalance());
    System.out.println();
  }

  @Override
  public void viewMiniStatement() {
    System.out.printf(
      "%-20s%-20s%-20s%-20s%-20s%n",
      "Sl.No",
      "Date/Time",
      "Description",
      "Transaction Amount",
      "Total Amount"
    );
    if (transactionTime.size() == 0) {
      System.out.println("No Transaction Found!");
    } else {
      int i = 0;
      for (LocalDateTime t : transactionTime) {
        double transactionAmount = amountTrack.get(i);
        String transactionType = status.get(i);
        double runningTotal = runningAmount.get(i);
        i++;

        System.out.printf(
          "%-20s%-20s%-20s%-20s%-20s%n",
          i,
          t.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
          transactionType,
          transactionAmount,
          runningTotal
        );
      }
    }
    System.out.println();
  }

  @Override
  public void withdrawAmount(double withdrawAmount) {
    if (withdrawAmount < atm.getBalance()) {
      System.out.println("Collect the cash " + withdrawAmount);
      amountTrack.add(withdrawAmount);
      status.add("Amount Withdrawn");
      atm.setBalance(atm.getBalance() - withdrawAmount);
      runningAmount.add(atm.getBalance());
      transactionTime.add(LocalDateTime.now());
    } else {
      try {
        throw new InsufficientBalanceException("Insufficient Balance");
      } catch (InsufficientBalanceException e) {
        System.out.println(e.getMessage());
        System.out.println("------------------");
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    viewBalance();
  }
}
