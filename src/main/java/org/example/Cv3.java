package org.example;

public class Cv3 extends Cv{
    Cv3(String filename,Personne p){
        super(filename,p);
    }

    @Override
    public void Write_PersoInfos() {
    	String image = Functions.imageNameChangeFormat(p.getImageName());
       String LatexContent="\\documentclass[a4paper,11pt]{article}\n" +
               "\\usepackage{latexsym}\n" +
               "\\usepackage{xcolor}\n" +
               "\\usepackage{float}\n" +
               "\\usepackage{ragged2e}\n" +
               "\\usepackage[empty]{fullpage}\n" +
               "\\usepackage{wrapfig}\n" +
               "\\usepackage{lipsum}\n" +
               "\\usepackage{tabularx}\n" +
               "\\usepackage{titlesec}\n" +
               "\\usepackage{geometry}\n" +
               "\\usepackage{marvosym}\n" +
               "\\usepackage{verbatim}\n" +
               "\\usepackage{enumitem}\n" +
               "\\usepackage[hidelinks]{hyperref}\n" +
               "\\usepackage{fancyhdr}\n" +
               "\\usepackage{fontawesome5}\n" +
               "\\usepackage{multicol}\n" +
               "\\usepackage{graphicx}\n" +
               "\\usepackage{cfr-lm}\n" +
               "\\usepackage[T1]{fontenc}\n" +
               "\\setlength{\\footskip}{4.08003pt} \n" +
               "\\pagestyle{fancy}\n" +
               "\\fancyhf{} % clear all header and footer fields\n" +
               "\\fancyfoot{}\n" +
               "\\renewcommand{\\headrulewidth}{0pt}\n" +
               "\\renewcommand{\\footrulewidth}{0pt}\n" +
               "\\geometry{left=1.4cm, top=1cm, right=1.4cm, bottom=1cm}\n" +
               "% Adjust margins\n" +
               "%\\addtolength{\\oddsidemargin}{-0.5in}\n" +
               "%\\addtolength{\\evensidemargin}{-0.5in}\n" +
               "%\\addtolength{\\textwidth}{1in}\n" +
               "\\usepackage[most]{tcolorbox}\n" +
               "\\tcbset{\n" +
               "\tframe code={}\n" +
               "\tcenter title,\n" +
               "\tleft=0pt,\n" +
               "\tright=0pt,\n" +
               "\ttop=0pt,\n" +
               "\tbottom=0pt,\n" +
               "\tcolback=gray!20,\n" +
               "\tcolframe=white,\n" +
               "\twidth=\\dimexpr\\textwidth\\relax,\n" +
               "\tenlarge left by=-2mm,\n" +
               "\tboxsep=4pt,\n" +
               "\tarc=0pt,outer arc=0pt,\n" +
               "}\n" +
               "\n" +
               "\\urlstyle{same}\n" +
               "\n" +
               "\\raggedright\n" +
               "\\setlength{\\footskip}{4.08003pt}\n" +
               "\n" +
               "% Sections formatting\n" +
               "\\titleformat{\\section}{\n" +
               "  \\vspace{-4pt}\\scshape\\raggedright\\large\n" +
               "}{}{0em}{}[\\color{black}\\titlerule \\vspace{-7pt}]\n" +
               "\n" +
               "%-------------------------\n" +
               "% Custom commands\n" +
               "\\newcommand{\\resumeItem}[2]{\n" +
               "  \\item{\n" +
               "    \\textbf{#1}{\\hspace{0.5mm}#2 \\vspace{-0.5mm}}\n" +
               "  }\n" +
               "}\n" +
               "\n" +
               "\\newcommand{\\resumePOR}[3]{\n" +
               "\\vspace{0.5mm}\\item\n" +
               "    \\begin{tabular*}{0.97\\textwidth}[t]{l@{\\extracolsep{\\fill}}r}\n" +
               "        \\textbf{#1}\\hspace{0.3mm}#2 & \\textit{\\small{#3}} \n" +
               "    \\end{tabular*}\n" +
               "    \\vspace{-2mm}\n" +
               "}\n" +
               "\n" +
               "\\newcommand{\\resumeSubheading}[4]{\n" +
               "\\vspace{0.5mm}\\item\n" +
               "    \\begin{tabular*}{0.98\\textwidth}[t]{l@{\\extracolsep{\\fill}}r}\n" +
               "        \\textbf{#1} & \\textit{\\footnotesize{#4}} \\\\\n" +
               "        \\textit{\\footnotesize{#3}} &  \\footnotesize{#2}\\\\\n" +
               "    \\end{tabular*}\n" +
               "    \\vspace{-2.4mm}\n" +
               "}\n" +
               "\n" +
               "\\newcommand{\\resumeProject}[4]{\n" +
               "\\vspace{0.5mm}\\item\n" +
               "    \\begin{tabular*}{0.98\\textwidth}[t]{l@{\\extracolsep{\\fill}}r}\n" +
               "        \\textbf{#1} & \\textit{\\footnotesize{#3}} \\\\\n" +
               "        \\footnotesize{\\textit{#2}} & \\footnotesize{#4}\n" +
               "    \\end{tabular*}\n" +
               "    \\vspace{-2.4mm}\n" +
               "}\n" +
               "\n" +
               "\\newcommand{\\resumeSubItem}[2]{\\resumeItem{#1}{#2}\\vspace{-4pt}}\n" +
               "\n" +
               "% \\renewcommand{\\labelitemii}{$\\circ$}\n" +
               "\\renewcommand{\\labelitemi}{$\\vcenter{\\hbox{\\tiny$\\bullet$}}$}\n" +
               "\n" +
               "\\newcommand{\\resumeSubHeadingListStart}{\\begin{itemize}[leftmargin=*,labelsep=0mm]}\n" +
               "\\newcommand{\\resumeHeadingSkillStart}{\\begin{itemize}[leftmargin=*,itemsep=1.7mm, rightmargin=2ex]}\n" +
               "\\newcommand{\\resumeItemListStart}{\\begin{justify}\\begin{itemize}[leftmargin=3ex, rightmargin=2ex, noitemsep,labelsep=1.2mm,itemsep=0mm]\\small}\n" +
               "\n" +
               "\\newcommand{\\resumeSubHeadingListEnd}{\\end{itemize}\\vspace{2mm}}\n" +
               "\\newcommand{\\resumeHeadingSkillEnd}{\\end{itemize}\\vspace{-2mm}}\n" +
               "\\newcommand{\\resumeItemListEnd}{\\end{itemize}\\end{justify}\\vspace{-2mm}}\n" +
               "\\newcommand{\\cvsection}[1]{%\n" +
               "\\vspace{2mm}\n" +
               "\\begin{tcolorbox}\n" +
               "    \\textbf{\\large #1}\n" +
               "\\end{tcolorbox}\n" +
               "    \\vspace{-4mm}\n" +
               "}\n" +
               "\n" +
               "\\newcolumntype{L}{>{\\raggedright\\arraybackslash}X}%\n" +
               "\\newcolumntype{R}{>{\\raggedleft\\arraybackslash}X}%\n" +
               "\\newcolumntype{C}{>{\\centering\\arraybackslash}X}%\n" +
               "%---- End of Packages and Functions ------\n" +
               "\n" +
               "%-------------------------------------------\n" +
               "%%%%%%  CV STARTS HERE  %%%%%%%%%%%\n" +
               "%%%%%% DEFINE ELEMENTS HERE %%%%%%%\n" +
               "\\newcommand{\\name}{"+p.getFirstName() + " "+p.getLastName()+"}\n" +

               "\\newcommand{\\phone}{"+p.getNumberPhone()+"}\n" +
               "\\newcommand{\\emaila}{"+p.getEmail()+"}\n" +
               "\n" +
               "\\begin{document}\n" +
               "\\fontfamily{cmr}\\selectfont\n" +
               "%----------HEADING-----------------\n" +
               "\n" +
               "\\parbox{2.6cm}{%\n" +
               "\\includegraphics[width=2.35cm,clip]{"+image+"}\n" +
               "}\n" +
               "\\parbox{\\dimexpr\\linewidth-2.9cm\\relax}{\n" +
               "\\begin{tabularx}{\\linewidth}{L r} \\\\\n" +
               "  \\textbf{\\Large \\name} & {\\raisebox{0.0\\height}{\\footnotesize \\faPhone}\\ -\\phone}\\\\\n" +
               "  & \\href{mailto:\\emaila}{\\raisebox{0.0\\height}{\\footnotesize \\faEnvelope}\\ {\\emaila}} \\\\\n" +
               "  "+p.getFoonction()+" & \\href{https://www.yourLinkedinProfile.com/"+p.getLinkden()+"/}{\\raisebox{0.0\\height}{\\footnotesize \\faLinkedin}\\ {"+p.getLinkden()+"}} \\\\\n" +
               "\\end{tabularx}\n" +
               "}\n";

       Functions.clearLatexDocument();
       Functions.WriteInLatex(LatexContent);
    }

