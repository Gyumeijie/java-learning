package multithread.synchronization;

public class DepositThread implements Runnable {
   private Account mAccount;
   private Integer mAmount;

   public DepositThread(Account account, Integer amount) {
      this.mAccount = account;
      this.mAmount = amount;
   }

   @Override
   public void run() {
      // Make a deposit
      mAccount.deposit(mAmount);
   }
}
