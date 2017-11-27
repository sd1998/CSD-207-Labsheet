import java.util.ArrayList;
import java.util.Random;

public class User {
    private String name;
    private int id;
    private ArrayList<RemovableDevice> removableDevices = new ArrayList<RemovableDevice>();
    private ArrayList<Computer> computers = new ArrayList<Computer>();

    public User(String name){
        this.name = name;
        this.id = calculateId();
    }

    public  static int calculateId(){
        while(true) {
            Random random = new Random();
            int id = random.nextInt(999) + 1;
            if(checkId(id)){
                return id;
            }
            else{
                continue;
            }
        }
    }

    public boolean checkDevice(int id){
        for(Computer computer : this.computers){
            if(computer.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Computer getDevice(int id){
        for(Computer computer : computers){
            if(computer.getId() == id){
                return computer;
            }
        }
        return null;
    }

    public RemovableDevice getStorageDevice(int id){
        for(RemovableDevice device : removableDevices){
            if(device.getId() == id){
                return device;
            }
        }
        return null;
    }

    public void addDevice(int deviceType,String processor,int RAM,String motherBoard,int space,int battery){
        switch(deviceType){
            case 1:
                Desktop desktop = new Desktop(processor,RAM,motherBoard,space);
                this.computers.add(desktop);
                break;

            case 2:
                Laptop laptop = new Laptop(processor,RAM,motherBoard,space,battery);
                this.computers.add(laptop);
                break;

            case 3:
                Mobile mobile = new Mobile(processor,RAM,motherBoard,space,battery);
                this.computers.add(mobile);
                break;

            case 4:
                Tab tab = new Tab(processor,RAM,motherBoard,space,battery);
                this.computers.add(tab);
                break;
        }
    }

    public ArrayList<Computer> getComputers(){
        return computers;
    }

    public static User findUserById(int id){
        for(User user : MainDriver.users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public ArrayList<RemovableDevice> getRemovableDevices(){
        return removableDevices;
    }

    public static boolean checkId(int id){
        for(int i = 0;i <= MainDriver.users.size() - 1;i++){
            if(MainDriver.users.get(i).getId() == id){
                return false;
            }
        }
        return true;
    }

    public void addStorage(int type,int capacity){
        if(type == 1){
            USB usb = new USB(capacity);
            removableDevices.add(usb);
            System.out.println("Device id " + usb.getId());
        }
        else{
            ExternalHDD externalHDD = new ExternalHDD(capacity);
            removableDevices.add(externalHDD);
            System.out.println("Device id " + externalHDD.getId());
        }
        System.out.println("Device Added");
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
