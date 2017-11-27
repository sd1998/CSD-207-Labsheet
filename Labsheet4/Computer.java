import java.util.Random;

public class Computer {
    private int id;
    private String processor;
    private String motherBoard;
    private int RAM;
    private boolean on = false;
    private int volume = 50;
    private Internal storage;

    public Computer(String processorName,int RAM,String motherBoardName,int availableSpace){
        this.processor = processorName;
        this.RAM = RAM;
        this.motherBoard = motherBoardName;
        this.storage = new Internal(availableSpace);
        this.id = calculateId();
        System.out.println("The id given to the device is " + this.id);
    }

    public void save(String text) {
        storage.save(text);
        System.out.println("Data Saved");
    }

    public void getContent(){
        storage.showData();
    }



    public int calculateId(){
        while(true){
            Random random = new Random();
            int id = random.nextInt(9999) + 1;
            if(checkId(id)){
                return id;
            }
            else
            {
                continue;
            }
        }
    }

    public int getId(){
        return id;
    }

    public void turnOnOff(){
        if(on){
            on = false;
            System.out.println("Computer has been turned off");
        }
        else{
            on = true;
            System.out.println("Computer has been turned on");
        }
    }

    public void getDetails(){
        System.out.println("Processor " + processor);
        System.out.println("RAM " + RAM);
        System.out.println("MotherBoard " + motherBoard);
    }

    public void volumeUp(){
        if(volume >= 100){
            System.out.println("Maximum volume reached");
            return;
        }
        else{
            volume = volume + 10;
        }
    }

    public void volumeDown(){
        if(volume <= 0){
            System.out.println("No Volume");
            return;
        }
        else{
            volume = volume - 10;
        }
    }

    public boolean checkId(int id){
        for(User user : MainDriver.users){
            for(Computer computer : user.getComputers()){
                if(computer.getId() == id){
                    return false;
                }
            }
        }
        return true;
    }

}