    @Override
    public void Write_Education() {
        super.Write_Education();
        Functions.WriteInLatex("\\vspace{-5.5mm} \n");
    }

    @Override
    public void Write_experiance() {
        String LatexContent = "\\section{\\textbf{Experience}}\n" +
                "    \\resumeSubHeadingListStart\n";
        for (int i = 0; i < p.getExperianceSize(); i++) {
            LatexContent += "% COMPANY " + (i + 1) + "\n" +
                    "        \\resumeSubheading\n" +
                    "        {" + p.getExperiance(i).Title + "}{" + p.getExperiance(i).location + "}\n" +
                    "            % POSITION 1\n" +
                    "            {" + p.getExperiance(i).Position + "}{" + p.getExperiance(i).Date + "-" + p.getExperiance(i).Finaldate + "}\n" +
                    "            \\resumeItemListStart\n" +
                    "                \\item{" + p.getExperiance(i).Descreption + "}\n" +
                    "            \\resumeItemListEnd\n";
        }
        LatexContent=LatexContent+"    \\resumeSubHeadingListEnd\n"+"\\vspace{-8.5mm}\n";
        Functions.WriteInLatex(LatexContent);

    }

    @Override
    public void Write_Projects() {
        String Latexcontent ="\\section{\\textbf{Personnel Projects}} \n" +
                "    \\resumeSubHeadingListStart\n";
        for (int i=0 ; i<p.getProjectsSize();i++){
            Latexcontent= Latexcontent+"\n\\resumeProject\n" +
                    "    {"+p.getProjects(i).Title+"}\n" +
                    "    {"+p.getProjects(i).getDescreption()+"}\n"+

                    "    {"+p.getProjects(i).Date+"}\n\n" +
                    "     \\resumeItemListStart";
                    if(p.getProjects(i).getLink()!=null)
                Latexcontent+=    "      \\item \\href{"+p.getProjects(i).Link+"}{\\textbf{\\underline{Click Here To Visit The Project}}}";
          Latexcontent+=          "          \\resumeItemListEnd\n" +
                    "        \\vspace{-2mm}\n\n";



        }
        Latexcontent=Latexcontent+"      \\resumeSubHeadingListEnd\n" +
                "\\vspace{-5.5mm}\n" +
                "\n";
        Functions.WriteInLatex(Latexcontent);
    }

    @Override
    void write_skills() {
        super.write_skills();
    }

    @Override
    void createCv() {
        Write_PersoInfos();
        Write_Education();
        Write_experiance();
        Write_Projects();
write_skills();
        Functions.clearAUXDocument();
        Functions.convertLatexToPdf();

    }
}
