/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package couriersystem;

import couriersystem.model.Feedback;
import couriersystem.model.Order;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author jeera
 */
public class Report {
    public Report (){}
    
    public void generateBarChart(String reportType){
        DefaultCategoryDataset dataset;
        JFreeChart chart = null;
        
        if (reportType.equals("Total Feedbacks by Month")){
            //Get list of orders from text file
            ArrayList<Feedback> listOfFeedbacks = Feedback.getListOfFeedbacks();
            int[] totalOrderByMonth = new int[12];
            
            //Group orders by month
            for (Feedback feedback : listOfFeedbacks){
                Calendar c = Calendar.getInstance();
                c.setTime(feedback.getDate());
                totalOrderByMonth[c.get(Calendar.MONTH) - 1] += 1;
            }

            //Setup data points
            dataset = new DefaultCategoryDataset();
            dataset.setValue(totalOrderByMonth[0], "Orders", "January");
            dataset.setValue(totalOrderByMonth[1], "Orders", "February");
            dataset.setValue(totalOrderByMonth[2], "Orders", "March");
            dataset.setValue(totalOrderByMonth[3], "Orders", "April");
            dataset.setValue(totalOrderByMonth[4], "Orders", "May");
            dataset.setValue(totalOrderByMonth[5], "Orders", "June");
            dataset.setValue(totalOrderByMonth[6], "Orders", "July");
            dataset.setValue(totalOrderByMonth[7], "Orders", "August");
            dataset.setValue(totalOrderByMonth[8], "Orders", "September");
            dataset.setValue(totalOrderByMonth[9], "Orders", "October");
            dataset.setValue(totalOrderByMonth[10], "Orders", "November");
            dataset.setValue(totalOrderByMonth[11], "Orders", "December");
            
            chart = ChartFactory.createBarChart("Feedback Report", "Month", "Number of Feedbacks", dataset, PlotOrientation.VERTICAL, false, true, false);
        } 
        else if (reportType.equals("Total Orders by Month")){
            //Get list of orders from text file
            ArrayList<Order> listOfOrders = Order.getListOfOrders();
            int[] totalOrderByMonth = new int[12];
            
            //Group orders by month
            for (Order order : listOfOrders){
                Calendar c = Calendar.getInstance();
                c.setTime(order.getOrderDate());
                totalOrderByMonth[c.get(Calendar.MONTH) - 1] += 1;
            }

            //Setup data points
            dataset = new DefaultCategoryDataset();
            dataset.setValue(totalOrderByMonth[0], "Orders", "January");
            dataset.setValue(totalOrderByMonth[1], "Orders", "February");
            dataset.setValue(totalOrderByMonth[2], "Orders", "March");
            dataset.setValue(totalOrderByMonth[3], "Orders", "April");
            dataset.setValue(totalOrderByMonth[4], "Orders", "May");
            dataset.setValue(totalOrderByMonth[5], "Orders", "June");
            dataset.setValue(totalOrderByMonth[6], "Orders", "July");
            dataset.setValue(totalOrderByMonth[7], "Orders", "August");
            dataset.setValue(totalOrderByMonth[8], "Orders", "September");
            dataset.setValue(totalOrderByMonth[9], "Orders", "October");
            dataset.setValue(totalOrderByMonth[10], "Orders", "November");
            dataset.setValue(totalOrderByMonth[11], "Orders", "December");
            
            chart = ChartFactory.createBarChart("Total Orders Report", "Month", "Number of Orders", dataset, PlotOrientation.VERTICAL, false, true, false);
        }
        else {
            //Get list of orders from text file
            ArrayList<Order> listOfOrders = Order.getListOfOrders();
            int[] totalOrderByStatus = new int[4];
            
            //Group orders by month
            for (Order order : listOfOrders){
                Calendar c = Calendar.getInstance();
                c.setTime(order.getOrderDate());
                if (order.getStatus().equals("Processing"))
                    totalOrderByStatus[0] += 1;
                else if (order.getStatus().equals("Out For Delivery"))
                    totalOrderByStatus[1] += 1;
                else if (order.getStatus().equals("Delivered"))
                    totalOrderByStatus[2] += 1;
                else if (order.getStatus().equals("Cancelled"))
                    totalOrderByStatus[3] += 1;
            }

            //Setup data points
            dataset = new DefaultCategoryDataset();
            dataset.setValue(totalOrderByStatus[0], "Orders", "Processing");
            dataset.setValue(totalOrderByStatus[1], "Orders", "Out For Delivery");
            dataset.setValue(totalOrderByStatus[2], "Orders", "Delivered");
            dataset.setValue(totalOrderByStatus[3], "Orders", "Cancelled");
            
            chart = ChartFactory.createBarChart("Total Orders by Status Report", "Status", "Number of Orders", dataset, PlotOrientation.VERTICAL, false, true, false);
        }
        
        //Generate Chart
        if(chart != null) {
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Bar Chart for Orders", chart);
            frame.setVisible(true);
            frame.setSize(450,350);
        }
    }
}
