package test.app.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * Created by belstrel on 28.07.17.
 */
public class TargetEntry implements Serializable {

    private  Integer field;

    public Integer getField(){return field;}

    @XmlAttribute(name = "field")
    public void setField(Integer field){
        this.field = field;
    }

    @Override
    public String toString() {
        return "TargetEntry{" +
                "field=" + field +
                '}';
    }


    @Override
    public int hashCode() {
        return getField() != null ? getField().hashCode() : 0;
    }
}
