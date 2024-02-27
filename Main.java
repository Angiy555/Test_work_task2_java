public class Main {
    public static void main(String[] args) {
        boolean shouldExit = false;
        Raffle raffle = new Raffle();

        while (!shouldExit) {
            ConsoleInputOutput.showMenu();
            ConsoleInputOutput.messageMenuItemSelection();
            String itemMenuString = ConsoleInputOutput.readConsole();

            switch (itemMenuString) {
                case "0":
                    shouldExit = true;
                    break;
                case "1":
                    raffle.createLot();
                    break;
                case "2":
                    raffle.createListOfLotteryLots();
                    break;
                case "3":
                    raffle.changeParametersLot();
                    break;
                case "4":
                    raffle.openLots();
                    break;
                case "5":
                    raffle.lotLottery();
                    break;
                case "6":
                    raffle.openRaffledLots();
                    break;
                default:
                    ConsoleInputOutput.messageInvalidMenuItem();
                    break;
            }
        }
    }
}
