public class Tab extends Computer implements Charger {
    private int battery;

    public Tab(String processor,int RAM,String motherBoard,int space,int battery){
        super(processor,RAM,motherBoard,space);
        this.battery = battery;
    }

    @Override
    public void getDetails(){
        System.out.println("Device Type Tab");
        super.getDetails();
    }

    @Override
    public void charge(){
        if(battery < 100){
            System.out.println("Tab is charging");
            battery = battery + 10;
            System.out.println("Current battery satus");
            this.getBattery();
        }
        else{
            System.out.println("The Tab is fully charged");
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
