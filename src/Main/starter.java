package Main;

import AGAT.AGAT;
import PriorityScheduling.PriorityScheduling;
import SRTF.SRTF;
import shortestJobFirst.shortestJobFirst;

import javax.swing.*;
import java.util.ArrayList;

/*
TODO Processes execution order
TODO Waiting Time for each process
TODO Turnaround Time for each process
TODO Average Waiting Time
TODO Average Turnaround Time
TODO Print all history update of quantum time for each process (AGAT Scheduling)
TODO Print all history update of AGAT factor for each process (AGAT Scheduling)
 */

public class starter {

    public static ArrayList<Process> processes = new ArrayList<>();

    public static void run() {
        PlotWindow Window = null;
        ArrayList<Process> processes1 = new ArrayList<>();
//        processes1.add(new Process("p1", 0, 7, 4, 4, 0));
//        processes1.add(new Process("P2", 2, 4, 9, 3, 1));
//        processes1.add(new Process("P3", 4, 1, 3, 5, 2));
//        processes1.add(new Process("P4", 5, 4, 8, 2, 3));

        for (Process p : processes) {
            processes1.add(p.clone());
        }
        if (GUI.shortestJobFirst.isSelected()) {
            Window = new PlotWindow("shortestJobFirst", new shortestJobFirst().start(processes1, Integer.parseInt(GUI.Age.getText())));
        } else if (GUI.PriorityScheduling.isSelected()) {
            Window = new PlotWindow("PriorityScheduling", new PriorityScheduling().start(processes1, 1, Integer.parseInt(GUI.Age.getText())));
        } else if (GUI.AGAT.isSelected()) {
            Window = new PlotWindow("AGAT", new AGAT().start(processes1));
        } else if (GUI.SRTF.isSelected()) {
            Window = new PlotWindow("SRTF", new SRTF().start(processes1));
        } else {
            JOptionPane.showMessageDialog(Window,
                    "Please choose a Scheduler.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        Window.setVisible(true);
        Window.pack();
        Window.setLocationRelativeTo(null);
        Window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

}
//4
//        P1 0 17 4 4
//        P2 3 6 9 3
//        P3 4 10 3 5
//        P4 29 4 8 2