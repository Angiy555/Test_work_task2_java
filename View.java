public class View {
    //Очистка консоли
    private void ClearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Вывод страницы меню
    public void showMenu(){
        ClearConsole();
        System.out.println("============================================================");
        System.out.println("######################      MENU      ######################");
        System.out.println("============================================================");
        System.out.println("    1. Добавить лот в розыгрыш.");
        System.out.println("    2. Изменить данные лота.");
        System.out.println("    3. Показать лоты розыгрыша.");
        System.out.println("    4. Провести розыгрыш.");
        System.out.println("    0. ВЫХОД.");
        System.out.println("============================================================");
    }
}
