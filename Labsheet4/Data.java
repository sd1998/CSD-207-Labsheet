import java.util.ArrayList;

public class Data {
    private ArrayList<String> dataStored = new ArrayList<String>();

    public void addData(String value){
        dataStored.add(value);
    }

    public int getSize(){
        int size = 0;
        for(String data : dataStored){
            size = size + data.length();
        }
        return size;
    }

    public void clear(){
        dataStored.clear();
        System.out.println("Data has been cleared");
    }

    public void show(){
        if(dataStored.size() == 0){
            System.out.println("No Data Stored");
        }
        else{
            for(String data : dataStored){
                System.out.println(data);
            }
        }
    }
}
