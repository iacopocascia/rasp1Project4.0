package com.pawm.project.rasp1Project40.model;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="temp_humi_press")
public class raspModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_temp_humi_press;

    private Date date;

    private int temp;

    private int humi;

    private int press;



    @Override
    public String toString() {
        return "raspModel{" +
                "idTempHumiPress=" + id_temp_humi_press +
                ", date=" + date +
                ", temp=" + temp +
                ", humi=" + humi +
                ", press=" + press +
                ", hour=" + this.getHours() +
                ", minutes=" + this.getMinutes() +
                ", month=" + this.getMonth() +
                ", day=" + this.getDay()+
                '}';
    }

    public Integer getId_temp_humi_press() {
        return id_temp_humi_press;
    }

    public void setId_temp_humi_press(Integer id_temp_humi_press) {
        this.id_temp_humi_press = id_temp_humi_press;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getHumi() {
        return humi;
    }

    public void setHumi(int humi) {
        this.humi = humi;
    }

    public int getPress() {
        return press;
    }

    public void setPress(int press) {
        this.press = press;
    }

    public String getHours(){
        Calendar cal= Calendar.getInstance();
        cal.setTime(this.date);
        return String.format("%02d",cal.get(Calendar.HOUR_OF_DAY));
    }
    public String getMinutes(){
        Calendar cal= Calendar.getInstance();
        cal.setTime(this.date);
        return String.format("%02d",cal.get(Calendar.MINUTE));
    }
    public String getMonth(){
        Calendar cal= Calendar.getInstance();
        cal.setTime(this.date);
        int month=cal.get(Calendar.MONTH);
        return String.format("%02d",++month);

    }
    public String getDay(){
        Calendar cal= Calendar.getInstance();
        cal.setTime(this.date);
        return String.format("%02d",cal.get(Calendar.DAY_OF_MONTH));
    }
}