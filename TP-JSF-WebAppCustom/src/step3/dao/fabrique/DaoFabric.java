package step3.dao.fabrique;

import step3.dao.instance.RecipeDao;
import step3.dao.instance.UserDao;

public final class DaoFabric {
    // L'utilisation du mot cle volatile permet, en Java version 5 et superieur,
    // permet d'eviter le cas ou "Singleton.instance" est non-nul,
    // mais pas encore "reellement" instancie.
    // De Java version 1.2 a 1.4, il est possible d'utiliser la classe //
    // ThreadLocal.
    private static volatile DaoFabric instance = null;
    private static final String DB_HOST = " db-tp.cpe.fr ";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "binome32";
    private static final String DB_USER = " binome32";
    private static final String DB_PWD = " binome32";

    private DaoFabric() {
        super();
    }

    /**
     * Methode permettant de renvoyer une instance de la classe Singleton *
     * 
     * @return Retourne l'instance du singleton.
     */
    public final static DaoFabric getInstance() {
        // Le "Double-Checked Singleton"/"Singleton doublement verifie" permet
        // // d'eviter un appel couteux a synchronized,
        // une fois que l'instanciation est faite.
        if (DaoFabric.instance == null) {
            // Le mot-cle synchronized sur ce bloc empeche toute instanciation
            // // multiple meme par differents "threads".
            synchronized (DaoFabric.class) {
                if (DaoFabric.instance == null) {
                    DaoFabric.instance = new DaoFabric();
                }
            }
        }
        return DaoFabric.instance;
    }

    public UserDao createUserDao() {
        UserDao userDao = new UserDao(this.DB_HOST, this.DB_PORT, this.DB_NAME,
                this.DB_USER, this.DB_PWD);
        return userDao;
    }

    public RecipeDao createRecipesDao() {
        RecipeDao receipesDao = new RecipeDao(this.DB_HOST, this.DB_PORT,
                this.DB_NAME, this.DB_USER, this.DB_PWD);
        return receipesDao;
    }
}