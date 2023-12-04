package org.example;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.Scanner;


public class Personne {
    int id;
    private String firstName;
    private String lastName;
    private String email ;
    private String numberPhone;
    private String linkden;
    private String imageName;
    private String foonction;
    
    protected ArrayList<Projects> projects = new ArrayList<Projects>();
    protected ArrayList<Experience> experience = new ArrayList<Experience>();
    protected ArrayList<Skills > skills  = new ArrayList<Skills>();
    protected ArrayList<Education > education  = new ArrayList<Education>();




    // ********************************* Ayman partie ***********************************//
    public Personne(String firstName, String lastName, String foonction, String email, String numberPhone, String linkedin, String imageName) {
        this.id=1;

        this.firstName = firstName;
        this.lastName = lastName;
        this.foonction = foonction;
        this.email = email;
        this.numberPhone = numberPhone;
        this.linkden = linkedin;
        this.imageName = imageName;
    }

    public Personne() {
        // TODO Auto-generated constructor stub
    }

    public void insertPersonne() {
        try {
            sqlConntroler dbController = new sqlConntroler();

            String getId = "SELECT MAX(id) as last_id FROM personne";

            try {
                Statement statement = dbController.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(getId);
                if (resultSet.next()) {
                    setId(resultSet.getInt("last_id")+1) ;
                }




            } catch (SQLException e) {
                e.printStackTrace();
            }

            String insertQuery = "INSERT INTO personne (firstName, lastName, Foonction, email, numberPhone, linkden, imageName) " +
                    "VALUES (?, ?, ?, ?, ?, ?,?)";
            PreparedStatement preparedStatement = dbController.getConnection().prepareStatement(insertQuery);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, foonction);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, numberPhone);
            preparedStatement.setString(6, linkden);
            preparedStatement.setString(7, imageName);
            preparedStatement.executeUpdate();

            insertQuery = "INSERT INTO education (Title, location, Date,End_date, Description, id_personne) " +
                    "VALUES (?, ?, ?, ?, ?,?)";
            preparedStatement = dbController.getConnection().prepareStatement(insertQuery);
            for (Education elt : education) {
                preparedStatement.setString(1, elt.Title);
                preparedStatement.setString(2, elt.location);
                preparedStatement.setString(3, elt.Date);
                preparedStatement.setString(4, elt.finale_date);
                preparedStatement.setString(5, elt.Descreption);
                preparedStatement.setLong(6, this.id);
                preparedStatement.executeUpdate();
            }

            insertQuery = "INSERT INTO project (Title, Link, Location, Date, Description, id_personne) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = dbController.getConnection().prepareStatement(insertQuery);
            for (Projects elt : projects) {
                preparedStatement.setString(1, elt.Title);
                preparedStatement.setString(2, elt.Link);
                preparedStatement.setString(3, elt.location);
                preparedStatement.setString(4, elt.Date);
                preparedStatement.setString(5, elt.Descreption);
                preparedStatement.setLong(6, this.id);
                preparedStatement.executeUpdate();
            }

            insertQuery = "INSERT INTO experience (Position, FinalDate, title, Location, Date, Description, id_personne) VALUES (?, ?, ?, ?, ?, ?,?) ";
            preparedStatement = dbController.getConnection().prepareStatement(insertQuery);
            for (Experience elt : experience) {
                preparedStatement.setString(1, elt.Position);
                preparedStatement.setString(2, elt.Finaldate);
                preparedStatement.setString(3, elt.Title);
                preparedStatement.setString(4, elt.location);
                preparedStatement.setString(5, elt.Date);
                preparedStatement.setString(6, elt.Descreption);
                preparedStatement.setLong(7, this.id);
                preparedStatement.executeUpdate();
            }

