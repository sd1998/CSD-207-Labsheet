public class External extends Storage {
   private Data data = new Data();
   int size;

   public External(int capacity){
       size = capacity;
   }

   @Override
    public void save(String value){
       if(getSpaceLeft() > value.length()){
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

    @Override
    public void format(){
        data.clear();
    }

    public void showData(){
        data.show();
    }

}
