package cn.org.aiit.ddex

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class ArchTest {

    @Test
    fun servicesAndRepositoriesShouldNotDependOnWebLayer() {

        val importedClasses = ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("cn.org.aiit.ddex")

        noClasses()
            .that()
                .resideInAnyPackage("cn.org.aiit.ddex.service..")
            .or()
                .resideInAnyPackage("cn.org.aiit.ddex.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..cn.org.aiit.ddex.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses)
    }
}
