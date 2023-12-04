package org.example;

public class Projects extends CvCountenu  {

    protected String Link ;

    public Projects (String title, String location, String date, String description , String link) {
        super(title, location , date , description);
        this.Link=link;

    }
	public Projects() {
		
	}
	
	public void setLink(String l) {
		this.Link= l ;
	}
	public String getLink() {
		// TODO Auto-generated method stub
		return this.Link;
	}
}