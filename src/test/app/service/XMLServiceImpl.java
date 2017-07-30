package test.app.service;

/**
 * Created by belstrel on 28.07.17.
 */


import com.sun.jmx.remote.internal.Unmarshal;
import test.app.AppConstants;
import test.app.pojo.Entries;
import test.app.pojo.Entry;
import test.app.pojo.TargetEntries;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class XMLServiceImpl {

    /**
     * Marchal Java class to XML
     */
    public void createFirstXmlFile(ArrayList<Entry> entriesList) {
        try {
            JAXBContext js = JAXBContext.newInstance(test.app.pojo.Entries.class);
            Marshaller marshaller = js.createMarshaller();
            Entries entries = new Entries();
            entries.setEntries(entriesList);
            OutputStream os = new FileOutputStream(AppConstants.FIRST_XML_FILE);
            marshaller.marshal(entries, os);
        } catch (JAXBException | FileNotFoundException e) {
            System.err.println("ERROR:  Can not create xml file, " + e.getMessage());
            System.err.println("Program terminated");
            System.exit(0);

        }
    }

/**
 * Transform one XML to other
 */
    public void transformToSecondXml(){
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer =null;
        try{
            Source xslt = new StreamSource(new File(AppConstants.TRANSFER_XLST_FILE));
            transformer = factory.newTransformer(xslt);
            Source source = new StreamSource(new File(AppConstants.FIRST_XML_FILE));
            transformer.transform(source, new StreamResult(new File(AppConstants.SECOND_XML_FILE)));
        }catch(TransformerException e ){
            System.err.println("ERROR:  Can not transform to second xml file, " + e.getMessage());
            System.err.println("Program terminated");
            System.exit(0);
        }

    }
    /**
     * Unmarshal XML to Java class
     */
    public TargetEntries getEntriesFromSecondXml(){
        TargetEntries entries = null;
        try{
            JAXBContext jc = JAXBContext.newInstance(test.app.pojo.TargetEntries.class);
            Unmarshaller u = jc.createUnmarshaller();
            entries = (TargetEntries) u.unmarshal(new File(AppConstants.SECOND_XML_FILE));
        } catch (JAXBException e) {
            System.err.println("ERROR:  Can not unmarshal second xml file, " + e.getMessage());
            System.err.println("Program terminated");
            System.exit(0);
        }
        return entries;
    }

}