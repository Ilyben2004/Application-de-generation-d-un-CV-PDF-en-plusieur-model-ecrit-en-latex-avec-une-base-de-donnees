package org.example;

import java.util.Scanner;

public class ApplicationMenu {

    private Personne personne;
    private Scanner scanner;

    public ApplicationMenu() {
        this.personne = new Personne();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        ClearConsole.clearConsole();
        UserInputHnadler.madeBy();
        scanner.nextLine();
        ClearConsole.clearConsole();

        boolean exit = false;
        while (!exit) {
            UserInputHnadler.userChoice();
            int choice = scanner.nextInt();
            ClearConsole.clearConsole();

            switch (choice) {
                case 1:
                    handleCreateCV();
                    break;
                case 2:
                    handleModifyCV();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            ClearConsole.clearConsole();
            System.out.print("Do you want to perform another action ? (y/n): ");
            String userInput = scanner.next().toLowerCase();
            if (!userInput.equals("y")) {
                exit = true;
            }
        }
    }

    private void handleCreateCV() {
        UserInputHnadler user = new UserInputHnadler(personne);
        personne = user.createUser();

        System.out.print("Enter a name for your new CV: ");
        String filename = scanner.next();
        UserInputHnadler.modelChoice();

        int model;
        do {
            model = scanner.nextInt();
            switch (model) {
                case 1:
                    handleCreateCv(new Cv(filename, personne));
                    break;
                case 2:
                    handleCreateCv(new Cv2(filename, personne));
                    break;
                case 3:
                    handleCreateCv(new Cv3(filename, personne));
                    break;
                case 4:
                    handleCreateCv(new Cv4(filename, personne));
                    break;
                default:
                    System.out.println("Invalid model choice. Please try again.");
                    break;
            }
        } while (model > 4 || model < 1);
        personne = new Personne(); 
    }

    private void handleCreateCv(Cv cv) {
        personne.insertPersonne();
        cv.insertCv();
        cv.createCv();
    }

    private void handleModifyCV() {
        
        System.out.println(" Do you want to Rebuild OR Change Section ?");
        System.out.println(" 1-> Rebuild ");
        System.out.println(" 2-> Change Section ");
        System.out.println(" 3-> Exit");
        
        int str;
        do {
            str = scanner.nextInt();
            switch (str) {
                case 1: 
                	personne.getCvCreated();
                    handleRebuildCV();
                    break;
                case 2:
                	personne.getCvCreated();
                    handleChangeSection();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (str > 3 || str< 1);

        ClearConsole.clearConsole();
    }

    private void handleRebuildCV() {
        System.out.println(" Choose the CV you want to Rebuild with a different model:");

        int CVid = scanner.nextInt();
        personne = Personne.getPersonneByCvFilename(CVid);
        UserInputHnadler.modelChoice();

        int chx;
        do {
            chx = scanner.nextInt();
            switch (chx) {
                case 1:
                    Cv cvTest1 = new Cv("forTest", personne);
                    cvTest1.createCv();
                    break;
                case 2:
                    Cv2 cvTest2 = new Cv2("forTest", personne);
                    cvTest2.createCv();
                    break;
                case 3:
                    Cv3 cvTest3 = new Cv3("forTest", personne);
                    cvTest3.createCv();
                    break;
                case 4:
                    Cv4 cvTest4 = new Cv4("forTest", personne);
                    cvTest4.createCv();
                    break;
                default:
                    System.out.println("Invalid model choice. Please try again.");
                    break;
            }
        } while (chx > 4 || chx < 1);
    }

    private void handleChangeSection() {
    	
    	System.out.println("Choose the CV you want to change :");
    	
        int CVid = scanner.nextInt();
    	personne = Personne.getPersonneByCvFilename(CVid);
    	
        
        System.out.println("What do you want to ADD or DELETE:");
        System.out.println("1. ADD");
        System.out.println("2. DELETE");
        System.out.println("3. Exit");

        int chx1;
        do {
            chx1 = scanner.nextInt();

            ClearConsole.clearConsole();
            switch (chx1) {
                case 1:
                    System.out.println("What is the new Section:");
                    System.out.println("1. Infos");
                    System.out.println("2. Education");
                    System.out.println("3. Experience");
                    System.out.println("4. Project");

                    System.out.println("5. Skills");

                    int x;
                    do {
                    	System.out.println("Choose a type to ADD (1-5), or enter 6 to exit:");
                        x = scanner.nextInt();
                        switch (x) {
                            case 1:
                                UserInputHnadler infoHandler = new UserInputHnadler(personne);
                                infoHandler.getUserInfo();
                                personne.modifyPersonneInfo(infoHandler.getPersonne());
                                break;
                            case 2:
                                UserInputHnadler educationHandler = new UserInputHnadler(personne);
                                educationHandler.getUserEducation();
                                personne.addEducation(educationHandler.getPersonne());
                                break;
                            case 3:
                                UserInputHnadler experienceHandler = new UserInputHnadler(personne);
                                experienceHandler.getUserExperience();
                                personne.addExperience(experienceHandler.getPersonne());
                                break;
                            case 4:
                                UserInputHnadler projectHandler = new UserInputHnadler(personne);
                                projectHandler.getUserProject();
                                personne.addProject(projectHandler.getPersonne());
                                break;
                            case 5:
                                UserInputHnadler skillsHandler = new UserInputHnadler(personne);
                                skillsHandler.getUserSkills();
                                personne.addSkills(skillsHandler.getPersonne());
                                break;
                            case 6:
                                System.out.println("Exiting Add section.");
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                    } while (x < 1 || x > 5);

                    
                    break;

                case 2:
                    System.out.println("What is the Section you want to DELETE : ");
                    System.out.println("1. Education");
                    System.out.println("2. Project");
                    System.out.println("3. Experience");
                    System.out.println("4. Skills");
                    System.out.println("5. Exit");

                    int y;
                    do {
                        System.out.println("Choose a type to delete (1-4), or enter 5 to exit:");
                        y = scanner.nextInt();

                        switch (y) {
                            case 1:
                                
                                personne.deleteEducationByTitle();
                                break;
                            case 2:
                                personne.deleteProjectByTitle();
                                break;
                            case 3:
                                personne.deleteExperienceByTitle();
                                break;
                            case 4:
                                personne.deleteSkillsBySkill();
                                break;
                            case 5:
                                System.out.println("Exiting delete section.");
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                    } while (y != 5);
                    break;

                case 3:
                    System.out.println("Exiting Change Section.");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }

            if (chx1 != 3) {
                System.out.println("Do you want to ADD or DELETE another section? (1. ADD, 2. DELETE, 3. Exit):");
            }
        } while (chx1 != 3);
        personne = Personne.getPersonneByCvFilename(CVid);
        UserInputHnadler.modelChoice();
        int chx;
        do {
            chx = scanner.nextInt();
            switch (chx) {
                case 1:
                    Cv cvTest1 = new Cv("forTest", personne);
                    cvTest1.createCv();
                    break;
                case 2:
                    Cv2 cvTest2 = new Cv2("forTest", personne);
                    cvTest2.createCv();
                    break;
                case 3:
                    Cv3 cvTest3 = new Cv3("forTest", personne);
                    cvTest3.createCv();
                    break;
                case 4:
                    Cv4 cvTest4 = new Cv4("forTest", personne);
                    cvTest4.createCv();
                    break;
                default:
                    System.out.println("Invalid model choice. Please try again.");
                    break;
            }
        } while (chx > 4 || chx < 1);
        
    }

}
