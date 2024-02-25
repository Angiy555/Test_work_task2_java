import java.util.*;

public class Main {
    static ArrayList<Lot> listRaffalLots = new ArrayList<>();
    public static void main(String[] args) {
        boolean shouldExit = false;
        Raffle raffle = new Raffle();
        ArrayList<Lot> listLots = new ArrayList<>();

        while (!shouldExit) {
            View.showMenu();
            System.out.print("Введите операцию от 1 до 6 или 0 для выхода: ");
            String itemMenuString = readConsole();

            switch (itemMenuString) {
                case "0":
                    shouldExit = true;
                    break;
                case "1":
                    raffle.createLot(listLots);
                    System.out.println("Лот добавлен, для продолжения нажмите ENTER");
                    readConsole();
                    break;
                case "2":
                    raffle.createListOfLotteryLots(listLots);
                    System.out.println("Данные добавлены, для продолжения нажмите ENTER");
                    readConsole();
                    break;
                case "3":
                    raffle.changeParametersLot(listLots);
                    System.out.println("Данные изменены, для продолжения нажмите ENTER");
                    readConsole();
                    break;
                case "4":
                    System.out.println(" ");
                    System.out.println("Перечень лотов участвующих в розыгрыше.");
                    System.out.println(" ");
                    raffle.viewingListOfLots(listLots);
                    System.out.println("Для продолжения нажмите ENTER");
                    readConsole();
                    break;
                case "5":
                    raffle.lotLottery(listLots);
                    break;
                case "6":
                    raffle.openRaffledLots();
                    break;
                default:
                    System.out.println("");
                    System.out.println("Введен неверный пункт.");
                    System.out.println("");
                    System.out.print("Нажмите ENTER для продолжения");
                    readConsole();
                    break;
            }
        }
    }

    public static String readConsole(){
        Scanner scanner = new Scanner(System.in);
        String readeLine = scanner.nextLine();
        return readeLine;
    }
}
