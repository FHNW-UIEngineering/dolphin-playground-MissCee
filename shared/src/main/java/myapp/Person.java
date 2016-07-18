package myapp;

import javafx.beans.property.Property;

import org.opendolphin.core.Attribute;
import org.opendolphin.core.PresentationModel;

import util.AttributeWrapper;
import util.Veneer;

/**
 * The Veneer class for a Person.
 *
 * @author Dieter Holz
 */
public class Person extends Veneer {

    public Person(PresentationModel pm) {
        super(pm);
    }

    public Attribute firstName() {
        return getPresentationModel().getAt(PersonPM.ATT.FIRSTNAME.name());
    }

    public Property<String> nameProperty() {
        return new AttributeWrapper<>(firstName());
    }

    public String getFirstName() {
        return (String) firstName().getValue();
    }

    public void setFirstName(String firstName) {
        firstName().setValue(firstName);
    }

}
