package runtimeTerror.autoCare.model.blog;


import runtimeTerror.autoCare.model.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
public class WorkshopReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String body;
    long timeNow = new Date().getTime();
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String rate;
    public WorkshopReview() {
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public WorkshopReview(String body, Timestamp createdAt, User user) {
        this.body = body;
        this.createdAt = createdAt;
        this.user = user;
    }

    public WorkshopReview(String body, Timestamp createdAt) {
        this.body = body;
        this.createdAt = createdAt;
    }
    public String getTimeNow() {

        String time = "";

        long defTime = new Date().getTime() - timeNow;
        if(defTime < 1000*60){
            time = TimeUnit.MILLISECONDS.toSeconds(defTime) + " seconds ago";
        }

        else if(defTime < 1000*60*60){
            time =  TimeUnit.MILLISECONDS.toMinutes(defTime) + " minutes ago";
        }

        else if(defTime < 1000*60*60*60){
            time = TimeUnit.MILLISECONDS.toHours(defTime) + " hours ago";
        }

        else if(defTime < (long) 1000*60*60*60*24){
            time = TimeUnit.MILLISECONDS.toDays(defTime) + " days ago";
        }

        return time;
    }

    public void setTimeNow(long timeNow) {
        this.timeNow = timeNow;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
    }
}
