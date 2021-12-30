package Main;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.gantt.GanttCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.io.Serial;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class PlotWindow extends ApplicationFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    static class MyToolTipGenerator extends IntervalCategoryToolTipGenerator {

        DateFormat format;

        private MyToolTipGenerator(String value, DateFormat format) {
            super(value, format);
            this.format = format;
        }

        @Override
        public String generateToolTip(CategoryDataset cds, int row, int col) {
            final String s = super.generateToolTip(cds, row, col);
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

    public PlotWindow(final String title, ArrayList<duration> processes) {

        super(title);
        int averageWait = 0;
        int averageTurnaround = 0;
        HashMap<Integer, Boolean> occurred = new HashMap<>();
        for (duration Duration : processes) {
            if (occurred.get(Duration.id) == null) {
                int wait = Duration.start - Duration.arrivalTime;
                averageWait += wait;
                averageTurnaround += (wait + Duration.burstTime);
                System.out.println(Duration.name + " ,Waiting Time :" + wait + " ,Turnaround Time :" + (wait + Duration.burstTime));
                occurred.put(Duration.id, true);
            }
        }
        System.out.println("The average waiting is : " + (averageWait / processes.size()));
        System.out.println("The average Turnaround is : " + (averageTurnaround / processes.size()));

        GanttCategoryDataset dataset = createDataset(processes);
        JFreeChart chart = createChart(dataset);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(-2);


        ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
        setContentPane(chartPanel);

        //TODO setDefaultCloseOperation of window
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public GanttCategoryDataset createDataset(ArrayList<duration> processes) {
        HashMap<Integer, Task> tasks = new HashMap<>();

        for (duration process : processes) {
            System.out.println(process.name + " " + process.start + " " + process.end + " " + process.description);
        }

        for (duration process : processes) {
            if (tasks.get(process.id) == null) {
                tasks.put(process.id, new Task(process.name, new SimpleTimePeriod(0, processes.get(processes.size() - 1).end)));
            }
            Task t = new Task(process.name, new SimpleTimePeriod(process.start, process.end));
            t.setDescription(process.name);
            tasks.get(process.id).addSubtask(t);
        }

        TaskSeriesCollection collection = new TaskSeriesCollection();
        tasks.forEach((K, V) -> {
            TaskSeries t = new TaskSeries(V.getDescription());
            t.add(V);
            collection.add(t);
        });
        return collection;
    }

    private JFreeChart createChart(GanttCategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createGanttChart(
                "CPU Usage",
                "processes",
                "Time",
                dataset,
                true,
                true,
                false
        );

        CategoryPlot plot = chart.getCategoryPlot();

        plot.getRenderer().setDefaultToolTipGenerator(
                new MyToolTipGenerator(
                        "{0}, {1}: ", DateFormat.getTimeInstance(DateFormat.SHORT)));

        DateAxis axis = (DateAxis) plot.getRangeAxis();

        axis.setDateFormatOverride(new SimpleDateFormat("S"));
        return chart;
    }

}