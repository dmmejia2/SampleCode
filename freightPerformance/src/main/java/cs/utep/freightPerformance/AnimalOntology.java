package cs.utep.freightPerformance;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

import uk.ac.manchester.cs.owl.owlapi.OWL2DatatypeImpl;

public class AnimalOntology {


	public static void main(String[] args) throws OWLOntologyCreationException{

		//Output name
		String ontFile = "MyAnimalTest.owl";


		//Need managers first
		//Open a factory
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLDataFactory factory = manager.getOWLDataFactory();
		//Shell of classes
		File file = new File("/Users/danielmejia/Documents/AnimalOntologyClasses.owl");

		// Now load the local copy
		OWLOntology animal = manager.loadOntologyFromOntologyDocument(file);
		PrefixManager pm = new DefaultPrefixManager("http://www.semanticscience.org/resource/petOntology.owl#");

		// Use the prefix manager and just specify an abbreviated IRI
		//OWLClass petClass = factory.getOWLClass(":Pet", pm);
		OWLClass dogClass = factory.getOWLClass(":Dog", pm);
		OWLNamedIndividual dogIndividual = factory.getOWLNamedIndividual(":Hulk", pm);
		OWLNamedIndividual dogIndividual2 = factory.getOWLNamedIndividual(":Thor", pm);

		OWLClassAssertionAxiom classAssertion = factory.getOWLClassAssertionAxiom(dogClass, dogIndividual);
		OWLClassAssertionAxiom classAssertion2 = factory.getOWLClassAssertionAxiom(dogClass, dogIndividual2);
		manager.applyChange(new AddAxiom(animal,classAssertion));
		manager.applyChange(new AddAxiom(animal,classAssertion2));

		//animal.get
		for (OWLClass cls : animal.getClassesInSignature()) {
			System.out.println(cls);
		}

		// We can always obtain the location where an ontology was loaded from
		IRI documentIRI = manager.getOntologyDocumentIRI(animal);




		OWLDatatype integerOwlDataType =  OWL2DatatypeImpl.getDatatype(OWL2Datatype.XSD_INTEGER);
		OWLDatatype doubleOwlDataType =  OWL2DatatypeImpl.getDatatype(OWL2Datatype.XSD_DOUBLE);
		OWLDatatype stringOwlDataType =  OWL2DatatypeImpl.getDatatype(OWL2Datatype.XSD_STRING);
		OWLDatatype dateOwlDataType =  OWL2DatatypeImpl.getDatatype(OWL2Datatype.XSD_DATE_TIME);

		//OWLClass PetClass = factory.getOWLClass(IRI.create(prefix+ "Pet"));
		//OWLClass CatClass = factory.getOWLClass(IRI.create(prefix+ "Cat"));

		//manager.applyChange(new AddAxiom(animal,factory.getOWLSubClassOfAxiom(CatClass,PetClass)));
		File outFile = new File(ontFile);
		try {
			outFile.createNewFile();
			FileOutputStream outputStream = new FileOutputStream(outFile);
			manager.saveOntology(animal, outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OWLOntologyStorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("OUT FILE: "+outFile.getAbsolutePath());
		System.out.println("Loaded ontology: " + animal);
		System.out.println("    from: " + documentIRI);
	}
}

