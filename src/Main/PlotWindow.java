package Main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.gantt.GanttCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.ui.ApplicationFrame;

public class PlotWindow extends ApplicationFrame {

    private static final long serialVersionUID = 1L;

    public HashMap<String, Task> tasks;

    public PlotWindow(final String title, ArrayList<duration> processes) {

        super(title);

        final GanttCategoryDataset dataset = createDataset(processes);
        final JFreeChart chart = createChart(dataset);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(-2);
        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
        setContentPane(chartPanel);

    }

    public GanttCategoryDataset createDataset(ArrayList<duration> processes) {
        tasks = new HashMap<>();
        for (int i = 0; i < processes.size(); i++) {
            if (tasks.get(processes.get(i).name) != null) {
                tasks.get(processes.get(i).name).addSubtask(new Task(processes.get(i).name, new SimpleTimePeriod(processes.get(i).start, processes.get(i).end)));
            } else {
                tasks.put(processes.get(i).name, new Task(processes.get(i).name, new SimpleTimePeriod(processes.get(i).start, processes.get(i).end)));
            }
        }


        final TaskSeriesCollection collection = new TaskSeriesCollection();
        tasks.forEach((K, V) -> {
            TaskSeries t = new TaskSeries(K);
            t.add(V);
            collection.add(t);
        });
        return collection;
    }

    private JFreeChart createChart(final GanttCategoryDataset dataset) {
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

        DateAxis axis = (DateAxis) plot.getRangeAxis();

        axis.setDateFormatOverride(new SimpleDateFormat("S"));
        return chart;
    }

}