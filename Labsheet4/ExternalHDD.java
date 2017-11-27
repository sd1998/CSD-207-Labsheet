public class ExternalHDD extends RemovableDevice {
    public ExternalHDD(int capacity) {
        super(capacity);
    }

    @Override
    public void getDetails() {
        System.out.println("Device Type: External HDD");
        super.getDetails();
    }
}
