package org.example;

public class CvCountenu {

    protected String Title ;
    protected String location;
    protected String Date ;

    protected String Descreption ;

    CvCountenu ( String title, String location, String date, String description){
        this.Title=title;
        this.location=location;
        this.Date=date;
        this.Descreption=description;

    }

    CvCountenu(){

    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDescreption() {
        return Descreption;
    }

    public void setDescreption(String descreption) {
        Descreption = descreption;
    }
    
}
