package org.example;

public class Cv2 extends  Cv{
	
    Cv2(String filename,Personne p){
        super(filename, p);
    }

    @Override
    public void Write_PersoInfos() {
        String Latexcontent ="\\documentclass{letter}\n" +
                "\\usepackage{wallpaper}\n" +
                "\\usepackage{geometry}\n" +
                "\\usepackage{xcolor}\n" +
                "\\usepackage[T1]{fontenc}\n" +
                "\\usepackage[scaled]{helvet}\n" +
                "\\usepackage{fontawesome5}\n" +
                "\\usepackage{hyperref}\n" +
                "\\usepackage[none]{hyphenat}\n" +
                "\\usepackage{graphicx}\n" +
                "\n" +
                "\\renewcommand{\\familydefault}{\\sfdefault}\n" +
                "% Define a custom LinkedIn icon\n" +
                "\n" +
                "\n" +
                "\\geometry{\n" +
                "  paperwidth=\\dimexpr\\textwidth+\\marginparsep+\\marginparwidth\\relax,\n" +
                "  paperheight=\\dimexpr\\textheight+\\footskip\\relax,\n" +
                "  left=20pt,\n" +
                "  right=20pt,\n" +
                "  top=0pt,\n" +
                "  bottom=0pt,\n" +
                "  nohead,\n" +
                "  nofoot,\n" +
                "  nomarginpar\n" +
                "}\n" +
                "\n" +
                "\\ThisCenterWallPaper{1.5}{cvbg.png}\n" +
                "\n" +
                "\\begin{document}\n" +
                "\n" +
                "\\begin{minipage}[t]{0.40\\textwidth}\n" +
                "\\setlength{\\baselineskip}{1.5\\baselineskip}\n" +
                "\\color{white}\n" +
                "\\vspace{1cm}\n" +
                "{\\large Personal Info}\n" +
                "\n" +
                "\\rule{\\linewidth}{0.4pt}\n" +
                "\n" +
                "\\faPhone \\quad "+ p.getNumberPhone()+"\n" +
                "\n" +
                "\\faEnvelope \\quad \\href{mailto: "+p.getEmail()+"}{"+p.getEmail()+"}\n" +
                "\n" +


                "\\rule{\\linewidth}{0.4pt}\n" +
                "\n" +
                "{\\large Links}\n" +
                "\n" +
                "\n" +
                "\n" +
                "\\faLinkedin \\quad \\href{"+p.getLinkden()+"}{"+p.getLinkden()+"} \n\n"+
                "\\rule{\\linewidth}{0.4pt} \n"+"% end writepersonnel cv21\n";

        Functions.clearLatexDocument();
        Functions.WriteInLatex(Latexcontent);

     }

     @Override
     void write_skills() {
       String LatexContenet ;
       String Language="{\\large Languages}\n\n";
       String Hobbies= "{\\large Hobbies}\n\n";
       LatexContenet="{\\large Skills}\n \n";

       for(Skills elm : p.skills){
           if(elm.getType().equals("Language")){
               Language+="\\faLanguage \\quad "+elm.getSkill()+" \n\n";
           } else if (elm.getType().equals("Hobbies")) {
               Hobbies+="\\faQq \\quad "+elm.getSkill()+"\n \n";


           }
           else{
               LatexContenet+="\\faCircleNotch \\quad "+elm.getSkill()+" \n\n";
           }
       }
       LatexContenet +="\\rule{\\linewidth}{0.4pt }\n \n";
       Hobbies +="\\rule{\\linewidth}{0.4pt}\n \n";
       LatexContenet =LatexContenet+Hobbies+Language+"\n\n"+"\\end{minipage}\n" ;
       Functions.WriteInLatex(LatexContenet);



     }


     @Override
     public void Write_experiance() {
        String LatexContent ="\\hfill\n" +
                "\\begin{minipage}[t]{0.60\\textwidth}\n" +
                "\\setlength{\\baselineskip}{1.5\\baselineskip}\n" +
                "\\vspace{0.8cm}\n" +
                "{\\huge "+p.getFirstName() +" "+  p.getLastName() +"}\n" +
                "\n" +
                "{\\large "+p.getFoonction()+"}\n" +
                "\n" +
                "\\vspace{0.2cm}\n" +

                "\n" +
                "{\\large Work Experience}\n" +
                "\\rule{\\linewidth}{0.4pt}\n\n";
        for(Experience elt : p.experience){
            LatexContent=LatexContent+" {\\large \\textbf{"+elt.getTitle()+"}}\n\n"
                    +"{\\small From "+elt.getDate()
                    + " To " +elt.getFinaldaAte()+" In "+elt.getLocation()+"}\n\n"
                    +"\\begin{itemize}\n" +
                    "    \\item "+elt.getDescreption()+"\n"+
                    "\\end{itemize}\n\n";
        }


        Functions.WriteInLatex(LatexContent);
     }

     @Override
     public void Write_Education() {
        String LatexContent="{\\large Education}\n" +
                "\\rule{\\linewidth}{0.4pt}\n" +
                "\n" ;
              for (Education elt : p.education){
                  LatexContent=LatexContent+"{\\large \\textbf{"+elt.getTitle()+"( "+elt.getLocation()+" )}}"
                          +"\n\n"+"{\\small From "+elt.getDate()+" To "+elt.finale_date+" : "+elt.getDescreption()+"}\n\n";
              }
              LatexContent+="\n" ;

              Functions.WriteInLatex(LatexContent);
     }

     @Override
     public void Write_Projects() {
         String LatexContent="{\\large Projects}\n" +
                 "\\rule{\\linewidth}{0.4pt}\n" +
                 "\n" ;
         for (Projects elt : p.projects){
             LatexContent=LatexContent+"\\href{"+elt.getLink()+"}{\\large \\textbf{"+elt.getTitle()+"( " +elt.getLocation()+")}}\n"
                     +"\n\n"+"{\\small "+elt.getDate()+" : "+elt.getDescreption()+"}\n\n";
         }
         LatexContent+="\n" +
                 "\\end{minipage}\n" +
                 "\\end{document} ";

         Functions.WriteInLatex(LatexContent);
     }

    @Override
    void createCv() {
        Write_PersoInfos();
        write_skills();
        Write_experiance();
        Write_Education();
        Functions.clearAUXDocument();
        Write_Projects();

        Functions.convertLatexToPdf();
    }
}
