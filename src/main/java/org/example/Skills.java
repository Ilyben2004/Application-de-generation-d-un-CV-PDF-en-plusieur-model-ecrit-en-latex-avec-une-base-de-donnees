package org.example;

public class Skills {
    protected String skill;
    protected String type; // To indicate the type of skill (e.g., "language", "technical", "hobby")

    public Skills(String type, String skill) {
        this.skill = skill;
        this.type = type;
    }


    public Skills() {
        // TODO Auto-generated constructor stub
    }





    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}