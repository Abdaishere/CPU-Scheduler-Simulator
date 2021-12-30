package Main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
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

    JLabel size = new JLabel("Age");
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

        this.add(leftSide);

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


        processes_list.setHorizontalTextPosition(JLabel.CENTER);
        processes_list.setVerticalTextPosition(JLabel.TOP);

        start.setBounds(540, 370, 150, 70);
        start.setBackground(new Color(0xe6e6e6));
        start.add(size);

        start.add(text1);
        text1.setPreferredSize(new Dimension(100, 20));
        start.setBorder(lineBorder);
        run.setPreferredSize(new Dimension(60, 20));
        start.add(run);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == run) {

        }
    }

    public static void main(String[] args) {
        JFrame GUi = new GUI();
    }
}
