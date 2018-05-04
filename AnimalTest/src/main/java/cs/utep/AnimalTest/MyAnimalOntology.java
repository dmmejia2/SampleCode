package cs.utep.AnimalTest;

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

public class MyAnimalOntology {

		public static void main(String[] args) throws OWLOntologyCreationException{
			
			String ontFile = "MyAnimalTest.owl";
			
			
			//Managers First
			//Factory
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			OWLDataFactory factory = manager.getOWLDataFactory();
			
			File file = new File("/users/danielmejia/Documents/AnimalOntologyClasses.owl");
			
			OWLOntology animalOntology = manager.loadOntologyFromOntologyDocument(file);
			PrefixManager pm = new DefaultPrefixManager("http://www.semanticscience.org/resource/petOntology.owl#");
			
			OWLClass dogClass = factory.getOWLClass(":Dog", pm);
			OWLNamedIndividual dogIndividual = factory.getOWLNamedIndividual(":Hulk", pm);
			OWLClassAssertionAxiom classAssertion = factory.getOWLClassAssertionAxiom(dogClass, dogIndividual);
			manager.applyChange(new AddAxiom(animalOntology,classAssertion));
			
			OWLDataProperty hasAge = factory.getOWLDataProperty(":hasAge",pm);
			OWLAxiom hasAgeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasAge, dogIndividual, 3);
			manager.applyChange(new AddAxiom(animalOntology, hasAgeAxiom));
			
			
			
			
			OWLNamedIndividual dogIndividual2 = factory.getOWLNamedIndividual(":Thor",pm);
			OWLClassAssertionAxiom classAssertion2 = factory.getOWLClassAssertionAxiom(dogClass, dogIndividual2);
			manager.applyChange(new AddAxiom(animalOntology,classAssertion2));
			
			
			
			
			
			File outFile = new File(ontFile);
			try{
				outFile.createNewFile();
				FileOutputStream outputStream = new FileOutputStream(outFile);
				manager.saveOntology(animalOntology, outputStream);
			}catch(IOException e){
				
			}catch(OWLOntologyStorageException e){
				
			}
			System.out.println("Out File: "+outFile.getAbsolutePath());
			System.out.println("Loaded Ontolgoy: "+animalOntology);
		}
}
