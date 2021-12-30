package Main;

import org.jfree.ui.tabbedui.VerticalLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProcess extends JFrame implements ActionListener {
    private JButton addButton = new JButton("Add");
    private JTextField Name = new JTextField();
    private JTextField arrivalTime = new JTextField();
    private JTextField burstTime = new JTextField();
    private JTextField priorityNumber = new JTextField();
    private JTextField quantum = new JTextField();
    private JPanel main = new JPanel();

    AddProcess() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0xe6e6e6));
        this.setTitle("Add Process");

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setResizable(false);

        this.add(main);
        main.add(new JLabel("Name"));
        Name.setPreferredSize(new Dimension(110, 20));
        main.add(Name);

        main.add(new JLabel("Arrival Time"));
        arrivalTime.setPreferredSize(new Dimension(110, 20));
        main.add(arrivalTime);

        main.add(new JLabel("Burst Time"));
        burstTime.setPreferredSize(new Dimension(110, 20));
        main.add(burstTime);

        main.add(new JLabel("Priority Number"));
        priorityNumber.setPreferredSize(new Dimension(110, 20));
        main.add(priorityNumber);

        main.add(new JLabel("Quantum"));
        quantum.setPreferredSize(new Dimension(110, 20));
        main.add(quantum);

        addButton.setPreferredSize(new Dimension(110, 20));
        main.add(addButton);

        addButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Process tmp = new Process(Name.getText(), Integer.parseInt(arrivalTime.getText()), Integer.parseInt(burstTime.getText()), Integer.parseInt(priorityNumber.getText()), Integer.parseInt(quantum.getText()), GUI.processes.size());
        GUI.processes.add(tmp);

        Name.setText("");
        arrivalTime.setText("");
        burstTime.setText("");
        priorityNumber.setText("");
        quantum.setText("");

        DefaultTableModel model = (DefaultTableModel) GUI.processtable.getModel();
        model.addRow(tmp.getData());
    }
}
