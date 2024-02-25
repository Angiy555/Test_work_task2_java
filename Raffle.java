import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Raffle {
    Random random = new Random();
    private String[] arrayOfToys = {"Мишка", "Чебурашка", "Ракета", "Кукла", "Конструктор", "Вертолет", "Танк", "Лото", "Зайчик", "Собачка"};
    int quantity = 1;
    String fileName = "Raffled_Lots.txt";

    public Raffle(){}

    public void createLot(ArrayList<Lot> listLots){
        Lot newLot;
        int chanceOfDrop = random.nextInt(100);
        int maxId = maxId(listLots);

        System.out.print("Введите название игрушки: ");
        String nameToy = Main.readConsole();

        newLot = new Lot(maxId, nameToy, quantity, chanceOfDrop);
        listLots.add(newLot);
    }

    public void createListOfLotteryLots(ArrayList<Lot> listLots){
        int maxId = maxId(listLots);
        int chanceOfDrop = 0;
        for(int i = 0; i < arrayOfToys.length; i++){
            chanceOfDrop = random.nextInt(100);
            Lot newLot = new Lot(maxId + i, arrayOfToys[i], quantity, chanceOfDrop);
            listLots.add(newLot);
        }
    }

    public  void changeParametersLot(ArrayList<Lot> listLots){
        System.out.print("Перечень лотов участвующих в розыгрыше.");
        System.out.println(" ");
        viewingListOfLots(listLots);
        System.out.println(" ");
        System.out.print("Введите номер лота для изменения: ");
        String numberLot = Main.readConsole();
        boolean isNumericRange = isInputOfDigitInRangeLotId(listLots, numberLot);

        if(isNumericRange){
            int lotId = Integer.parseInt(numberLot);
            int indexChange = indexSearch(listLots, lotId);
            boolean shouldExit = false;
            while (!shouldExit) {
                View.showMenuChangeLot();
                System.out.print("Введите операцию от 1 до 2 или 0 для выхода: ");
                String itemMenuString = Main.readConsole();
                switch (itemMenuString) {
                    case "0":
                        shouldExit = true;
                        break;
                    case "1":
                        changeNameToy(listLots, indexChange);
                        System.out.print("Название игрушки изменено, для продолжения нажмите ENTER");
                        Main.readConsole();
                        break;
                    case "2":
                        changeChanceOfDrop(listLots, indexChange);
                        System.out.print("Данные добавлены, для продолжения нажмите ENTER");
                        Main.readConsole();
                        break;
                    default:
                        System.out.println("");
                        System.out.print("Введен неверный пункт.");
                        System.out.println("");
                        System.out.print("Нажмите ENTER для продолжения");
                        Main.readConsole();
                        break;
                }
            }
        }else {
            System.out.print("Введен неверный номер лота. Нажмите ENTER для продолжения.");
            Main.readConsole();
        }

    }

    public int maxId(ArrayList<Lot> listLotse){
        int maxId = 1;
        if(listLotse.isEmpty()){
            return maxId;
        }else{
            for(Lot item : listLotse ){
                if(item.getId() > maxId){
                    maxId = item.getId();
                }
            }
            return maxId + 1;
        }
    }

    public int indexSearch(ArrayList<Lot> listLots, int numberLot){
        int index = 0;
        int count = 0;
        for(Lot item: listLots){
            if(item.getId() == numberLot){
                index = count;
                break;
            }
            count++;
        }
        return  index;
    }

    public boolean isInputOfDigitInRangeLotId(ArrayList<Lot> listLots, String numberLot){
        if(!numberLot.matches("-?\\d+")) return false;
        int number = Integer.parseInt(numberLot);
        for(Lot item: listLots){
            if(item.getId() == number){
                return true;
            }
        }
        return false;
    }

    public boolean isInputOfDigitInRangeChanceOfDrop(String chanceOfDropString){
        if(!chanceOfDropString.matches("-?\\d+")) return false;
        int number = Integer.parseInt(chanceOfDropString);
        if(number >= 0 && number <=100){
            return true;
        }
        return false;
    }

    public void changeNameToy(ArrayList<Lot> listLots, int indexChange){
        System.out.print("Введите новое название игрушки: ");
        String nameToy = Main.readConsole();
        listLots.get(indexChange).setNameToy(nameToy);
    }

    public  void  changeChanceOfDrop(ArrayList<Lot> listLots, int indexChange){
        System.out.print("Введите новое значение шанса выпадения игрушки: ");
        String chanceOfDropString = Main.readConsole();
        boolean isNumericRange = isInputOfDigitInRangeChanceOfDrop(chanceOfDropString);
        if(isNumericRange){
            int chanceOfDropInt = Integer.parseInt(chanceOfDropString);
            listLots.get(indexChange).setChanceOfDrop(chanceOfDropInt);
        }else {
            System.out.print("Введен неверный предел вероятности. Нажмите ENTER для продолжения.");
            Main.readConsole();
        }

    }

    public  void viewingListOfLots(ArrayList<Lot> listLots){
        for(Lot item: listLots){
            System.out.println(item);
        }
    }

    public void lotLottery(ArrayList<Lot> listLots){
        Lot raffalLot;
        Queue<Lot> lotsPriorityQueue = new PriorityQueue<>(new Comparator<Lot>() {
            @Override
            public int compare(Lot o1, Lot o2) {
                return o2.getChanceOfDrop() - o1.getChanceOfDrop();
            };
        });

        for (Lot item: listLots){
            lotsPriorityQueue.add(item);
        }
        raffalLot = lotsPriorityQueue.poll();
        int indexRemove = indexSearch(listLots,raffalLot.getId());
        listLots.remove(indexRemove);
        Main.listRaffalLots.add(raffalLot);
        System.out.println("Разыгран:");
        System.out.println(raffalLot);

        saveRaffledLotToFile(raffalLot);

        System.out.print("Нажмите ENTER для продолжения.");
        Main.readConsole();
    }

    public void saveRaffledLotToFile(Lot raffalLot){
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.write(raffalLot.toString() + "\n");
            System.out.println("Лот записан в файл");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openRaffledLots(){
        System.out.println("Разыгранные лоты:");
        viewingListOfLots(Main.listRaffalLots);
        System.out.print("Нажмите ENTER для продолжения.");
        Main.readConsole();
    }
}
