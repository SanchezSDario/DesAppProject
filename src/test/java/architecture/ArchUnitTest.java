package architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import javax.persistence.Entity;import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

class ArchUnitTest {
	
	JavaClasses importedClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp.GrupoJ022020");

	@Test
	public void test_ClassesThatResidesInWebServiceShouldHaveNameMatchingControllerAndBeAnnotatedWithRestController() {
	    ArchRule myRule = classes()
	        .that().resideInAPackage("..webservice..").should().haveSimpleNameEndingWith("Controller")
	        .andShould().beAnnotatedWith(RestController.class)
	        .andShould().accessClassesThat().areAnnotatedWith(Service.class);

		myRule.check(importedClasses);
	}

	@Test
	public void test_ClassesThatResidesInServiceShouldHaveNameMatchingServiceAndShouldBeAnnotatedWithService() {
	    ArchRule myRule = classes()
	        .that().resideInAPackage("..service..").should().haveSimpleNameEndingWith("Service")
	        .andShould().beAnnotatedWith(Service.class)
	        .andShould().accessClassesThat().areAnnotatedWith(Service.class)
	        .orShould().accessClassesThat().areAnnotatedWith(Repository.class);

		myRule.check(importedClasses);
	}
	
	@Test
	public void test_ClassesThatResidesInPersistenceShouldHaveNameMatchingRepositoryAndBeAnnotatedWithRepository() {
	    ArchRule myRule = classes()
	        .that().resideInAPackage("..persistence..").should().haveSimpleNameEndingWith("Repository")
	        .andShould().beAnnotatedWith(Repository.class);

		myRule.check(importedClasses);
	}
	
	@Test
	public void test_PersistenceShouldOnlyBeAccessedByServicesAndAccessToOnlyModelOrPersistence() {
		ArchRule myRule = classes()
			    .that().resideInAPackage("..persistence..")
			    .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Service.class)
			    .andShould().onlyAccessClassesThat().areAnnotatedWith(Entity.class)
			    .orShould().onlyAccessClassesThat().areAnnotatedWith(Repository.class);
	
		myRule.check(importedClasses);
	}

	@Test
	public void test_ModelClassesShouldNotAccessToControllerOrServiceOrRepositoryClasses() {		
		ArchRule myRule = classes()
			    .that().resideInAPackage("..model..")
			    .should().onlyAccessClassesThat().areNotAnnotatedWith(Controller.class)
			    .andShould().onlyAccessClassesThat().areNotAnnotatedWith(Service.class)
			    .andShould().onlyAccessClassesThat().areNotAnnotatedWith(Repository.class);

		myRule.check(importedClasses);
	}
}
