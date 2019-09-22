package enumerations;

public class StrategyEnumPattern {
   enum PayrollDay {
      MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
      SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

      private final PayType payType;

      PayrollDay(PayType payType) {
         this.payType = payType;
      }

      PayrollDay() {
         this(PayType.WEEKDAY);
      }

      int pay(int minutesWorked, int payRate) {
         return payType.pay(minutesWorked, payRate);
      }

      // The strategy enum type
      private enum PayType {
         WEEKDAY {
            int overtimePay(int minsWorked, int payRate) {
               return minsWorked <= MINS_PER_SHIFT ? 0:
                       (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
         },
         WEEKEND {
            int overtimePay(int minsWorked, int payRate) {
               return minsWorked * payRate / 2;
            }
         };

         private static final int MINS_PER_SHIFT = 8 * 60;

         abstract int overtimePay(int mins, int payRate);

         int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
         }
      }
   }
}
