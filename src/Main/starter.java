package Main;

import java.util.ArrayList;
import java.util.Scanner;

import org.jfree.ui.RefineryUtilities;
import AGAT.*;
import shortestJobFirst.*;
import PriorityScheduling.*;
import SRTF.*;

import javax.swing.*;

public class starter implements Runnable {

    @Override
    public void run() {
        PlotWindow Window = null;
        if (GUI.shortestJobFirst.isSelected()) {
            Window = new PlotWindow("shortestJobFirst", new shortestJobFirst().start((ArrayList<Process>) Main.GUI.processes.clone(), Integer.parseInt(GUI.Age.getText())));

        } else if (GUI.PriorityScheduling.isSelected()) {
            Window = new PlotWindow("PriorityScheduling", new PriorityScheduling().start((ArrayList<Process>) Main.GUI.processes.clone(), 1, Integer.parseInt(GUI.Age.getText())));
        } else if (GUI.AGAT.isSelected()) {
            Window = new PlotWindow("AGAT", new AGAT().start((ArrayList<Process>) Main.GUI.processes.clone()));

        } else if (GUI.SRTF.isSelected()) {
            Window = new PlotWindow("SRTF", new SRTF().start((ArrayList<Process>) Main.GUI.processes.clone()));
        } else {
            JOptionPane.showMessageDialog(Window,
                    "Please choose a Scheduler.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        assert Window != null;
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