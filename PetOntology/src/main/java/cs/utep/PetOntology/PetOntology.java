package cs.utep.PetOntology;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

public class PetOntology {
	public static void main(String[] args) throws OWLOntologyCreationException {



		String ontFile = "MyPetOntology.owl";
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLDataFactory factory = manager.getOWLDataFactory();

		//The PetOntology that you created (Concepts & Data Properties)
		File file = new File("/Users/danielmejia/Documents/workspace/AnimalOntologyClasses.owl");


		// Now load the local copy
		OWLOntology animal = manager.loadOntologyFromOntologyDocument(file);
		PrefixManager pm = new DefaultPrefixManager("http://www.semanticscience.org/resource/petOntology.owl#");


		OWLClass dogClass = factory.getOWLClass("Dog", pm);
		OWLClass catClass = factory.getOWLClass("Cat", pm);
		OWLNamedIndividual dogIndividual = factory.getOWLNamedIndividual("Thor", pm);
		OWLNamedIndividual dogIndividual2 = factory.getOWLNamedIndividual("Hulk", pm);
		OWLNamedIndividual dogIndividual3 = factory.getOWLNamedIndividual("Black_Panther", pm);
		
		OWLNamedIndividual catIndividual = factory.getOWLNamedIndividual("Grumpy_Cat", pm);
		OWLNamedIndividual catIndividual2 = factory.getOWLNamedIndividual("Fluffy", pm);
		OWLNamedIndividual catIndividual3 = factory.getOWLNamedIndividual("Whiskers", pm);

		OWLClassAssertionAxiom classAssertion = factory.getOWLClassAssertionAxiom(dogClass, dogIndividual);
		OWLClassAssertionAxiom classAssertion2 = factory.getOWLClassAssertionAxiom(dogClass, dogIndividual2);
		OWLClassAssertionAxiom classAssertion3 = factory.getOWLClassAssertionAxiom(dogClass, dogIndividual3);
		
		OWLClassAssertionAxiom classAssertion4 = factory.getOWLClassAssertionAxiom(catClass, catIndividual);
		OWLClassAssertionAxiom classAssertion5 = factory.getOWLClassAssertionAxiom(catClass, catIndividual2);
		OWLClassAssertionAxiom classAssertion6 = factory.getOWLClassAssertionAxiom(catClass, catIndividual3);
		
	
		manager.applyChange(new AddAxiom(animal,classAssertion));
		manager.applyChange(new AddAxiom(animal,classAssertion2));
		manager.applyChange(new AddAxiom(animal,classAssertion3));
		
		manager.applyChange(new AddAxiom(animal,classAssertion4));
		manager.applyChange(new AddAxiom(animal,classAssertion5));
		manager.applyChange(new AddAxiom(animal,classAssertion6));
		
		OWLDataProperty hasName = factory.getOWLDataProperty("hasName",pm);
		OWLAxiom hasNameAxiom = factory.getOWLDataPropertyAssertionAxiom(hasName, dogIndividual, "Thor");
		
		OWLDataProperty hasName2 = factory.getOWLDataProperty("hasName",pm);
		OWLAxiom hasNameAxiom2 = factory.getOWLDataPropertyAssertionAxiom(hasName2, dogIndividual2, "Hulk");
		
		OWLDataProperty hasName3 = factory.getOWLDataProperty("hasName",pm);
		OWLAxiom hasNameAxiom3 = factory.getOWLDataPropertyAssertionAxiom(hasName3, dogIndividual3, "Black_Panther");
		
		OWLDataProperty hasAge = factory.getOWLDataProperty("hasAge",pm);
		OWLAxiom hasAgeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasAge, dogIndividual, 2);
		
		OWLDataProperty hasAge2 = factory.getOWLDataProperty("hasAge",pm);
		OWLAxiom hasAgeAxiom2 = factory.getOWLDataPropertyAssertionAxiom(hasAge2, dogIndividual2, 1);
		
		OWLDataProperty hasAge3 = factory.getOWLDataProperty("hasAge",pm);
		OWLAxiom hasAgeAxiom3 = factory.getOWLDataPropertyAssertionAxiom(hasAge3, dogIndividual3, 4);
		
		manager.applyChange(new AddAxiom(animal, hasNameAxiom));
		manager.applyChange(new AddAxiom(animal, hasNameAxiom2));
		manager.applyChange(new AddAxiom(animal, hasNameAxiom3));
		
		manager.applyChange(new AddAxiom(animal, hasAgeAxiom));
		manager.applyChange(new AddAxiom(animal, hasAgeAxiom2));
		manager.applyChange(new AddAxiom(animal, hasAgeAxiom3));
		
		
		OWLDataProperty hasName4 = factory.getOWLDataProperty("hasName",pm);
		OWLAxiom hasNameAxiom4 = factory.getOWLDataPropertyAssertionAxiom(hasName4, catIndividual, "Grumpy_Cat");
		
		OWLDataProperty hasName5 = factory.getOWLDataProperty("hasName",pm);
		OWLAxiom hasNameAxiom5 = factory.getOWLDataPropertyAssertionAxiom(hasName5, catIndividual2, "Fluffy");
		
		OWLDataProperty hasName6 = factory.getOWLDataProperty("hasName",pm);
		OWLAxiom hasNameAxiom6 = factory.getOWLDataPropertyAssertionAxiom(hasName6, catIndividual3, "Whiskers");
		
		OWLDataProperty hasAge4 = factory.getOWLDataProperty("hasAge",pm);
		OWLAxiom hasAgeAxiom4 = factory.getOWLDataPropertyAssertionAxiom(hasAge4, catIndividual, 3);
		
		OWLDataProperty hasAge5 = factory.getOWLDataProperty("hasAge",pm);
		OWLAxiom hasAgeAxiom5 = factory.getOWLDataPropertyAssertionAxiom(hasAge5, catIndividual2, 5);
		
		OWLDataProperty hasAge6 = factory.getOWLDataProperty("hasAge",pm);
		OWLAxiom hasAgeAxiom6 = factory.getOWLDataPropertyAssertionAxiom(hasAge6, catIndividual3, 6);
		
		manager.applyChange(new AddAxiom(animal, hasNameAxiom4));
		manager.applyChange(new AddAxiom(animal, hasNameAxiom5));
		manager.applyChange(new AddAxiom(animal, hasNameAxiom6));
		
		manager.applyChange(new AddAxiom(animal, hasAgeAxiom4));
		manager.applyChange(new AddAxiom(animal, hasAgeAxiom5));
		manager.applyChange(new AddAxiom(animal, hasAgeAxiom6));
		
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
		//System.out.println("    from: " + documentIRI);
	
	}

}
