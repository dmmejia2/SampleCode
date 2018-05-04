package Protege.impl;

import Protege.*;


import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultCOSO2NOXEmmission <br>
 * @version generated on Mon Mar 06 21:12:30 MST 2017 by danielmejia
 */
public class DefaultCOSO2NOXEmmission extends WrappedIndividualImpl implements COSO2NOXEmmission {

    public DefaultCOSO2NOXEmmission(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasCommuterStressIndex.Value
     */
     
    public Collection<? extends Object> getHasCommuterStressIndex.Value() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCOMMUTERSTRESSINDEX.VALUE, Object.class);
    }

    public boolean hasHasCommuterStressIndex.Value() {
		return !getHasCommuterStressIndex.Value().isEmpty();
    }

    public void addHasCommuterStressIndex.Value(Object newHasCommuterStressIndex.Value) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCOMMUTERSTRESSINDEX.VALUE, newHasCommuterStressIndex.Value);
    }

    public void removeHasCommuterStressIndex.Value(Object oldHasCommuterStressIndex.Value) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCOMMUTERSTRESSINDEX.VALUE, oldHasCommuterStressIndex.Value);
    }


    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasCommuterStressIndex.id
     */
     
    public Collection<? extends Integer> getHasCommuterStressIndex.id() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCOMMUTERSTRESSINDEX.ID, Integer.class);
    }

    public boolean hasHasCommuterStressIndex.id() {
		return !getHasCommuterStressIndex.id().isEmpty();
    }

    public void addHasCommuterStressIndex.id(Integer newHasCommuterStressIndex.id) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCOMMUTERSTRESSINDEX.ID, newHasCommuterStressIndex.id);
    }

    public void removeHasCommuterStressIndex.id(Integer oldHasCommuterStressIndex.id) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCOMMUTERSTRESSINDEX.ID, oldHasCommuterStressIndex.id);
    }


    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasCongestionCost.id
     */
     
    public Collection<? extends Integer> getHasCongestionCost.id() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONGESTIONCOST.ID, Integer.class);
    }

    public boolean hasHasCongestionCost.id() {
		return !getHasCongestionCost.id().isEmpty();
    }

    public void addHasCongestionCost.id(Integer newHasCongestionCost.id) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONGESTIONCOST.ID, newHasCongestionCost.id);
    }

    public void removeHasCongestionCost.id(Integer oldHasCongestionCost.id) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONGESTIONCOST.ID, oldHasCongestionCost.id);
    }


    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasCongestionTime.id
     */
     
    public Collection<? extends Integer> getHasCongestionTime.id() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONGESTIONTIME.ID, Integer.class);
    }

    public boolean hasHasCongestionTime.id() {
		return !getHasCongestionTime.id().isEmpty();
    }

    public void addHasCongestionTime.id(Integer newHasCongestionTime.id) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONGESTIONTIME.ID, newHasCongestionTime.id);
    }

    public void removeHasCongestionTime.id(Integer oldHasCongestionTime.id) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONGESTIONTIME.ID, oldHasCongestionTime.id);
    }


    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasFatalIncident.id
     */
     
    public Collection<? extends Integer> getHasFatalIncident.id() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASFATALINCIDENT.ID, Integer.class);
    }

    public boolean hasHasFatalIncident.id() {
		return !getHasFatalIncident.id().isEmpty();
    }

    public void addHasFatalIncident.id(Integer newHasFatalIncident.id) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASFATALINCIDENT.ID, newHasFatalIncident.id);
    }

    public void removeHasFatalIncident.id(Integer oldHasFatalIncident.id) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASFATALINCIDENT.ID, oldHasFatalIncident.id);
    }


    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasGasEmission.id
     */
     
    public Collection<? extends Integer> getHasGasEmission.id() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASGASEMISSION.ID, Integer.class);
    }

    public boolean hasHasGasEmission.id() {
		return !getHasGasEmission.id().isEmpty();
    }

    public void addHasGasEmission.id(Integer newHasGasEmission.id) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASGASEMISSION.ID, newHasGasEmission.id);
    }

    public void removeHasGasEmission.id(Integer oldHasGasEmission.id) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASGASEMISSION.ID, oldHasGasEmission.id);
    }


    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasGasEmmission.Value
     */
     
    public Collection<? extends Object> getHasGasEmmission.Value() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASGASEMMISSION.VALUE, Object.class);
    }

    public boolean hasHasGasEmmission.Value() {
		return !getHasGasEmmission.Value().isEmpty();
    }

    public void addHasGasEmmission.Value(Object newHasGasEmmission.Value) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASGASEMMISSION.VALUE, newHasGasEmmission.Value);
    }

    public void removeHasGasEmmission.Value(Object oldHasGasEmmission.Value) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASGASEMMISSION.VALUE, oldHasGasEmmission.Value);
    }


    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasLocation
     */
     
    public Collection<? extends Object> getHasLocation() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLOCATION, Object.class);
    }

    public boolean hasHasLocation() {
		return !getHasLocation().isEmpty();
    }

    public void addHasLocation(Object newHasLocation) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLOCATION, newHasLocation);
    }

    public void removeHasLocation(Object oldHasLocation) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLOCATION, oldHasLocation);
    }


    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasTime
     */
     
    public Collection<? extends Object> getHasTime() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASTIME, Object.class);
    }

    public boolean hasHasTime() {
		return !getHasTime().isEmpty();
    }

    public void addHasTime(Object newHasTime) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASTIME, newHasTime);
    }

    public void removeHasTime(Object oldHasTime) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASTIME, oldHasTime);
    }


    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasUnit
     */
     
    public Collection<? extends Object> getHasUnit() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASUNIT, Object.class);
    }

    public boolean hasHasUnit() {
		return !getHasUnit().isEmpty();
    }

    public void addHasUnit(Object newHasUnit) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASUNIT, newHasUnit);
    }

    public void removeHasUnit(Object oldHasUnit) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASUNIT, oldHasUnit);
    }


    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasValue
     */
     
    public Collection<? extends Object> getHasValue() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVALUE, Object.class);
    }

    public boolean hasHasValue() {
		return !getHasValue().isEmpty();
    }

    public void addHasValue(Object newHasValue) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVALUE, newHasValue);
    }

    public void removeHasValue(Object oldHasValue) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVALUE, oldHasValue);
    }


    /* ***************************************************
     * Data Property http://anonymous.org/resource/fpFreighPerformanceMetrics.owl#hasWeatherConditionID.ID
     */
     
    public Collection<? extends String> getHasWeatherConditionID.ID() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASWEATHERCONDITIONID.ID, String.class);
    }

    public boolean hasHasWeatherConditionID.ID() {
		return !getHasWeatherConditionID.ID().isEmpty();
    }

    public void addHasWeatherConditionID.ID(String newHasWeatherConditionID.ID) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASWEATHERCONDITIONID.ID, newHasWeatherConditionID.ID);
    }

    public void removeHasWeatherConditionID.ID(String oldHasWeatherConditionID.ID) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASWEATHERCONDITIONID.ID, oldHasWeatherConditionID.ID);
    }


}