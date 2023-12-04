package org.example;

public class Education   extends CvCountenu {

String finale_date;

    public Education(String title, String location, String date, String description,String finale_date) {
        super(title, location , date , description);
        this.finale_date=finale_date;


    }
    Education(){

    }
	public void setFinal_date(String d) {
		// TODO Auto-generated method stub
		this.finale_date=d;
	}
	public String getFinalDate() {
		// TODO Auto-generated method stub
		return this.finale_date;
	}
}