            insertQuery = "INSERT INTO skills (skill, type, id_personne) " + "VALUES (?, ?, ?)";
            preparedStatement = dbController.getConnection().prepareStatement(insertQuery);
            for (Skills elt : skills) {
                preparedStatement.setString(1, elt.getSkill());
                preparedStatement.setString(2, elt.getType());
                preparedStatement.setLong(3, this.id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getCvCreated() {
        sqlConntroler dbController = new sqlConntroler();
        String selectQuery = "SELECT filename FROM Cv";
        List<String> resultStrings = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = dbController.getConnection().prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String stringValue = resultSet.getString("filename");
                resultStrings.add(stringValue);
            }
            int i = 1;
            System.out.println("  ");
            for (String stringValue : resultStrings) {
                System.out.println("-> CV (" + i + ") : " + stringValue);
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Personne getPersonneByCvFilename(int idcv) {
        sqlConntroler dbController = new sqlConntroler();
        Personne personne = new Personne();
        long idPersonne = 0;

        try {
            String selectQuery = "SELECT * FROM personne WHERE id = (SELECT id_personne FROM cv WHERE id_cv = ?)";
            PreparedStatement preparedStatement = dbController.getConnection().prepareStatement(selectQuery);
            preparedStatement.setLong(1, idcv);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                idPersonne = resultSet.getLong("id");
                personne.setId( (int) idPersonne);
                personne.setFirstName(resultSet.getString("firstName"));
                personne.setLastName(resultSet.getString("lastName"));
                personne.setFoonction(resultSet.getString("Foonction"));
                personne.setEmail(resultSet.getString("email")); 
                personne.setNumberPhone(resultSet.getString("numberPhone"));
                personne.setLinkedin(resultSet.getString("linkden"));
                personne.setImageName(resultSet.getString("imageName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String selectQuery = "SELECT Title, location, Date, END_date , Description FROM education WHERE id_personne = ?";
            PreparedStatement educationStatement = dbController.getConnection().prepareStatement(selectQuery);
            
            educationStatement.setLong(1, idPersonne);

            ResultSet educationResultSet = educationStatement.executeQuery();

            while (educationResultSet.next()) {
                Education education = new Education();
                education.setTitle(educationResultSet.getString("Title"));
                education.setLocation(educationResultSet.getString("location"));
                education.setDate(educationResultSet.getString("Date"));
                education.setFinal_date(educationResultSet.getString("END_date"));
                education.setDescreption(educationResultSet.getString("Description"));

                personne.addEducation(education);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String selectQuery = "SELECT FinalDate, Title, Location, Date, Description, Position FROM experience WHERE id_personne = ?";
            PreparedStatement experienceStatement = dbController.getConnection().prepareStatement(selectQuery);
            experienceStatement.setLong(1, idPersonne);

            ResultSet experienceResultSet = experienceStatement.executeQuery();

            while (experienceResultSet.next()) {
                Experience exprenince = new Experience();
                
                exprenince.setFinaldate(experienceResultSet.getString("FinalDate"));
                exprenince.setTitle(experienceResultSet.getString("Title"));
                exprenince.setLocation(experienceResultSet.getString("Location"));
                exprenince.setDate(experienceResultSet.getString("Date"));
                exprenince.setDescreption(experienceResultSet.getString("Description"));
                exprenince.setPosition(experienceResultSet.getString("Position"));
                
                personne.addExperience(exprenince);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            String selectQuery = "SELECT Link, Title, Location, Date, Description FROM project WHERE id_personne = ?";
            PreparedStatement projectStatement = dbController.getConnection().prepareStatement(selectQuery);
            projectStatement.setLong(1, idPersonne);

            ResultSet projectResultSet = projectStatement.executeQuery();

            while (projectResultSet.next()) {
                Projects project= new Projects();
                
                project.setLink(projectResultSet.getString("Link"));
                project.setTitle(projectResultSet.getString("Title"));
                project.setLocation(projectResultSet.getString("Location"));
                project.setDate(projectResultSet.getString("Date"));
                project.setDescreption(projectResultSet.getString("Description"));


                personne.addProject(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

        try {
            String selectQuery = "SELECT skill, type FROM skills WHERE id_personne = ?";
            PreparedStatement skillStatement = dbController.getConnection().prepareStatement(selectQuery);
            skillStatement.setLong(1, idPersonne);

            ResultSet skillResultSet = skillStatement.executeQuery();

            while (skillResultSet.next()) {
                Skills skill = new Skills();
                
                skill.setSkill(skillResultSet.getString("skill"));
                skill.setType(skillResultSet.getString("type"));
                
                personne.addSkill(skill);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return personne;
    }
    
    public void modifyPersonneInfo(Personne p) {
    	 try {
             sqlConntroler dbController = new sqlConntroler();
             
             String updateQuery = "UPDATE personne SET firstName=?, lastName=?, Foonction=?, email=?, numberPhone=?, linkden=?, imageName=? WHERE id = ?";
             PreparedStatement preparedStatement = dbController.getConnection().prepareStatement(updateQuery);
             preparedStatement.setString(1, firstName);
             preparedStatement.setString(2, lastName);
             preparedStatement.setString(3, foonction);
             preparedStatement.setString(4, email);
             preparedStatement.setString(5, numberPhone);
             preparedStatement.setString(6, linkden);
             preparedStatement.setString(7, imageName);
             preparedStatement.setInt(8, p.getId());
             preparedStatement.executeUpdate();
    	 } catch (SQLException e) {
             e.printStackTrace();
         }
    }
   
    public void addEducation(Personne p) {
        try {
            sqlConntroler dbController = new sqlConntroler();

            // Assuming a unique constraint on (Title, location, Date)
            String selectQuery = "SELECT * FROM education WHERE Title = ? AND location = ? AND Date = ?";
            String insertQuery = "INSERT INTO education (Title, location, Date, End_date, Description, id_personne) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement selectStatement = dbController.getConnection().prepareStatement(selectQuery);
            PreparedStatement insertStatement = dbController.getConnection().prepareStatement(insertQuery);

            for (Education elt : education) {
                // Set parameters for the SELECT query
                selectStatement.setString(1, elt.Title);
                selectStatement.setString(2, elt.location);
                selectStatement.setString(3, elt.Date);

                // Execute the SELECT query
                ResultSet resultSet = selectStatement.executeQuery();

                // If no matching entry found, insert the education
                if (!resultSet.next()) {
                    // Set parameters for the INSERT query
                    insertStatement.setString(1, elt.Title);
                    insertStatement.setString(2, elt.location);
                    insertStatement.setString(3, elt.Date);
                    insertStatement.setString(4, elt.finale_date);
                    insertStatement.setString(5, elt.Descreption);
                    insertStatement.setLong(6, this.id);

                    // Execute the INSERT query
                    insertStatement.executeUpdate();
                }

                // Close the ResultSet
                resultSet.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addExperience(Personne p) {
        try {
            sqlConntroler dbController = new sqlConntroler();

            // Assuming a unique constraint on (Title, location, Date, FinalDate)
            String selectQuery = "SELECT * FROM experience WHERE Title = ? AND location = ? AND Date = ? AND FinalDate = ?";
            String insertQuery = "INSERT INTO experience (Title, location, Date, FinalDate, Description, Position, id_personne) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement selectStatement = dbController.getConnection().prepareStatement(selectQuery);
            PreparedStatement insertStatement = dbController.getConnection().prepareStatement(insertQuery);

            for (Experience elt : experience) {
                // Set parameters for the SELECT query
                selectStatement.setString(1, elt.Title);
                selectStatement.setString(2, elt.location);
                selectStatement.setString(3, elt.Date);
                selectStatement.setString(4, elt.Finaldate);

                // Execute the SELECT query
                ResultSet resultSet = selectStatement.executeQuery();

                // If no matching entry found, insert the experience
                if (!resultSet.next()) {
                    // Set parameters for the INSERT query
                    insertStatement.setString(1, elt.Title);
                    insertStatement.setString(2, elt.location);
                    insertStatement.setString(3, elt.Date);
                    insertStatement.setString(4, elt.Finaldate);
                    insertStatement.setString(5, elt.Descreption);
                    insertStatement.setString(6, elt.Position);
                    insertStatement.setLong(7, this.id);

                    // Execute the INSERT query
                    insertStatement.executeUpdate();
                }

                // Close the ResultSet
                resultSet.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProject(Personne p) {
        try {
            sqlConntroler dbController = new sqlConntroler();

            // Assuming a unique constraint on (Link, Title, Location, Date)
            String selectQuery = "SELECT * FROM project WHERE Link = ? AND Title = ? AND Location = ? AND Date = ?";
            String insertQuery = "INSERT INTO project (Link, Title, Location, Date, Description, id_personne) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement selectStatement = dbController.getConnection().prepareStatement(selectQuery);
            PreparedStatement insertStatement = dbController.getConnection().prepareStatement(insertQuery);

            for (Projects project : projects) {
                // Set parameters for the SELECT query
                selectStatement.setString(1, project.Link);
                selectStatement.setString(2, project.Title);
                selectStatement.setString(3, project.location);
                selectStatement.setString(4, project.Date);

                // Execute the SELECT query
                ResultSet resultSet = selectStatement.executeQuery();

                // If no matching entry found, insert the project
                if (!resultSet.next()) {
                    // Set parameters for the INSERT query
                    insertStatement.setString(1, project.Link);
                    insertStatement.setString(2, project.Title);
                    insertStatement.setString(3, project.location);
                    insertStatement.setString(4, project.Date);
                    insertStatement.setString(5, project.Descreption);
                    insertStatement.setLong(6, this.id);

                    // Execute the INSERT query
                    insertStatement.executeUpdate();
                }

                // Close the ResultSet
                resultSet.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addSkills(Personne p) {
        try {
            sqlConntroler dbController = new sqlConntroler();

            // Assuming a unique constraint on (skill, type, id_personne)
            String selectQuery = "SELECT * FROM skills WHERE skill = ? AND type = ? AND id_personne = ?";
            String insertQuery = "INSERT INTO skills (skill, type, id_personne) VALUES (?, ?, ?)";

            PreparedStatement selectStatement = dbController.getConnection().prepareStatement(selectQuery);
            PreparedStatement insertStatement = dbController.getConnection().prepareStatement(insertQuery);

            // Assuming you have a collection of Skills associated with your Personne instance
            for (Skills skill : skills) {
                // Set parameters for the SELECT query
                selectStatement.setString(1, skill.getSkill());
                selectStatement.setString(2, skill.getType());
                selectStatement.setLong(3, this.id);

                // Execute the SELECT query
                ResultSet resultSet = selectStatement.executeQuery();

                // If no matching entry found, insert the skill
                if (!resultSet.next()) {
                    // Set parameters for the INSERT query
                    insertStatement.setString(1, skill.getSkill());
                    insertStatement.setString(2, skill.getType());
                    insertStatement.setLong(3, this.id);

                    // Execute the INSERT query
                    insertStatement.executeUpdate();
                }

                // Close the ResultSet
                resultSet.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    
    
    public void deleteEducationByTitle() {
        try {
            sqlConntroler dbController = new sqlConntroler();

            // Retrieve all educations for the person
            String selectQuery = "SELECT * FROM education WHERE id_personne = ?";
            try (PreparedStatement selectStatement = dbController.getConnection().prepareStatement(selectQuery)) {
                selectStatement.setLong(1, this.id);
                try (ResultSet resultSet = selectStatement.executeQuery()) {

                    // Check if educations exist
                    if (resultSet.next()) {
                        // Display all educations to the user
                        System.out.println("Your Educations:");

                        do {
                            System.out.println("Title: " + resultSet.getString("Title"));
                        } while (resultSet.next());

                        // Ask the user to choose an education for deletion
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Enter the title of the education you want to delete: ");
                        String educationToDelete = scanner.nextLine();
                        String deleteQuery = "DELETE FROM education WHERE Title = ?";
                        try (PreparedStatement deleteStatement = dbController.getConnection().prepareStatement(deleteQuery)) {
                            deleteStatement.setString(1, educationToDelete);
                            int rowsAffected = deleteStatement.executeUpdate();
                            
                            if (rowsAffected > 0) {
                                System.out.println("Education deleted successfully.");
                            } else {
                                System.out.println("No education found with the specified title.");
                            }
                        }
                    } else {
                        System.out.println("No educations found.");
                    }
                }
            }
        } catch (SQLException e) {
            // Handle the exception gracefully, log it, or inform the user
            e.printStackTrace();
        }
}


    
    public void deleteExperienceByTitle() {
        try {
            sqlConntroler dbController = new sqlConntroler();

            // Retrieve all experiences for the person
            String selectQuery = "SELECT * FROM experience WHERE id_personne = ?";
            try (PreparedStatement selectStatement = dbController.getConnection().prepareStatement(selectQuery)) {
                selectStatement.setLong(1, this.id);
                try (ResultSet resultSet = selectStatement.executeQuery()) {

                    // Check if experiences exist
                    if (resultSet.next()) {
                        // Display all experiences to the user
                        System.out.println("Your Experiences:");

                        do {
                            System.out.println("Title: " + resultSet.getString("Title"));
                        } while (resultSet.next());

                        // Ask the user to choose an experience for deletion
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Enter the title of the experience you want to delete: ");
                        String experienceToDelete = scanner.nextLine();

                        // Proceed with the deletion
                        String deleteQuery = "DELETE FROM experience WHERE Title = ?";
                        try (PreparedStatement deleteStatement = dbController.getConnection().prepareStatement(deleteQuery)) {
                            deleteStatement.setString(1, experienceToDelete);
                            int rowsAffected = deleteStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Experience deleted successfully.");
                            } else {
                                System.out.println("Error deleting experience.");
                            }
                        }

                    } else {
                        System.out.println("No experiences found.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProjectByTitle() {
        try {
            sqlConntroler dbController = new sqlConntroler();

            // Retrieve all projects for the person
            String selectQuery = "SELECT * FROM project WHERE id_personne = ?";
            try (PreparedStatement selectStatement = dbController.getConnection().prepareStatement(selectQuery)) {
                selectStatement.setLong(1, this.id);
                try (ResultSet resultSet = selectStatement.executeQuery()) {

                    // Check if projects exist for the person
                    if (resultSet.next()) {
                        // Display all projects to the user
                        System.out.println("Your Projects:");

                        do {
                            System.out.println("Title: " + resultSet.getString("Title"));
                        } while (resultSet.next());

                        // Ask the user to choose a project for deletion
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Enter the title of the project you want to delete: ");
                        String projectToDelete = scanner.nextLine();

                        // Proceed with the deletion
                        String deleteQuery = "DELETE FROM project WHERE Title = ? AND id_personne = ?";
                        try (PreparedStatement deleteStatement = dbController.getConnection().prepareStatement(deleteQuery)) {
                            deleteStatement.setString(1, projectToDelete);
                            deleteStatement.setLong(2, this.id);
                            int rowsAffected = deleteStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Project deleted successfully.");
                            } else {
                                System.out.println("Error deleting project.");
                            }
                        }

                    } else {
                        System.out.println("No projects found for the person with ID " + this.id);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSkillsBySkill() {
        try {
            sqlConntroler dbController = new sqlConntroler();

            // Retrieve skill details based on the person ID
            String selectQuery = "SELECT * FROM skills WHERE id_personne = ?";
            try (PreparedStatement selectStatement = dbController.getConnection().prepareStatement(selectQuery)) {
                selectStatement.setLong(1, this.id);
                try (ResultSet resultSet = selectStatement.executeQuery()) {

                    // Check if skills exist for the person
                    if (resultSet.next()) {
                        // Display all skills to the user
                        System.out.println("Your Skills:");

                        do {
                            System.out.println("Skill Name: " + resultSet.getString("skill"));
                        } while (resultSet.next());

                        // Ask the user to choose a skill for deletion
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Enter the name of the skill you want to delete: ");
                        String skillToDelete = scanner.nextLine();

                        // Proceed with the deletion
                        String deleteQuery = "DELETE FROM skills WHERE skill = ? AND id_personne = ?";
                        try (PreparedStatement deleteStatement = dbController.getConnection().prepareStatement(deleteQuery)) {
                            deleteStatement.setString(1, skillToDelete);
                            deleteStatement.setLong(2, this.id);
                            int rowsAffected = deleteStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Skill deleted successfully.");
                            } else {
                                System.out.println("Error deleting skill.");
                            }
                        }

                    } else {
                        System.out.println("No skills found for the person with ID " + this.id);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }





	// ********************************* End of  Aymen partie ***********************************//

    public  Education getEducation(int i) {
          return education.get(i);
    }
    public  Experience getExperiance(int i) {
        return experience.get(i);
    }
    public  Skills getSkills(int i) {
        return skills.get(i);
    }
    public  Projects getProjects(int i) {
        return projects.get(i);
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getLinkden() {
        return linkden;
    }

    public void setLinkedin(String linkden) {
        this.linkden = linkden;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getFoonction() {
        return foonction;
    }

    public void setFoonction(String foonction) {
        this.foonction = foonction;
    }



    public int getId() {
        return id;
    }



    public String getFirstName() {
        return firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public String getEmail() {
        return email;
    }



    public String getImageName() {
        return imageName;
    }
    public int getEducationSize() {
        return education.size();
    }
    public int getProjectsSize() {
        return projects.size();
    }
    public int getSkillsSize() {
        return skills.size();
    }
    public int getExperianceSize() {
        return experience.size();
    }

    public void addEducation(Education education) {
        this.education.add(education);
    }
    public void addProject(Projects project) {
        this.projects.add(project);
    }

    public void addExperience(Experience experience) {
        this.experience.add(experience);
    }

    public void addSkill(Skills skill) {
        this.skills.add(skill);
    }



}
