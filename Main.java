import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean shouldExit = false;
        View viewInterfes = new View();

        while (!shouldExit) {
            //вывод меню
            viewInterfes.showMenu();
            System.out.print("Введите операцию от 1 до 3 или 0 для выхода: ");
            String itemMenuString = readConsole();

            switch (itemMenuString) {
                case "0":
                    shouldExit = true;
                    break;
                case "1":
                    shouldExit = true;
                    break;
                case "2":
                    shouldExit = true;
                    break;
                case "3":
                    shouldExit = true;
                    break;
                case "4":
                    shouldExit = true;
                    break;
                default:
                    System.out.println("");
                    System.out.println("Введен неверный пункт.");
                    System.out.println("");
                    System.out.print("Нажмите ENTER для продолжения ");
                    readConsole();
                    break;
            }
        }
    }

    //Чтение из консоли
    static String readConsole(){
        Scanner scanner = new Scanner(System.in);
        String readeLine = scanner.nextLine();
        return readeLine;
    }
}
