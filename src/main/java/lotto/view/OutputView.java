package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.PrizeStatus;
import lotto.domain.WinnerNumbers;

import java.util.List;

public class OutputView {

    public static void displayNumberOfPurchasedTickets(int amountOfPurchase) {
        System.out.println(amountOfPurchase/1000+"개를 구매했습니다.");
    }

    public static void displayLottoTickets(List<LottoTicket> tickets) {
        tickets.forEach(lottoTicket -> {
            System.out.println(lottoTicket.toString());
        });
    }

    public static void displayWinnerNumbers(WinnerNumbers winnerNumbers) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        System.out.println(winnerNumbers.toString());
    }

    public static void displayPrizeStatMessage() {
        System.out.println("당첨 통계");
        System.out.println("-------------");
    }

    public static void displayPrizeStatus(PrizeStatus prizeStatus) {
        System.out.println("3개 일치 (5000원)- "+prizeStatus.getCurrentNumOfPrize(3, false));
        System.out.println("4개 일치 (50000원)- "+prizeStatus.getCurrentNumOfPrize(4, false));
        System.out.println("5개 일치 (1500000원)- "+prizeStatus.getCurrentNumOfPrize(5, false));
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- "+prizeStatus.getCurrentNumOfPrize(5, true));
        System.out.println("6개 일치 (2000000000원)- "+prizeStatus.getCurrentNumOfPrize(6, false));
    }

    public static void displayProfit(double profit) {
        System.out.println("총 수익률은 "+profit+"입니다.");
    }

    public static void displayResult(PrizeStatus prizeStatus, int purchasedAmt) {
        displayPrizeStatMessage();
        displayPrizeStatus(prizeStatus);
        displayProfit(prizeStatus.calculateProfit(purchasedAmt));
    }
}
