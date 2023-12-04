package org.example;

import java.util.Scanner;

public class UserInputHnadler {
    private Personne personne;

    public UserInputHnadler(Personne personne) {
        this.personne = personne;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void getUserInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        personne.setFirstName(scanner.nextLine());

        System.out.print("Enter Last Name: ");
        personne.setLastName(scanner.nextLine());

        System.out.print("Enter Your Function: ");
        personne.setFoonction(scanner.nextLine());

        System.out.print("Enter Email: ");
        personne.setEmail(scanner.nextLine());

        System.out.print("Enter Number Phone: ");
        personne.setNumberPhone(scanner.nextLine());

        System.out.print("Enter LinkedIn: ");
        personne.setLinkedin(scanner.nextLine());

        System.out.print("Enter Image Name: ");
        personne.setImageName(scanner.nextLine());
    }

    public void getUserEducation() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Education Title (or type 'exit' to finish): ");
            String titleE = scanner.nextLine();

            if ("exit".equalsIgnoreCase(titleE)) {
                break;
            }

            System.out.print("Enter Education Location: ");
            String locationE = scanner.nextLine();

            System.out.print("Enter Education Start Date: ");
            String dateE = scanner.nextLine();

            System.out.print("Enter The last year of this Education Date: ");
            String dateF = scanner.nextLine();

            System.out.print("Enter Education Description: ");
            String descriptionE = scanner.nextLine();

            Education education = new Education(titleE, locationE, dateE,  descriptionE, dateF);
            personne.addEducation(education);
        }
    }

    public void getUserExperience() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Experience Title (or type 'exit' to finish): ");
            String titleEx = scanner.nextLine();

            if ("exit".equalsIgnoreCase(titleEx)) {
                break;
            }

            System.out.print("Enter Experience Location: ");
            String locationEx = scanner.nextLine();

            System.out.print("Enter Experience Date: ");
            String dateEx = scanner.nextLine();

            System.out.print("Enter Experience Description: ");
            String descriptionEx = scanner.nextLine();

            System.out.print("Enter Experience Final Date: ");
            String finalDateEx = scanner.nextLine();

            System.out.print("Enter Experience Position: ");
            String positionEx = scanner.nextLine();

            Experience experience = new Experience(titleEx, locationEx, dateEx, descriptionEx, positionEx, finalDateEx);
            personne.addExperience(experience);
        }
    }

    public void getUserProject() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Project Title (or type 'exit' to finish): ");
            String titleP = scanner.nextLine();

            if ("exit".equalsIgnoreCase(titleP)) {
                break;
            }

            System.out.print("Enter Project Location: ");
            String locationP = scanner.nextLine();

            System.out.print("Enter Project Date: ");
            String dateP = scanner.nextLine();

            System.out.print("Enter Project Description: ");
            String descriptionP = scanner.nextLine();

            System.out.print("Enter Project Link: ");
            String linkP = scanner.nextLine();

            Projects project = new Projects(titleP, locationP, dateP, descriptionP, linkP);
            personne.addProject(project);
        }
    }

    public void getUserSkills() {
        Scanner scanner = new Scanner(System.in);
        getUserSkillsByType("Technical", scanner);
        getUserSkillsByType("Language", scanner);
        getUserSkillsByType("Hobbies", scanner);
    }

    private void getUserSkillsByType(String type, Scanner scanner) {
        while (true) {
            System.out.print("Enter your " + type + " skill or type 'exit' to finish: ");
            String skill = scanner.nextLine();

            if ("exit".equalsIgnoreCase(skill)) {
                break;
            }

            Skills skills = new Skills(type, skill);
            personne.addSkill(skills);
        }
    }

    public static void madeBy() {
        System.out.println("******************************************************");
        System.out.println("|            => Welcome To the Cv App <=             |");
        System.out.println("|*****************************************************");
        System.out.println("| => Crafted By:                                     |");
        System.out.println("|            - Ilyas Bennajeh                        |");
        System.out.println("|            - Houda Harmane                         |");
        System.out.println("|            - Ayman Elfadl                          |");
        System.out.println("|            - Malake Bouyi                          |");
        System.out.println("|****************************************************|");
        System.out.println("|  Press Enter to Begin                              |");
        System.out.println("|                  Your Productive Journey   =>      |");
        System.out.println("******************************************************");
    }

    public static void userChoice() {
        System.out.println("******************************************************");
        System.out.println("|     =>  Your Productive Journey Started  <=         |");
        System.out.println("******************************************************");
        System.out.println("1-> Create a New CV                                   |");
        System.out.println("2-> View Existing CV                                  |");
        System.out.println("3-> Exit CV Generator... [ Goodbye! ]                 |");
        System.out.println("******************************************************");
        System.out.println("| -> Enter your choice:                               |");
        
    }

    public static void modelChoice() {
        System.out.println(" Choose a CV Model from the available options:");
        System.out.println("1-> Model CV (1)");
        System.out.println("2-> Model CV (2)");
        System.out.println("3-> Model CV (3)");
        System.out.println("4-> Model CV (4)");
    }

    public static void userSectionChoosen() {
        System.out.println("Choose the section of your CV to rebuild:");
        System.out.println("1. Personal Information");
        System.out.println("2. Education");
        System.out.println("3. Work Experience");
        System.out.print("Enter your choice: ");
    }

    public Personne createUser() {
        getUserInfo();
        ClearConsole.clearConsole();
        getUserEducation();
        ClearConsole.clearConsole();
        getUserExperience();
        ClearConsole.clearConsole();
        getUserProject();
        ClearConsole.clearConsole();
        getUserSkills();
        ClearConsole.clearConsole();
        return personne;
    }
}
