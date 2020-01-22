import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class MainFrame extends JFrame {


    JPanel inputPanel = new JPanel(new FlowLayout());
    JPanel downPanel = new JPanel(new FlowLayout());
    JTextField inputSubject = new JTextField();
    JTextField inputCatedra = new JTextField();
    JButton search = new JButton("Vyhledej");
    JButton save = new JButton("Uložit");
    JButton load = new JButton("Načíst");
    JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    JLabel lblSubject = new JLabel("Zkratka předmětu: ");
    JLabel lblCatedra = new JLabel("Zkratka Katedry: ");
    JLabel lblTimeLecture = new JLabel("Celkový počet přednášek: ");
    JLabel lblTimeLec = new JLabel("0");
    JLabel lblTimePractice = new JLabel("Celkový počet cvičení: ");
    JLabel lblTimePrac = new JLabel("0");
    JLabel lblTotalTime = new JLabel("Celkový počet hodin: ");
    JLabel lblTimeTotal = new JLabel("0");
    ProjectTableModel tableModel = new ProjectTableModel();

    public MainFrame(){
        initFrame();
        initUI();
    }

    private void initFrame(){
        setSize(1280,720);
        setTitle("Name for Project");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(new BorderLayout());
    }

    private void initUI(){
        lblTimePrac.setPreferredSize(new Dimension(50,25));
        lblTimeLec.setPreferredSize(new Dimension(50,25));
        lblTimeTotal.setPreferredSize(new Dimension(50,25));
        inputSubject.setPreferredSize(new Dimension(200,25));
        inputCatedra.setPreferredSize(new Dimension(200,25));
        inputPanel.add(lblSubject);
        inputPanel.add(inputSubject);
        inputPanel.add(lblCatedra);
        inputPanel.add(inputCatedra);
        inputPanel.add(search);
        downPanel.add(lblTotalTime);
        downPanel.add(lblTimeTotal);
        downPanel.add(lblTimeLecture);
        downPanel.add(lblTimeLec);
        downPanel.add(lblTimePractice);
        downPanel.add(lblTimePrac);
        downPanel.add(save);
        downPanel.add(load);
        add(downPanel, BorderLayout.SOUTH);
        add(inputPanel,BorderLayout.NORTH);
        add(scrollPane,BorderLayout.CENTER);


        search.addActionListener(e->{
            String subject = inputSubject.getText().toUpperCase().trim();
            String catedra = inputCatedra.getText().toUpperCase().trim();
            Data data = ItemHandler.getItem(subject,catedra);
            setUI(data);
        });
        save.addActionListener(e->{
            SaveHandler.save(tableModel.getData());
            System.out.println("Uloženo");
        });
        load.addActionListener(e->{
            Data data = new Data();
            data.setData(SaveHandler.load());
            setUI(data);
            System.out.println("Načteno");
        });
    }

    public void setUI(Data data){
        tableModel.setData(data);
        table.setModel(tableModel);
        lblTimeLec.setText(data.getTotalTime("Přednáška"));
        lblTimeTotal.setText(data.getTotalTime("all"));
        lblTimePrac.setText(data.getTotalTime("Cvičení"));
        String[] header = tableModel.getHeader();
        for(int i = 0; i < tableModel.getColumnCount(); i++){
            table.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(header[i]);
        }
    }

}
