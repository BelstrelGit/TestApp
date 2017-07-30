package test.app.pojo;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Created by belstrel on 28.07.17.
 */
public class Entry implements Serializable{

    private Integer field;

    public Integer getField(){
        return field;
    }

    @XmlElement(name= "field")
    public void setField(Integer field){
        this.field = field;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "field=" + field +
                '}';
    }

    @Override
    public int hashCode() {
        return getField() != null ? field.hashCode() : 0;
    }
}
