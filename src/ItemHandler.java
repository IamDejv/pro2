import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ItemHandler {


    public static Data getItem(String shortcut, String catedra){
        String resourceUrl = String.format("https://stag-demo.uhk.cz/ws/services/rest2/rozvrhy/getRozvrhByPredmet?jenBudouciAkce=true&zkratka=%s&outputFormat=CSV&katedra=%s", shortcut,catedra);
        Data data = new Data();
        getHttp(resourceUrl, data);
        return data;
    }

    public static void getHttp(String resourceUrl, Data data){
        boolean first = false;
        try{
            URL url = new URL(resourceUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            try(BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"Windows-1250"))){
                StringBuilder response = new StringBuilder();
                String line;

                while((line = in.readLine()) != null){
                    String [] parts = line.split(";");
                    Teacher teacher = new Teacher();
                    teacher.setId(parts[6].replace("\"",""));
                    teacher.setFirstname(parts[7].replace("\"",""));
                    teacher.setLastname(parts[8].replace("\"",""));
                    teacher.setFirstTitle(parts[9].replace("\"",""));
                    teacher.setLastTitle(parts[10].replace("\"",""));
                    Item item = new Item();
                    item.setName(parts[1].replace("\"",""));
                    item.setShortcut(parts[3].replace("\"",""));
                    item.setTeacher(teacher.getFullName().replace("\"",""));
                    item.setRoom(parts[16].replace("\"",""));
                    item.setType(parts[20].replace("\"",""));
                    item.setDay(parts[24].replace("\"",""));
                    item.setStart(parts[29].replace("\"",""));
                    item.setEnd(parts[30].replace("\"",""));
                    if (first){
                        data.addData(item);
                    } else {
                        first = true;
                    }

                }

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
