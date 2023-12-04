package org.example;

public class Cv4 extends Cv{

    public Cv4(String filename, Personne p) {
        super(filename, p);
    }

    @Override
    public void Write_PersoInfos() {
        String Latextcontent="\\documentclass{article}\n" +
                "\\usepackage{bubblecv}\n" +
                "\n" +
                "\\begin{document}\n" +
                "\n" +
                "\n" +
                "\\begin{cv}[avatar]{"+p.getFirstName()+" "+p.getLastName()+"}{"+p.getFoonction()+"}";
        Functions.clearLatexDocument();
        Functions.WriteInLatex(Latextcontent);

    }

    @Override
    public void Write_experiance() {
            String Latexcontent ="\\cvsection[work]{Work experience} \n\n";
        for (int i = 0; i < p.getExperianceSize(); i++) {
            Latexcontent+="\\begin{cvevent}["+p.getExperiance(i).getDate()+"]["+p.getExperiance(i).getFinaldaAte()+"]\n" +
                    "    \\cvname{"+p.getExperiance(i).getPosition()+"}\n" +
                    "    \\cvdescription{"+p.getExperiance(i).getTitle()+" "+p.getExperiance(i).getLocation()+"}\n" +
                    "    \\begin{itemize}\n" +
                    "        \\item "+p.getExperiance(i).getDescreption()+".\n" +
                    "    \\end{itemize}\n" +
                    "\\end{cvevent}";
        }
        Functions.WriteInLatex(Latexcontent);
    }

    @Override
    public void Write_Education() {
        String Latexcontent ="\\cvsection[education]{Education}";
        for (int i = 0; i < p.getEducationSize(); i++) {
            Latexcontent+="\\begin{cvevent}["+p.getEducation(i).getDate()+"]["+p.getEducation(i).getFinalDate()+"]\n" +
                    "    \\cvname{"+p.getEducation(i).getTitle()+"}\n" +
                    "    \\cvdescription{"+p.getEducation(i).getLocation()+"}\n" +
                    "     \\textbf{Courses and Achievements:}"+
                    "    \\begin{itemize}\n" +
                    "        \\item "+p.getEducation(i).getDescreption()+".\n" +
                    "    \\end{itemize}\n" +
                    "\\end{cvevent}";
        }
        Functions.WriteInLatex(Latexcontent);
    }

    @Override
    public void Write_Projects() {
        String Latexcontent="\\cvsection[target]{Projects}";
        for(Projects elt : p.projects){
            Latexcontent+="\\cvseparator[2]\n" +
                    "\\begin{cvevent}["+elt.getDate()+"]\n" +
                   "\\cvname{" + elt.getTitle() + "} \n"+
                    "    "+elt.getDescreption()+".\n\n" ;
            if(!elt.getLink().equals("")) {Latexcontent+="\\href{"+elt.getLink()+"}{VISIT THE PROJECT}.";}
                Latexcontent+=    "\\end{cvevent}";
        }
        Functions.WriteInLatex(Latexcontent);
    }
    public  void write_contact(){
        String Latexcontent ="\\cvsidebar %-----------------------------------------------------------------------------\n" +
                "\n" +
                "\n" +
                "\\cvsection[contact]{Contact}  %----------------------------------------------------------\n" +
                "\n" +
                "\\begin{cvitem}[Envelope][4]\n" +
                "    \\textbf{Email}\\\\\n" +
                "    \\href{mailto:"+p.getEmail()+"}{\\texttt{"+p.getEmail()+"}}\n" +
                "\\end{cvitem}\n" +
                "\n" +
                "\\cvseparator[3]\n" +
                "\\begin{cvitem}[Phone][4]\n" +
                "    \\textbf{Phone}\\\\\n" +
                "    \\href{tel:+"+p.getNumberPhone()+"}{\\texttt{+"+p.getNumberPhone()+"}}\n" +
                "\\end{cvitem}\n"+
                "\\cvseparator[3]\n" +
                "\\begin{cvitem}[Globe][4]\n" +
                "    \\textbf{Linkden}\\\\\n" +
                "    \\href{"+p.getLinkden()+"}{\\texttt{"+p.getLinkden()+"}}\n" +
                "\\end{cvitem}";
        Functions.WriteInLatex(Latexcontent);
    }

    @Override
    void write_skills() {
        String Latexcontent="\\cvsection[skills]{Skills\\&Hobbies} ";
        for (Skills s : p.skills){
            if(!(s.getType().equals("Language"))){
                Latexcontent+="\\begin{cvitem}\n" +
                        "    "+s.getSkill()+"\n" +
                        "\\end{cvitem}\n ";


            }



        }
        Latexcontent+="\n \\cvsection[languages]{Languages} \n ";
        for (Skills s : p.skills) {
            if ((s.getType().equals("Language"))) {
                Latexcontent += "\\cvskill{"+s.getSkill()+"}{}{1.0}\n";

            }
        }
        Latexcontent+="\n" +
                "\n" +
                "\\end{cv}\n" +
                "\n" +
                "\\cvfootnote{\n" +
                "    \\tiny CREATED BY CVAPP TEAMS INCLUDS ILYAS BENNAJEH - AYMAN ELFADL - HOUDA HARMANNE - MALAK SAHIR\n" +
                "}\n" +
                "\n" +
                "\\end{document}\n";

        Functions.WriteInLatex(Latexcontent);
    }


    public void createCv(){
System.out.println("********************  "+ p.getImageName()+"  *******************88");
        Write_PersoInfos();
        Write_experiance();
        Write_Education();
        Write_Projects();
        write_contact();
        write_skills();
        PictureHandler pi = new PictureHandler();
        pi.renameAndReplaceImage(p.getImageName(),"C:\\Users\\HP\\IdeaProjects\\CvApp\\pdf\\resources");


        Functions.convertLatexToPdf();
        Functions.convertLatexToPdf();



    }

}

