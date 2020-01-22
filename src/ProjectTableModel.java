import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProjectTableModel extends AbstractTableModel {

    private List<Item> data;
    private String [] header = {"Den","Začátek","Konec","Zkratka", "Název", "Typ Akce", "Místnost", "Učitel"};

    public void setData(Data data) {
        this.data = data.getData();
        fireTableDataChanged();
    }

    public String[] getHeader() {
        return header;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = data.get(rowIndex);
        String value = item.getByIndex(columnIndex);
        return value;
    }
}
