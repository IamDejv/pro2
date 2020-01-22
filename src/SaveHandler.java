import java.io.*;
import java.util.List;

public class SaveHandler {
    private static String filename = "timetable";

    public static void save(List<Item> data){
        try(PrintWriter w = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"))){
            for(Item item : data){
                w.print(item.getDay());
                w.print(";");
                w.print(item.getStart());
                w.print(";");
                w.print(item.getEnd());
                w.print(";");
                w.print(item.getShortcut());
                w.print(";");
                w.print(item.getName());
                w.print(";");
                w.print(item.getType());
                w.print(";");
                w.print(item.getRoom());
                w.print(";");
                w.print(item.getTeacher());
                w.println();
            }
        } catch (FileNotFoundException e ){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    public static List<Item> load(){
        Data data = new Data();
        List<Item> itemList = data.getData();
        try(BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))){
            String line;
            while((line = r.readLine()) != null){
                String[] parts = line.split(";");
                itemList.add(new Item(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7]));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return itemList;
    }
}
