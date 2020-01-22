import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Item> data;

    public Data(){
        data = new ArrayList<>();
    }

    public void addData(Item item){
        data.add(item);
    }

    public List<Item> getData() {
        return data;
    }

    public String getTotalTime(String type){
        int totalTime = 0;
        if("all".equals(type.toLowerCase())){
            for (Item action : data){
                if(!"".equals(action.getDay()) && !"den".equals(action.getDay())){
                    totalTime++;
                }
            }
        } else {
            for(Item action : data){
                if(action.getType().equals(type) && !"".equals(action.getDay())){
                    totalTime++;
                }
            }
        }
        return String.format("%d", totalTime);

    }
}
