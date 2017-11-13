public class Desktop extends Computer {

    public Desktop(String processor,int RAM,String motherBoard,int space){
        super(processor,RAM,motherBoard,space);
    }

    @Override
    public void getDetails(){
        System.out.println("Device Type Desktop");
        super.getDetails();
    }
}
