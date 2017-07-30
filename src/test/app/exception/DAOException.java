package test.app.exception;

/**
 * Created by belstrel on 28.07.17.
 */
public class DAOException  extends  Exception{

    /**Default constructor*/
    public DAOException(){
        super();
    }

    /**Constructs new DAOException with specified detail message*/
    public DAOException(String message){
        super(message);
    }

    /**Constructs new DAOException with specified params*/

    public DAOException(String p_arg0, Throwable p_arg1){
        super( p_arg0, p_arg1);
    }

    /**Constructs new DAOException with specified throwable param*/
    public DAOException(Throwable p_arg0){
        super(p_arg0);
    }
}
