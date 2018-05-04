package cs.utep.freightPerformance;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uk.ac.manchester.cs.owl.owlapi.OWL2DatatypeImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        

    	String ontFile = "OurOntology.owl";

    	String prefix = "file:///";

    	URI basePhysicalURI = URI.create(prefix + ontFile.replace("\\", "/"));
    	OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

    	try {
    		OWLOntology ontology = manager.createOntology(IRI.create(basePhysicalURI));
    		OWLDataFactory factory = manager.getOWLDataFactory();
    		
    		
    		/**
    		 * Adding Classes
    		 */
    		//Adding Employee class
    		//What is an IRI? https://www.w3.org/TR/owl2-syntax/#IRIs
    		OWLClass employeeClass = factory.getOWLClass(IRI.create(prefix + ontFile + "#Employee"));
    		OWLAxiom employeeClassAxiom = factory.getOWLDeclarationAxiom(employeeClass);
    		manager.addAxiom(ontology, employeeClassAxiom);
    		
    		OWLClass departmentClass = factory.getOWLClass(IRI.create(prefix + ontFile + "#Department"));
    		OWLAxiom departmentClassAxiom = factory.getOWLDeclarationAxiom(departmentClass);
    		manager.addAxiom(ontology, departmentClassAxiom);
    		
    		/**
    		 * Adding Data Properties
    		 */
			//Adding hasFirstName data property 
			OWLDataProperty hasFirstNameProperty = factory.getOWLDataProperty(IRI.create(prefix + ontFile + "#hasFirstName"));

			OWLAxiom hasFirstNamePropertyAxiom = factory.getOWLDataPropertyDomainAxiom(hasFirstNameProperty, employeeClass);
			manager.applyChange(new AddAxiom(ontology,hasFirstNamePropertyAxiom));


			OWLDatatype stringOwlDataType =  OWL2DatatypeImpl.getDatatype(OWL2Datatype.XSD_STRING);
			OWLDataPropertyRangeAxiom hasNameRangeAxiom = factory.getOWLDataPropertyRangeAxiom(hasFirstNameProperty, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasNameRangeAxiom));
			
			/**
			 * Adding Object Property
			 */
			//Adding Object Property
			OWLObjectProperty worksAtObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix + ontFile + "#worksAt"));
			OWLAxiom worksAtObjectPropertyDomainAxiom = factory.getOWLObjectPropertyDomainAxiom(worksAtObjectProperty, employeeClass);
			manager.applyChange(new AddAxiom(ontology,worksAtObjectPropertyDomainAxiom));

			OWLObjectPropertyRangeAxiom worksAtObjectPropertyRangeAxiom = factory.getOWLObjectPropertyRangeAxiom(worksAtObjectProperty, departmentClass);
			manager.applyChange(new AddAxiom(ontology,worksAtObjectPropertyRangeAxiom));
			
			/**
			 * Add individual
			 */
			//Employee
			OWLNamedIndividual employeeIndividual = factory.getOWLNamedIndividual(IRI.create("Employee1"));
			OWLClassAssertionAxiom employeeClassAssertion = factory.getOWLClassAssertionAxiom(employeeClass, employeeIndividual);
			manager.applyChange(new AddAxiom(ontology,employeeClassAssertion));


			OWLAxiom hasFirstNameIndividualAxiom = factory.getOWLDataPropertyAssertionAxiom(hasFirstNameProperty, employeeIndividual, "Diego");
			manager.applyChange(new AddAxiom(ontology, hasFirstNameIndividualAxiom));
			
			
			//My Individual Test - Department Individual
			OWLNamedIndividual departmentIndividual = factory.getOWLNamedIndividual(IRI.create("Department1"));
			OWLClassAssertionAxiom departmentClassAssertion = factory.getOWLClassAssertionAxiom(departmentClass, departmentIndividual);
			manager.applyChange(new AddAxiom(ontology,departmentClassAssertion));
				
			/**
			 * Add object properties between individuals
			 */
			OWLAxiom worksAtAxiom = factory.getOWLObjectPropertyAssertionAxiom(worksAtObjectProperty, employeeIndividual, departmentIndividual);
			manager.applyChange(new AddAxiom(ontology, worksAtAxiom));


    		
    		File file = new File(ontFile);
			file.createNewFile();

			FileOutputStream outputStream = new FileOutputStream(file);
			manager.saveOntology(ontology, outputStream);
			System.out.println("Done Saving");


    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	//
    	String xmlURL = "https://dl.dropboxusercontent.com/u/42085525/example.xml";

		try {


			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlURL);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("employee");

			System.out.println("----------------------------");

			for (int i = 0; i < nList.getLength(); i++) {

				Node nNode = nList.item(i);

				System.out.println("Employee tag #" + (i+1) + "\n");

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("ID : " + eElement.getAttribute("id"));
					System.out.println("First Name : " + eElement.getElementsByTagName("firstName").item(0).getTextContent());
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
					System.out.println("Works At: " + eElement.getElementsByTagName("worksAt").item(0).getTextContent());


				}
			}

			nList = doc.getElementsByTagName("department");

			System.out.println("----------------------------");

			for (int i = 0; i < nList.getLength(); i++) {

				Node nNode = nList.item(i);

				System.out.println("Department tag #" + (i+1) + "\n");

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("ID : " + eElement.getAttribute("id"));
					System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
}
