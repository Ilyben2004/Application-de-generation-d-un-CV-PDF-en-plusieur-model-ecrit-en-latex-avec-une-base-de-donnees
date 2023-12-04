package org.example;

public class Experience extends CvCountenu  {

    protected String Position ;
    protected  String Finaldate;

    public Experience(String title, String location, String date, String description, String position, String finaldate) {

        super(title, location, date, description);
        this.Position=position;
        this.Finaldate=finaldate;
        

    }

    public Experience() {
        // TODO Auto-generated constructor stub
    }

    public String getFinaldaAte() {
        return Finaldate;
    }

    public void setFinaldate(String finaldate) {
        this.Finaldate = finaldate;
    }




    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {	
        this.Position = position;
    }
}
