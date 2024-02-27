import java.util.Scanner;

public class ConsoleInputOutput {
    //Очистка консоли
    private static void ClearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Чтение из консоли
    public static String readConsole(){
        Scanner scanner = new Scanner(System.in);
        String readeLine = scanner.nextLine();
        return readeLine;
    }

    //Вывод страницы меню
    public static void showMenu(){
        ClearConsole();
        System.out.println("============================================================");
        System.out.println("######################      MENU      ######################");
        System.out.println("============================================================");
        System.out.println("    1. Добавить лот в розыгрыш.");
        System.out.println("    2. Добавить лоты в розыгрыш из массива.");
        System.out.println("    3. Изменить данные лота.");
        System.out.println("    4. Показать лоты розыгрыша.");
        System.out.println("    5. Провести розыгрыш.");
        System.out.println("    6. Посмотреть разыгранные лоты.");
        System.out.println("    0. ВЫХОД.");
        System.out.println("============================================================");
    }

    //Вывод страницы меню изменение параметров лота
    public static void  showMenuChangeLot(){
        ClearConsole();
        System.out.println("============================================================");
        System.out.println("######################      MENU      ######################");
        System.out.println("#############     ИЗМЕНЕНИЯ ПАРАМЕТРОВ ЛОТА      ###########");
        System.out.println("============================================================");
        System.out.println("    1. Изменить название игрушки.");
        System.out.println("    2. Изменить вероятность выпадения игрушки.");
        System.out.println("    0. ВЫХОД.");
        System.out.println("============================================================");
    }

    public static String getNameOfToy(){
        System.out.print("Введите название игрушки: ");
        return readConsole();
    }

    public static String getLotNumber(){
        System.out.println(" ");
        System.out.print("Введите номер лота для изменения: ");
        return readConsole();
    }

    public static String getNewNameToy(){
        System.out.print("Введите новое название игрушки: ");
        return readConsole();
    }

    public static String getNewChanceValue(){
        System.out.print("Введите новое значение шанса выпадения игрушки: ");
        return readConsole();
    }

    public static void messageEnterIncorrectProbabilityLimit(){
        System.out.print("Введен неверный предел вероятности. Нажмите ENTER для продолжения.");
        readConsole();
    }

    public static void messageInvalidMenuItem(){
        System.out.println("");
        System.out.println("Введен неверный пункт.");
        System.out.println("");
        System.out.print("Нажмите ENTER для продолжения");
        readConsole();
    }

    public static void messagePressEnter(){
        System.out.println("Для продолжения нажмите ENTER");
        readConsole();
    }

    public static void messageListOfLots(){
        System.out.println(" ");
        System.out.println("Перечень лотов участвующих в розыгрыше.");
        System.out.println(" ");
    }

    public static void messageDataChanged(){
        System.out.println("Данные изменены, для продолжения нажмите ENTER");
        readConsole();
    }

    public static void messageDataAdded(){
        System.out.println("Данные добавлены, для продолжения нажмите ENTER");
        readConsole();
    }

    public static void messageLotAdded(){
        System.out.println("Лот добавлен, для продолжения нажмите ENTER");
        readConsole();
    }

    public static String getMenuItemSelection(){
        System.out.print("Введите пункт меню: ");
        return readConsole();
    }

    public static void messageNameToyChanged(){
        System.out.print("Название игрушки изменено, для продолжения нажмите ENTER");
        readConsole();
    }

    public static void messageInvalidLotNumber(){
        System.out.print("Введен неверный номер лота. Нажмите ENTER для продолжения.");
        readConsole();
    }

    public static void messageListOfLotsIsEmpty(){
        System.out.println("Список лотов пуст. Данные не вводились.");
    }

    public static void messageLotWriteToFile(){
        System.out.println("Лот записан в файл");
    }

    public static void messageRaffledLots(){
        System.out.println("Разыгранные лоты:");
    }

    public static void messageRaffleLot(){
        System.out.println("Разыгран:");
    }

    public static void outputLot(Lot lot){
        System.out.println(lot);
    }
}
