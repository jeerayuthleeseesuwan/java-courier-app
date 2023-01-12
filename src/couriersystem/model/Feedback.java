/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package couriersystem.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jeera
 */
public class Feedback {
    private String id;
    private String packageId;
    private int rating;
    private String comment;
    private String feedbackBy;
    private Date date;

    
    public static ArrayList<Feedback> getListOfFeedbacks(){
        ArrayList<Feedback> feedbacks = new ArrayList<>();
        try{
            File myFile = new File(GlobalConfig.dbPath + "Feedback.txt");
            Scanner sc = new Scanner(myFile);
            String row;
            Feedback feedback;
            while(sc.hasNext()){
                row = sc.nextLine();
                String [] values = row.split("__");
                //Parse Date
                Date date;
                try{
                    date = GlobalConfig.feedbackDateFormat.parse(values[5]);
                } catch (Exception ex){
                    date = null;
                }
                feedback = new Feedback(
                        values[0],
                        values[1],
                        Integer.parseInt(values[2]),
                        values[3],
                        values[4],
                        date
                );
                feedbacks.add(feedback);
            }
            sc.close();
        }
        catch(IOException ex){
            
        }
        return feedbacks;
    }
    
    public String toOneLineString(){
        return String.join("__",  id, packageId, Integer.toString(rating), comment, feedbackBy, GlobalConfig.feedbackDateFormat.format(date));
    }

    public Feedback(String id, String packageId, int rating, String comment, String feedbackBy, Date date) {
        this.id = id;
        this.packageId = packageId;
        this.rating = rating;
        this.comment = comment;
        this.feedbackBy = feedbackBy;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getPackageId() {
        return packageId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getFeedbackBy() {
        return feedbackBy;
    }
    
    public Date getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setFeedbackBy(String feedbackBy) {
        this.feedbackBy = feedbackBy;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
