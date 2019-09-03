package multithread.synchronization;

public class Account {
   private Integer mBalance = 0;

   public Account(Integer balance) {
      this.mBalance = balance;
   }

   public void deposit(Integer amount) {
      if (amount < 0) {
         throw new IllegalArgumentException("Can't deposit.");
      }
      this.mBalance += amount;
      System.out.println("Deposit " + amount + " in thread"
              + Thread.currentThread().getName()
              + ", balance is " + mBalance);
   }

   public void withdraw(Integer amount) {
      if (amount < 0 || amount > this.mBalance) {
         throw new IllegalArgumentException("Can't withdraw");
      }
      this.mBalance -= amount;
      System.out.println("Withdraw " + amount + " in thread "
              + Thread.currentThread().getId()
              + ", balance is " + mBalance);
   }
}
