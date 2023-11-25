package lotto;

import lotto.domain.LottoGame;
import lotto.domain.PrizeStatus;
import lotto.view.InputView;

import java.util.List;

import static lotto.view.OutputView.*;
import static lotto.view.InputView.*;

public class LottoPlayApplication {
    public LottoPlayApplication() {
    }

    public static void main (String [] arg) {

        int purchasedAmt = InputView.getAmountOfPurchase();
        int numOfManualTickets = getNumOfManualTicket();
        int numOfTickets = (purchasedAmt / 1000) - numOfManualTickets;
        List<String []> manualLottoTickets = getManualLottoTickets(numOfManualTickets);

        LottoGame lottoGame = new LottoGame(numOfTickets, manualLottoTickets);

        displayLottoTickets(lottoGame.tickets());

        displayWinnerNumbers(lottoGame.winnerNumbers());
        int bonusBall = InputView.getBonusBall();
        lottoGame.winnerNumbers().throwBonusBall(bonusBall);

        PrizeStatus prizeStatus = lottoGame.processResult();
        displayResult(prizeStatus, purchasedAmt);
    }
}
