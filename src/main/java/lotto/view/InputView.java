package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getAmountOfPurchase() {
        return scanner.nextInt();
    }
}
