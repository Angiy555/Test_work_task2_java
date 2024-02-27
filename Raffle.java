import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Raffle {
    Random random = new Random();
    final String fileName = "Raffled_Lots.txt";
    private ArrayList<Lot> listRaffalLots = new ArrayList<>();
    private ArrayList<Lot> listLots = new ArrayList<>();

    public Raffle(){}

    public void createLot(){
        Lot newLot;
        int chanceOfDrop = random.nextInt(100);
        int maxId = maxId();
        String nameToy = ConsoleInputOutput.getNameOfToy();

        newLot = new Lot(maxId, nameToy, chanceOfDrop);
        listLots.add(newLot);
        ConsoleInputOutput.messageLotAdded();
    }

    public void createListOfLotteryLots(String[] arrayOfToys){
        int maxId = maxId();
        int chanceOfDrop = 0;
        for(int i = 0; i < arrayOfToys.length; i++){
            chanceOfDrop = random.nextInt(100);
            Lot newLot = new Lot(maxId + i, arrayOfToys[i], chanceOfDrop);
            listLots.add(newLot);
        }
        ConsoleInputOutput.messageDataAdded();
    }

    public  void changeParametersLot(){
        if(listLots.isEmpty()){
            ConsoleInputOutput.messageListOfLotsIsEmpty();
            ConsoleInputOutput.messagePressEnter();
            return;
        }
        viewingListOfLots(listLots);
        String numberLot = ConsoleInputOutput.getLotNumber();
        boolean isNumericRange = isInputOfDigitInRangeLotId(numberLot);

        if(isNumericRange){
            int lotId = Integer.parseInt(numberLot);
            int indexChange = indexSearch(lotId);
            boolean shouldExit = false;
            while (!shouldExit) {
                ConsoleInputOutput.showMenuChangeLot();
                String itemMenuString = ConsoleInputOutput.getMenuItemSelection();
                switch (itemMenuString) {
                    case "0":
                        shouldExit = true;
                        break;
                    case "1":
                        changeNameToy(indexChange);
                        ConsoleInputOutput.messageNameToyChanged();
                        break;
                    case "2":
                        changeChanceOfDrop(indexChange);
                        ConsoleInputOutput.messageDataAdded();
                        break;
                    default:
                        ConsoleInputOutput.messageInvalidMenuItem();
                        break;
                }
            }
            ConsoleInputOutput.messageDataChanged();
        }else {
            ConsoleInputOutput.messageInvalidLotNumber();
        }

    }

    public int maxId(){
        int maxId = 0;

        for(Lot item : listLots ){
            if(item.getId() > maxId){
                maxId = item.getId();
            }
        }

        return maxId + 1;
    }

    public int indexSearch(int numberLot){
        int index = 0;
        for(Lot item: listLots){
            if(item.getId() == numberLot){
                index = listLots.indexOf(item);
                break;
            }
        }
        return index;
    }

    public boolean isInputOfDigitInRangeLotId(String numberLot){
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

    public void changeNameToy(int indexChange){
        String nameToy = ConsoleInputOutput.getNewNameToy();
        listLots.get(indexChange).setNameToy(nameToy);
    }

    public  void  changeChanceOfDrop(int indexChange){
        String chanceOfDropString = ConsoleInputOutput.getNewChanceValue();
        boolean isNumericRange = isInputOfDigitInRangeChanceOfDrop(chanceOfDropString);
        if(isNumericRange){
            int chanceOfDropInt = Integer.parseInt(chanceOfDropString);
            listLots.get(indexChange).setChanceOfDrop(chanceOfDropInt);
        }else {
            ConsoleInputOutput.messageEnterIncorrectProbabilityLimit();
        }

    }

    public  void viewingListOfLots(ArrayList<Lot> listLots){
        for(Lot item: listLots){
            ConsoleInputOutput.outputLot(item);
        }
    }

    public  void openLots(){
        if(listLots.isEmpty()){
            ConsoleInputOutput.messageListOfLotsIsEmpty();
            ConsoleInputOutput.messagePressEnter();
        }else{
            ConsoleInputOutput.messageListOfLots();
            viewingListOfLots(listLots);
            ConsoleInputOutput.messagePressEnter();
        }
    }

    public void lotLottery(){
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
        int indexRemove = indexSearch(raffalLot.getId());
        listLots.remove(indexRemove);
        listRaffalLots.add(raffalLot);
        ConsoleInputOutput.messageRaffleLot();
        ConsoleInputOutput.outputLot(raffalLot);

        saveRaffledLotToFile(raffalLot);

        ConsoleInputOutput.messagePressEnter();
    }

    public void saveRaffledLotToFile(Lot raffalLot){
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.write(raffalLot.toString() + "\n");
            ConsoleInputOutput.messageLotWriteToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openRaffledLots(){
        if(listRaffalLots.isEmpty()){
            ConsoleInputOutput.messageListOfLotsIsEmpty();
            ConsoleInputOutput.messagePressEnter();
        }else{
            ConsoleInputOutput.messageRaffledLots();
            viewingListOfLots(listRaffalLots);
            ConsoleInputOutput.messagePressEnter();
        }
    }
}
