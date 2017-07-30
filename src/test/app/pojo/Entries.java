package test.app.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by belstrel on 28.07.17.
 */
@XmlRootElement(name= "entries")
public class Entries implements Serializable{

    private ArrayList<Entry> entries;

    public ArrayList<Entry> getEntries(){
        return entries;
    }

    @XmlElement(name= "entry")
    public void setEntries(ArrayList<Entry> entries){
        this.entries = entries;
    }

}
