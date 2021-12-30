package Main;

import java.io.Serial;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class PlotWindow extends ApplicationFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    public HashMap<Integer, Task> tasks;

    class MyToolTipGenerator extends IntervalCategoryToolTipGenerator {

        DateFormat format;

        private MyToolTipGenerator(String value, DateFormat format) {
            super(value, format);
            this.format = format;
        }

        @Override
        public String generateToolTip(CategoryDataset cds, int row, int col) {
            final String s = super.generateToolTip(cds, row, col);
            TaskSeriesCollection tsc = (TaskSeriesCollection) cds;
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

    public PlotWindow(final String title, ArrayList<duration> processes) {

        super(title);

        GanttCategoryDataset dataset = createDataset(processes);
        JFreeChart chart = createChart(dataset);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(-2);


        ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
        setContentPane(chartPanel);

        //TODO setDefaultCloseOperation of window
        setDefaultCloseOperation(2);
    }

    public GanttCategoryDataset createDataset(ArrayList<duration> processes) {
        tasks = new HashMap<>();

        for (duration process : processes) {
            System.out.println(process.name + " " + process.start + " " + process.end + " " + process.description);
        }

        for (duration process : processes) {
            if (tasks.get(process.id) == null) {
                tasks.put(process.id, new Task(process.name, new SimpleTimePeriod(process.start, process.end)));
                continue;
            }
            Task t = new Task(process.name, new SimpleTimePeriod(process.start, process.end));
            t.setDescription(process.description);
            tasks.get(process.id).addSubtask(t);
        }

        final TaskSeriesCollection collection = new TaskSeriesCollection();
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