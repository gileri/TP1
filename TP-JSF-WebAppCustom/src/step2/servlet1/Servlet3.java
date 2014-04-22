package step2.servlet1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step1.db.DB;
import step2.model.UserModelBean;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DB db;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        // Verifie si DB existe dans l'espace de memoire partage entre les
        // servlet
        // si oui on les recupere, si non on le cree et on l'ajoute dans
        // l'espace de memoire
        // partage entre les servlet
        if (getServletContext().getAttribute("BD") != null) {
            db = (DB) getServletContext().getAttribute("BD");
        } else {
            db = new DB();
            getServletContext().setAttribute("BD", db);
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // Nothing to do
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)

    throws ServletException, IOException {
        UserModelBean user = (UserModelBean) request.getSession().getAttribute(
                "myUser");
        // TODO Sauvegarder l'utilisateur user (creer dans la page jsp et stocke
        // dans la memoire session) dans la base de donnees
        // TODO Rediriger la page courante vers la page /step2/display.jsp
    }
}
