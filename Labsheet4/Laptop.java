public class Laptop extends Computer implements Charger {
    private int battery;

    public Laptop(String processor,int RAM,String motherBoard,int space,int battery){
        super(processor,RAM,motherBoard,space);
        this.battery = battery;
    }

    @Override
    public void getDetails(){
        System.out.println("Device Type Laptop");
        super.getDetails();
    }

    @Override
    public void charge(){
        if(battery < 100){
            System.out.println("Laptop is charging");
            battery = battery + 10;
            System.out.println("Current battery satus");
            this.getBattery();
        }
        else{
            System.out.println("The Laptop is fully charged");
        }
    }

    @Override
    public void getBattery(){
        this.lowBattery();
        System.out.print(" " + battery);
    }

    @Override
    public void lowBattery(){
        if(battery < 10){
            System.out.println("Battery is low Please charge");
        }
    }

}
