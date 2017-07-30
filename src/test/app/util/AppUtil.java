package test.app.util;


import test.app.AppConstants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by belstrel on 28.07.17.
 */
public class AppUtil {
    /*Format Date to String
     *@param date - Date
     *@return String
     */
    public static String formatDate( Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.DATE_FORMAT);
        String result = null;
        try{
            result = sdf.format(date);
        }catch( Exception ex){
            System.out.println("ERROR: Can not format date ...");
        }
        return result;
    }
}
