package Main;

import org.jfree.ui.tabbedui.VerticalLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {

    public static ArrayList<Process> processes = new ArrayList<>();

    JButton source_file = new JButton("Source");
    JButton destination = new JButton("Destination");
    JPanel leftSide = new JPanel();
    JLabel processes_list = new JLabel("Processes list");
    JPanel rightSide = new JPanel();
    JLabel Options = new JLabel("Options");

    JButton Add = new JButton("+");
    JButton Del = new JButton("-");
    JPanel process = new JPanel();
    JPanel start = new JPanel();

    ButtonGroup Algorithm = new ButtonGroup();

    JRadioButton AGAT = new JRadioButton("AGAT");
    JRadioButton PriorityScheduling = new JRadioButton("Priority Scheduling");
    JRadioButton shortestJobFirst = new JRadioButton("Shortest Job First");
    JRadioButton SRTF = new JRadioButton("Shortest-Remaining Time First");
    JPanel Algs = new JPanel();
    JList<Process> Processes = new JList<>();

    static String[] col = {"PID", "Name", "Arrival", "Burst", "Priority", "Quantum"};
    public static JTable processtable = new JTable(new DefaultTableModel(null, col));
    JLabel Age = new JLabel("Age");
    JTextField text1 = new JTextField("32");
    JButton run = new JButton("Run");

    Border lineBorder = BorderFactory.createLineBorder(Color.gray);

    GUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(true);
        this.setSize(815, 520);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0xe6e6e6));
        this.setTitle("CPU Scheduler Simulator");
        this.add(process);

        JPanel sourceblock = new JPanel();
        JPanel destinationblock = new JPanel();
        source_file.addActionListener(this);
        destination.addActionListener(this);

        this.setLayout(null);
        this.setResizable(false);
        this.add(sourceblock);
        this.add(destinationblock);

        leftSide.add(processtable);
        this.add(leftSide);
//        Name = name;
//        this.arrivalTime = arrivalTime;
//        this.burstTime = burstTime;
//        this.priorityNumber = priorityNumber;
//        this.quantum = quantum;
//        this.PID = PID;

//        processtable.getColumnModel().getColumn(0).setHeaderValue("PID");
//        processtable.getColumnModel().getColumn(1).setHeaderValue("Name");
//        processtable.getColumnModel().getColumn(2).setHeaderValue("Arrival");
//        processtable.getColumnModel().getColumn(3).setHeaderValue("Priority");
//        processtable.getColumnModel().getColumn(4).setHeaderValue("Quantum");


        Add.setPreferredSize(new Dimension(45, 20));
        Del.setPreferredSize(new Dimension(45, 20));
        process.add(Add);
        process.add(Del);
        process.setBackground(Color.white);
        process.setBounds(16, 16, 100, 25);

        leftSide.setBounds(15, 15, 385, 455);
        leftSide.setBackground(Color.white);
        leftSide.add(processes_list);
        leftSide.setBorder(lineBorder);


        this.add(start);
        this.add(rightSide);
        rightSide.setBounds(415, 15, 385, 455);
        rightSide.setBackground(new Color(0xe6e6e6));
        rightSide.add(Options);


//        processes_list.setHorizontalTextPosition(JLabel.CENTER);
//        processes_list.setVerticalTextPosition(JLabel.TOP);


        start.setBounds(500, 170, 200, 200);

        start.setBackground(new Color(0xe6e6e6));
        Algs.setBackground(new Color(0xe6e6e6));
        shortestJobFirst.setBackground(new Color(0xe6e6e6));
        PriorityScheduling.setBackground(new Color(0xe6e6e6));
        AGAT.setBackground(new Color(0xe6e6e6));
        SRTF.setBackground(new Color(0xe6e6e6));

        Algorithm.add(shortestJobFirst);
        Algorithm.add(PriorityScheduling);
        Algorithm.add(AGAT);
        Algorithm.add(SRTF);

        Algs.setLayout(new VerticalLayout());
        Algs.add(shortestJobFirst);
        Algs.add(PriorityScheduling);
        Algs.add(AGAT);
        Algs.add(SRTF);

        start.add(Algs);

        start.add(Age);

        start.add(text1);
        text1.setPreferredSize(new Dimension(110, 20));
        start.setBorder(lineBorder);
        run.setPreferredSize(new Dimension(60, 20));
        start.add(run);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == run) {

        } else if (e.getSource() == Add) {
            AddProcess frameText = new AddProcess();
            frameText.setVisible(true);
            frameText.pack();
            frameText.setLocationRelativeTo(null);
            frameText.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        JFrame GUi = new GUI();
    }
}
