package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 584893
 */
public class NoteServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String edit = request.getParameter("edit");
        
        // Read text file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line;
        String title = br.readLine();
        String contents = "";

        while ((line = br.readLine()) != null) {
            contents += "\n" + line;
        }

        Note note = new Note(title, contents);
        request.setAttribute("note", note);
            
        if (edit == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);   
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);   
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String edit = request.getParameter("edit");
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        // Write to text file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.println(title);
        pw.println(contents);
        pw.close();
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

  
}
