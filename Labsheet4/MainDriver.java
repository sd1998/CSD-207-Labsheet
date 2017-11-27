import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainDriver {
    public static ArrayList<User> users = new ArrayList<User>();
    public static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while(true){
        System.out.println("1. New User");
        System.out.println("2. Existing User");
        System.out.println("3. Exit");
        System.out.println("Select your choice");
        int choice = Integer.parseInt(buffer.readLine());
        switch (choice) {
            case 1:
                System.out.println("Enter your name");
                String name = buffer.readLine();
                User newUser = new User(name);
                System.out.println("The id assigned to you is " + newUser.getId());
                showUserMenu(newUser);
                break;

            case 2:
                System.out.println("Enter your userId");
                int id = Integer.parseInt(buffer.readLine());
                if (User.checkId(id)) {
                    User existingUser = User.findUserById(id);
                    showUserMenu(existingUser);
                } else {
                    System.out.println("No such user found");
                }
                break;

            case 3:
                break;

            default:
                System.out.println("Select a valid option");
        }
        if (choice == 3) {
            break;
        }
    }
    }

    public static void showUserMenu(User user) throws IOException{
        while(true){
            System.out.println("1. Add Device");
            System.out.println("2. Select Device");
            System.out.println("3. Add Storage");
            System.out.println("4. Select Storage");
            System.out.println("5. Exit");
            System.out.println("Select your option");
            int choice = Integer.parseInt(buffer.readLine());
            switch(choice){
                case 1:
                    while(true) {
                        System.out.println("Select device type");
                        System.out.println("1. Desktop");
                        System.out.println("2. Laptop");
                        System.out.println("3. Mobile");
                        System.out.println("4. Tab");
                        System.out.println("5. Exit");
                        System.out.println("Select your choice");
                        int choice1 = Integer.parseInt(buffer.readLine());
                        if(choice1 == 5){
                            break;
                        }
                        if(choice1 < 1 || choice1 > 5){
                            System.out.println("Select a valid option");
                            continue;
                        }
                        System.out.println("Enter processor Name");
                        String processorName = buffer.readLine();
                        System.out.println("Enter Ram Size");
                        int RAM = Integer.parseInt(buffer.readLine());
                        System.out.println("Enter motherboard Name");
                        String motherboardName = buffer.readLine();
                        System.out.println("Enter Storage size in bytes");
                        int space = Integer.parseInt(buffer.readLine());
                        if(choice1 == 1){
                            user.addDevice(1,processorName,RAM,motherboardName,space,0);
                        }
                        else{
                            System.out.println("Enter battery percent");
                            int battery = Integer.parseInt(buffer.readLine());
                            user.addDevice(choice,processorName,RAM,motherboardName,space,battery);
                        }
                    }
                    break;

                case 2:
                    System.out.println("Enter your device id");
                    int id = Integer.parseInt(buffer.readLine());
                    if(user.checkDevice(id)) {
                        showDeviceMenu(user, id);
                    }
                    else{
                        System.out.println("You have no such device");
                    }
                    break;

                case 3:
                    System.out.println("Select storage type");
                    System.out.println("1. USB");
                    System.out.println("2. External HDD");
                    int choice1 = Integer.parseInt(buffer.readLine());
                    System.out.println("Enter capacity in Bytes");
                    int capacity = Integer.parseInt(buffer.readLine());
                    if(choice1 == 1){
                        user.addStorage(choice1,capacity);
                    }
                    else if(choice1 == 2){
                        user.addStorage(choice1,capacity);
                    }
                    else{
                        System.out.println("Select a valid choice");
                    }
                    break;

                case 4:
                    System.out.println("Enter the id of the storage device");
                    int storageId = Integer.parseInt(buffer.readLine());
                    showStorageMenu(user, storageId);
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Select a valid option");
            }
            if(choice == 5){
                break;
            }
        }
    }

    public static void showStorageMenu(User user,int id) throws IOException{
        RemovableDevice removableDevice = user.getStorageDevice(id);
        if(removableDevice == null){
            System.out.println("No such device exists");
            return;
        }
        while(true){
            System.out.println("1. Plug In");
            System.out.println("2. Plug Out");
            System.out.println("3. Write");
            System.out.println("4. Read");
            System.out.println("5. Format");
            System.out.println("6. Exit");
            System.out.println("Select your option");
            int choice = Integer.parseInt(buffer.readLine());
            switch(choice){
                case 1:
                    System.out.println("Enter device id");
                    int deviceId = Integer.parseInt(buffer.readLine());
                    if(user.checkDevice(deviceId)){
                        Computer device = user.getDevice(id);
                        removableDevice.plugIn(device);
                    }
                    else{
                        System.out.println("No such Device exists");
                    }
                    break;

                case 2:
                    removableDevice.plugOut();
                    break;

                case 3:
                    System.out.println("Enter data to be stored");
                    String data = buffer.readLine();
                    removableDevice.save(data);
                    break;

                case 4:
                    removableDevice.showData();
                    break;

                case 5:
                    removableDevice.format();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Enter a valid choice");
            }
            if(choice == 6){
                break;
            }
        }
    }

    public static void showDeviceMenu(User user,int id) throws IOException{
        Computer device = user.getDevice(id);
        while(true){
            System.out.println("1. Turn on/off");
            System.out.println("2. Volume Up");
            System.out.println("3. Volume Down");
            System.out.println("4. Read Data");
            System.out.println("5. Write Data");
            System.out.println("6. Charge");
            System.out.println("7. Exit");
            System.out.println("Select your option");
            int choice = Integer.parseInt(buffer.readLine());
            switch(choice){
                case 1:
                    device.turnOnOff();
                    break;

                case 2:
                    device.volumeUp();
                    break;

                case 3:
                    device.volumeDown();
                    break;

                case 4:
                    device.getContent();
                    break;

                case 5:
                    System.out.println("Enter data to be stored");
                    String data = buffer.readLine();
                    device.save(data);
                    break;

                case 6:
                    charge(device);
                    break;

                case 7:
                    break;

                default:
                    System.out.println("Select a valid option");
            }
            if(choice == 7){
                break;
            }
        }
    }

    public static void charge(Computer device){
        if(!(device instanceof Desktop)){
            if(device instanceof Laptop){
                Laptop laptop = (Laptop) device;
                laptop.charge();
            }
            else if(device instanceof Mobile){
                Mobile mobile = (Mobile) device;
                mobile.charge();
            }
            else if(device instanceof Tab){
                Tab tab = (Tab) device;
                tab.charge();
            }
        }
    }

}
