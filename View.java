public class View {
    //Очистка консоли
    private static void ClearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Вывод страницы меню
    public static void showMenu(){
        ClearConsole();
        System.out.println("============================================================");
        System.out.println("######################      MENU      ######################");
        System.out.println("============================================================");
        System.out.println("    1. Добавить лот в розыгрыш.");
        System.out.println("    2. Добавить лоты в розыгрыша из массива.");
        System.out.println("    3. Изменить данные лота.");
        System.out.println("    4. Показать лоты розыгрыша.");
        System.out.println("    5. Провести розыгрыш.");
        System.out.println("    6. Посмотреть разыгранные лоты.");
        System.out.println("    0. ВЫХОД.");
        System.out.println("============================================================");
    }

    public static void  showMenuChangeLot(){
        ClearConsole();
        System.out.println("============================================================");
        System.out.println("######################      MENU      ######################");
        System.out.println("#############     ИЗМЕНЕНИЯ ПАРАМЕТРОВ ЛОТА      ###########");
        System.out.println("============================================================");
        System.out.println("    1. Изменить название игрушки.");
        System.out.println("    2. Изменить изменить вероятность впадения игрушки.");
        System.out.println("    0. ВЫХОД.");
        System.out.println("============================================================");
    }
}
