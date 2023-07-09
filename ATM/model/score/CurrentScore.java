package ATM.model.score;

import ATM.model.account.Account;
import ATM.model.constants.Constants;
import ATM.model.money.Money;

public class CurrentScore extends Score {
    private DebetScore debetScore;

    public CurrentScore(Money balance, Account owner, Integer
            number, DebetScore debetScore) {
        super(balance, owner, number);
        this.debetScore = debetScore;
    }

    public void addMoney(Money money) {
        double usdValueIn = money.getValue() *
                money.getCurrency().getUsdCource();
        double usdValueThis = getBalance().getValue() *
                getBalance().getCurrency().getUsdCource();

        if (usdValueIn > Constants.BONUS_DEPOSIT_AMOUNT) {
            getBalance().setValue(usdValueThis + Constants.BONUS + usdValueIn);
            return;
        } else {
            System.out.println("No bonus!");
            return;
        }
    }
}
