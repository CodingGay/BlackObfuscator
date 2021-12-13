package org.jf.dexlib2.iface;



import java.util.Set;

/**
 * This represents a basic annotation, and serves as a common superclass for Annotation and AnnotationEncodedValue
 */
public interface BasicAnnotation {
    /**
     * Gets the type of this annotation.
     * <p>
     * This will be the type descriptor of the class that defines this annotation.
     *
     * @return The type of this annotation
     */

    String getType();

    /**
     * Gets a set of the name/value elements associated with this annotation.
     * <p>
     * The elements in the returned set will be unique with respect to the element name.
     *
     * @return A set of AnnotationElements
     */

    Set<? extends AnnotationElement> getElements();
}
