package multithread.synchronization;

public class WithdrawThread implements Runnable {
   private Account mAccount;
   private Integer mAmount;

   public WithdrawThread(Account account, Integer amount) {
      this.mAccount = account;
      this.mAmount = amount;
   }

   @Override
   public void run() {
      // Make a withdraw
      mAccount.withdraw(mAmount);
   }
}
