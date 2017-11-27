public class Internal extends Storage {
private Data data = new Data();
private int size;

public Internal(int maxSize){
    this.size = maxSize;
}

@Override
    public void save(String value){
    if(getSpaceLeft() > value.length()){
        data.addData(value);
        System.out.println("Data Saved");
    }
    else{
        System.out.println("No Space Available");
    }
}

@Override
public int getSpaceLeft(){
        int diff = size - data.getSize();
        if(diff <=0 ){
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
