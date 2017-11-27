import java.util.Random;

public class RemovableDevice extends Storage {
    protected Data data = new Data();
    private int size;
    private int id;
    boolean pluggedIn = false;
    Computer pluggedTo;

    public RemovableDevice(int capacity){
        size = capacity;
        id = generateId();
    }

    public int getId(){
        return id;
    }

    public int generateId(){
        Random random = new Random();
        while(true) {
            int id = random.nextInt(999) + 1;
            if (checkId(id)) {
                return id;
            } else {
                continue;
            }
        }
    }

    public boolean checkId(int id){
        for(User user : MainDriver.users){
            for(RemovableDevice device : user.getRemovableDevices()){
                if(device.getId() == id){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void save(String value){
        if(getSpaceLeft() > value.length() && pluggedIn){
            data.addData(value);
            System.out.println("Data Added");
        }
        else{
            System.out.println("No Space Left or Device not plugged in");
        }
    }

    @Override
    public int getSpaceLeft(){
        int diff = size - data.getSize();
        if(diff <= 0){
            return -1;
        }
        return diff;
    }

    public void getDetails(){
        System.out.println("Device " + this.getId() + "Capacity " + this.getSpaceLeft() + "B");
    }

    @Override
    public void format() {
        if(pluggedIn){
            data.clear();
        }
        else{
            System.out.println("Device not plugged in");
        }
    }

    public void plugIn(Computer device){
        if(!pluggedIn){
            pluggedIn = true;
            pluggedTo = device;
            System.out.println("Device plugged in");
        }
        else{
            System.out.println("Device already plugged in to " + pluggedTo.getId());
        }
    }

    public void plugOut(){
        if(pluggedIn){
            pluggedIn = false;
            System.out.println("Device has been plugged out");
        }
        else{
            System.out.println("Device already plugged out");
        }
    }

    public void showData() {
        if(pluggedIn)
            data.show();
        else
            System.out.println("Device not plugged in");
    }
}
