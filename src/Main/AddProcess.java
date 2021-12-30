package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProcess extends JFrame implements ActionListener {
    private JButton addButton;
    private JTextField Name;
    private JTextField arrivalTime;
    private JTextField burstTime;
    private JTextField priorityNumber;
    private JTextField quantum;

    AddProcess(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Process tmp = new Process(Name.getText(), Integer.parseInt(arrivalTime.getText()), Integer.parseInt(burstTime.getText()), Integer.parseInt(priorityNumber.getText()), Integer.parseInt(quantum.getText()), GUI.processes.size());
        GUI.processes.add(tmp);
        DefaultTableModel model = (DefaultTableModel) GUI.processtable.getModel();
        model.addRow(tmp.getData());
    }
}
