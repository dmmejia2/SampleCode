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
 * Source Class: DefaultExternal <br>
 * @version generated on Thu Nov 16 09:04:53 MST 2017 by danielmejia
 */
public class DefaultExternal extends WrappedIndividualImpl implements External {

    public DefaultExternal(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#contains
     */
     
    public Collection<? extends WrappedIndividual> getContains() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_CONTAINS,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasContains() {
	   return !getContains().isEmpty();
    }

    public void addContains(WrappedIndividual newContains) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_CONTAINS,
                                       newContains);
    }

    public void removeContains(WrappedIndividual oldContains) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_CONTAINS,
                                          oldContains);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#has
     */
     
    public Collection<? extends WrappedIndividual> getHas() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HAS,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasHas() {
	   return !getHas().isEmpty();
    }

    public void addHas(WrappedIndividual newHas) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HAS,
                                       newHas);
    }

    public void removeHas(WrappedIndividual oldHas) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HAS,
                                          oldHas);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#hasAge
     */
     
    public Collection<? extends Integer> getHasAge() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASAGE, Integer.class);
    }

    public boolean hasHasAge() {
		return !getHasAge().isEmpty();
    }

    public void addHasAge(Integer newHasAge) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASAGE, newHasAge);
    }

    public void removeHasAge(Integer oldHasAge) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASAGE, oldHasAge);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#hasAlcohol
     */
     
    public Collection<? extends Object> getHasAlcohol() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOL, Object.class);
    }

    public boolean hasHasAlcohol() {
		return !getHasAlcohol().isEmpty();
    }

    public void addHasAlcohol(Object newHasAlcohol) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOL, newHasAlcohol);
    }

    public void removeHasAlcohol(Object oldHasAlcohol) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOL, oldHasAlcohol);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#hasAlcoholBloodContent
     */
     
    public Collection<? extends Object> getHasAlcoholBloodContent() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOLBLOODCONTENT, Object.class);
    }

    public boolean hasHasAlcoholBloodContent() {
		return !getHasAlcoholBloodContent().isEmpty();
    }

    public void addHasAlcoholBloodContent(Object newHasAlcoholBloodContent) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOLBLOODCONTENT, newHasAlcoholBloodContent);
    }

    public void removeHasAlcoholBloodContent(Object oldHasAlcoholBloodContent) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOLBLOODCONTENT, oldHasAlcoholBloodContent);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#hasAlcoholResult
     */
     
    public Collection<? extends Object> getHasAlcoholResult() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOLRESULT, Object.class);
    }

    public boolean hasHasAlcoholResult() {
		return !getHasAlcoholResult().isEmpty();
    }

    public void addHasAlcoholResult(Object newHasAlcoholResult) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOLRESULT, newHasAlcoholResult);
    }

    public void removeHasAlcoholResult(Object oldHasAlcoholResult) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOLRESULT, oldHasAlcoholResult);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#hasAlcoholSpecimanType
     */
     
    public Collection<? extends Integer> getHasAlcoholSpecimanType() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOLSPECIMANTYPE, Integer.class);
    }

    public boolean hasHasAlcoholSpecimanType() {
		return !getHasAlcoholSpecimanType().isEmpty();
    }

    public void addHasAlcoholSpecimanType(Integer newHasAlcoholSpecimanType) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOLSPECIMANTYPE, newHasAlcoholSpecimanType);
    }

    public void removeHasAlcoholSpecimanType(Integer oldHasAlcoholSpecimanType) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASALCOHOLSPECIMANTYPE, oldHasAlcoholSpecimanType);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#hasDeployedAirbag
     */
     
    public Collection<? extends Integer> getHasDeployedAirbag() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASDEPLOYEDAIRBAG, Integer.class);
    }

    public boolean hasHasDeployedAirbag() {
		return !getHasDeployedAirbag().isEmpty();
    }

    public void addHasDeployedAirbag(Integer newHasDeployedAirbag) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASDEPLOYEDAIRBAG, newHasDeployedAirbag);
    }

    public void removeHasDeployedAirbag(Integer oldHasDeployedAirbag) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASDEPLOYEDAIRBAG, oldHasDeployedAirbag);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#hasGender
     */
     
    public Collection<? extends Integer> getHasGender() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASGENDER, Integer.class);
    }

    public boolean hasHasGender() {
		return !getHasGender().isEmpty();
    }

    public void addHasGender(Integer newHasGender) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASGENDER, newHasGender);
    }

    public void removeHasGender(Integer oldHasGender) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASGENDER, oldHasGender);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#hasHelmet
     */
     
    public Collection<? extends Integer> getHasHelmet() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASHELMET, Integer.class);
    }

    public boolean hasHasHelmet() {
		return !getHasHelmet().isEmpty();
    }

    public void addHasHelmet(Integer newHasHelmet) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASHELMET, newHasHelmet);
    }

    public void removeHasHelmet(Integer oldHasHelmet) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASHELMET, oldHasHelmet);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#hasInjury
     */
     
    public Collection<? extends Integer> getHasInjury() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASINJURY, Integer.class);
    }

    public boolean hasHasInjury() {
		return !getHasInjury().isEmpty();
    }

    public void addHasInjury(Integer newHasInjury) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASINJURY, newHasInjury);
    }

    public void removeHasInjury(Integer oldHasInjury) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASINJURY, oldHasInjury);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#hasInjurySeverity
     */
     
    public Collection<? extends Integer> getHasInjurySeverity() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASINJURYSEVERITY, Integer.class);
    }

    public boolean hasHasInjurySeverity() {
		return !getHasInjurySeverity().isEmpty();
    }

    public void addHasInjurySeverity(Integer newHasInjurySeverity) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASINJURYSEVERITY, newHasInjurySeverity);
    }

    public void removeHasInjurySeverity(Integer oldHasInjurySeverity) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASINJURYSEVERITY, oldHasInjurySeverity);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/smart-cities/Mobility#isPersonType
     */
     
    public Collection<? extends Integer> getIsPersonType() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ISPERSONTYPE, Integer.class);
    }

    public boolean hasIsPersonType() {
		return !getIsPersonType().isEmpty();
    }

    public void addIsPersonType(Integer newIsPersonType) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ISPERSONTYPE, newIsPersonType);
    }

    public void removeIsPersonType(Integer oldIsPersonType) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ISPERSONTYPE, oldIsPersonType);
    }


}
