package test.app.service;

import test.app.model.ApplicationProperties;
import test.app.pojo.Entry;
import test.app.pojo.TargetEntries;
import test.app.pojo.TargetEntry;

import java.util.ArrayList;

/**
 * Created by belstrel on 28.07.17.
 */
public class MainServiceImpl {

    private  DAOServiceImpl daoService;
    private XMLServiceImpl xmlService;

    public MainServiceImpl(){
        this.daoService = new DAOServiceImpl();
        this.xmlService = new XMLServiceImpl();
    }

    /**
     * The method of initiating the process of transformation
     */
    public void execute(){
        System.out.println("    INFO: update fields in database with " + ApplicationProperties.PROPS.getFieldsCount().toString()+ " records ... ");
        daoService.updateFieldsoInDatabase();
        System.out.println("SUCCESS.");
        System.out.println("    INFO: select fields from test database ... ");
        ArrayList<Entry> entries = daoService.selectFieldsFromDatabase();
        System.out.println("SUCCESS.");
        System.out.println("    INFO: create first xml file ... ");
        xmlService.createFirstXmlFile(entries);
        System.out.println("SUCCESS.");
        System.out.println("    INFO: transform one xml file to other ... ");
        xmlService.transformToSecondXml();
        System.out.println("SUCCESS.");
        System.out.println("    INFO: unmarshal second xls ...");
        TargetEntries targetEntries = xmlService.getEntriesFromSecondXml();
        System.out.println("SUCCESS.");
        long sumallFields = 0l;
        if(targetEntries != null){
            for (TargetEntry entry : targetEntries.getEntries()){
                sumallFields += entry.getField();
            }
        }
        System.out.println("\n RESULT = "+sumallFields + "\n");












    }










}
