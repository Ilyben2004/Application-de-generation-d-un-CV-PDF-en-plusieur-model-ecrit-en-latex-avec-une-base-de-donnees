package org.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cv  {

    private  int id;
    private String filename;
    protected Personne p;



    public Cv(String filename,Personne p) {
        
        this.filename = filename;
        this.p = p;
        //  Initialize arrays with meaningful data
    }
    
  

    public void Write_PersoInfos(){

      String latexContent =  "\\documentclass[letterpaper,11pt]{article}\n" +
              "\\usepackage{latexsym}\n" +
              "\\usepackage[empty]{fullpage}\n" +
              "\\usepackage{titlesec}\n" +
              "\\usepackage{marvosym}\n" +
              "\\usepackage[usenames,dvipsnames]{color}\n" +
              "\\usepackage{verbatim}\n" +
              "\\usepackage{enumitem}\n" +
              "\\usepackage[hidelinks]{hyperref}\n" +
              "\\usepackage{fancyhdr}\n" +
              "\\usepackage[english]{babel}\n" +
              "\\usepackage{tabularx}\n" +
              "\\usepackage{fontawesome5}\n" +
              "\\usepackage{multicol}\n" +
              "\\setlength{\\multicolsep}{-3.0pt}\n" +
              "\\setlength{\\columnsep}{-1pt}\n" +
              "\\input{glyphtounicode}\n" +
              "\\pagestyle{fancy}\n" +
              "\\fancyhf{} % clear all header and footer fields\n" +
              "\\fancyfoot{}\n" +
              "\\renewcommand{\\headrulewidth}{0pt}\n" +
              "\\renewcommand{\\footrulewidth}{0pt}\n" +
              "% Adjust margins\n" +
              "\\addtolength{\\oddsidemargin}{-0.6in}\n" +
              "\\addtolength{\\evensidemargin}{-0.5in}\n" +
              "\\addtolength{\\textwidth}{1.19in}\n" +
              "\\addtolength{\\topmargin}{-.7in}\n" +
              "\\addtolength{\\textheight}{1.4in}\n" +
              "\\urlstyle{same}\n" +
              "\\raggedbottom\n" +
              "\\raggedright\n" +
              "\\setlength{\\tabcolsep}{0in}\n" +
              "% Sections formatting\n" +
              "\\titleformat{\\section}{\n" +
              "  \\vspace{-7pt}\\scshape\\raggedright\\large\\bfseries\n" +
              "}{}{0em}{}[\\color{black}\\titlerule \\vspace{0pt}]\n" +
              "% Ensure that generate pdf is machine readable/ATS parsable\n" +
              "\\pdfgentounicode=1\n" +
              "\n" +
              "%%%%%%%%%%%%%%%%%%%%%%%%%%%%  Commands  %%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
              "\\newcommand{\\resumeItem}[1]{\n" +
              "  \\item\\small{\n" +
              "    {#1 \\vspace{-3pt}}\n" +
              "  }\n" +
              "}\n" +
              "\\newcommand{\\resumeSubheading}[4]{\n" +
              "  \\vspace{-3pt}\\item\n" +
              "    \\begin{tabular*}{1.0\\textwidth}[t]{l@{\\extracolsep{\\fill}}r}\n" +
              "      \\textbf{#1} & \\textbf{\\small #2} \\\\\n" +
              "      \\textit{\\small#3} & \\textit{\\small #4} \\\\\n" +
              "    \\end{tabular*}\\vspace{-7pt}\n" +
              "}\n" +
              "\\newcommand{\\resumeSubheadingContinue}[2]{\n" +
              "  \\vspace{-3pt}\n" +
              "    \\begin{tabular*}{1.0\\textwidth}[t]{l@{\\extracolsep{\\fill}}r}\n" +
              "      \\textit{\\small#1} & \\textit{\\small #2} \\\\\n" +
              "    \\end{tabular*}\\vspace{-7pt}\n" +
              "}\n" +
              "\\newcommand{\\resumeProjectHeading}[2]{\n" +
              "  \\vspace{-3pt}\\item\n" +
              "    \\begin{tabular*}{1.0\\textwidth}[t]{l@{\\extracolsep{\\fill}}r}\n" +
              "      \\textbf{#1} & \\textbf{\\small #2} \\\\\n" +
              "    \\end{tabular*}\\vspace{-7pt}\n" +
              "}\n" +
              "\\newcommand{\\resumeSubItem}[1]{\\resumeItem{#1}\\vspace{0pt}}\n" +
              "\\renewcommand\\labelitemi{$\\vcenter{\\hbox{\\tiny$\\bullet$}}$}\n" +
              "\\renewcommand\\labelitemii{$\\vcenter{\\hbox{\\tiny$\\bullet$}}$}\n" +
              "\\newcommand{\\resumeSubHeadingListStart}{\\begin{itemize}[leftmargin=0.0in, label={}]}\n" +
              "\\newcommand{\\resumeSubHeadingListEnd}{\\end{itemize}}\n" +
              "\\newcommand{\\resumeItemListStart}{\\begin{itemize}}\n" +
              "\\newcommand{\\resumeItemListEnd}{\\end{itemize}\\vspace{0pt}}"+"\\begin{document}\n" +
                "    \\begin{center}\n" +
                "    {\\Huge\\scshape " + p.getFirstName() + " " + p.getLastName() + "} \n"
                + "\\\\ " + p.getFoonction() + "\\\\  \n"
                +"\\small \n" +
                "\\href{mailto:" + p.getEmail() + "}{\\raisebox{-0.2\\height}\\faEnvelope\\ \\underline{" + p.getEmail() + "}} ~ \n" +
                "  \\href{www.linkden.com/"+p.getLinkden()+"}{\\raisebox{-0.2\\height}\\faLinkedin\\ \\underline{linkedin.com/"+p.getLinkden()+"}}  ~ \n" +
                "\\end{center}\n" ;

      Functions.clearLatexDocument();

      Functions.WriteInLatex(latexContent);














    }
    public void Write_Education(){
        String LatexContent ="\\section{\\textbf{Education}}\n"+ "\\resumeSubHeadingListStart\n" ;

        for (int i=0 ;i<p.getEducationSize();i++){
            LatexContent=LatexContent  +
                    "\n" +
                    "    % MAIN INFORMATION\n" +
                    "    \\resumeSubheading\n" +
                    "    { "+p.getEducation(i).Title +" }{"+ p.getEducation(i).location +"}\n" +
                    "    {"+p.getEducation(i).Descreption+"}{"+p.getEducation(i).Date + " - "+p.getEducation(i).finale_date+"}\n" +
                    "        % BULLET POINTS\n" +
                    "        \n"
                 ;

        }
        LatexContent=LatexContent +  "  \\resumeSubHeadingListEnd \n" ;
        Functions.WriteInLatex(LatexContent);



    }

    public void Write_experiance(){
        String LatexContent = "\\section{\\textbf{Experiance}}\n" +
                "    \\resumeSubHeadingListStart\n";
        for (int i = 0; i < p.getExperianceSize(); i++) {
            LatexContent += "% COMPANY " + (i + 1) + "\n" +
                    "        \\resumeSubheading\n" +
                    "        {" + p.getExperiance(i).Title + "}{" + p.getExperiance(i).location + "}\n" +
                    "            % POSITION 1\n" +
                    "            {" + p.getExperiance(i).Position + "}{" + p.getExperiance(i).Date + "-" + p.getExperiance(i).Finaldate + "}\n" +
                    "            \\resumeItemListStart\n" +
                    "                \\resumeItem{" + p.getExperiance(i).Descreption + "}\n" +
                    "            \\resumeItemListEnd\n";
        }
        LatexContent=LatexContent+"    \\resumeSubHeadingListEnd\n";
        Functions.WriteInLatex(LatexContent);




    }
    public void Write_Projects(){
        String Latexcontent ="\\section{\\textbf{Personnel Projects}} \n" +
                "    \\resumeSubHeadingListStart\n";
        for (int i=0 ; i<p.getProjectsSize();i++){
            Latexcontent= Latexcontent+" \\resumeProjectHeading\n" +
                    "        {\\href{"+p.getProjects(i).getLink()+"} {\\large\\textbf{"+p.getProjects(i).getTitle()+"}}}\n" +
                    "        % Date\n" +
                    "        {"+p.getProjects(i).Date+"}\n" +
                    "        \\resumeItemListStart\n" +
                    "            \\resumeItem{"+p.getProjects(i).Descreption+"}\n" +
                    "        \\resumeItemListEnd\n" +
                    "    \n" ;


        }
        Latexcontent=Latexcontent+"    \\resumeSubHeadingListEnd\n";
        Functions.WriteInLatex(Latexcontent);
    }
    String GetSkillsLatex(String type){
   float  x=1.3f;
        String LatexContent="\\textbf{- "+type+"}\n\n";

        for (int i=0 ; i<p.getSkillsSize() ; i++){

            if(p.getSkills(i).getType().equals(type)){
                LatexContent+="\\hspace{"+x+"cm}$\\bullet$ "+p.getSkills(i).getSkill()+"\\\\\n";

            }
        }
        LatexContent=LatexContent+"\n\n\n";

        return LatexContent;
    }
    void write_skills() {
        String Latexcontent = "\\section{\\textbf{Skills And Hobies}}\n" +
                "\n" +
                "    \\vspace{2pt}\n" +
                "    \\begin{itemize}\n" +
                "    [leftmargin=0.15in, label={}]\\small{\\item{\n"+
                GetSkillsLatex("Language")+
                GetSkillsLatex("Technical")+
                GetSkillsLatex("Hobbies")+"}} \n"+"\\end{itemize}\n"+"\\end{document}";

        Functions.WriteInLatex(Latexcontent);

            }
void createCv(){
    Write_PersoInfos();
    Write_Education();
    Write_experiance();
    Write_Projects();
    write_skills();
    Functions.clearAUXDocument();
    Functions.convertLatexToPdf();
    Functions.convertLatexToPdf();


}

	public void insertCv(){
		String insertQuery = "INSERT INTO Cv (filename, personne, id_personne) " +
				"VALUES (?, ?, ?)";
		sqlConntroler dbConnector = new sqlConntroler();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = dbConnector.getConnection().prepareStatement(insertQuery);
			preparedStatement.setString(1, filename);
			preparedStatement.setString(2, p.getFirstName()+" "+p.getLastName());
			preparedStatement.setLong(3, p.getId());
			preparedStatement.executeUpdate();
        
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

        }








