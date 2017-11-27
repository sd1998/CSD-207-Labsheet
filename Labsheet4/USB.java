public class USB extends RemovableDevice {
    public USB(int capacity){
        super(capacity);
    }

    @Override
    public void getDetails(){
        System.out.println("Device Type :- USB");
        super.getDetails();
    }

}
