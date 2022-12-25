package classes

/**
 * VISIBILITY MODIFIERS
 * Classes, Objects, Interfaces, Constructors, Functions, Properties & their Setters can
 * have visibility modifiers. Getters always have the same visibility as the property.
 * ...
 * There are 4 visibility modifiers in Kotlin:
 * private - protected - internal - public(default).
 */

/**
 * PACKAGES
 * Functions, Properties and Classes, Objects and Interfaces can be declared at the
 * "top-level" directly inside a package.
 * ...
 * 1. public: used by default if you don't specify any visibility modifier, means
 *            your declaration is visible everywhere.
 * 2. private: declaration will be visible inside the file containing the declaration.
 * 3. internal: visible everywhere in the same module.
 * 4. protected: not available for top-level declarations.
 * ...
 * To use a visible top-level declaration from another package, you still import it.
 */

/**
 * CLASSES & INTERFACES
 * For members declared inside a class:
 * 1. private: visible inside the class only.
 * 2. protected: same as private but also visible in subclasses
 * 3. internal: any client inside the module who sees the declaring class
 *              sees its internal members.
 * 4. public: any client who sees the declaring class sees its public members
 * ...
 * In Kotlin, outer class does not see private members of its inner classes.
 * If you override a protected member and don't specify the visibility explicitly,
 * the overriding member will also have protected visibility
 */

/**
 * CONSTRUCTORS
 * By default, all constructors are public, which effectively amounts to them being
 * visible everywhere where the class is visible (this means that a constructor
 * of an internal class is only visible within the same module)
 */
class See private constructor(a: Int) {/**/ }

// SIDE NOTE: Local variables, functions & classes can't have visibility modifiers.

/**
 * MODULES
 * The internal visibility modifier means that the member is visible within
 * the same module. A module is a set of Kotlin files compiled together:
 * 1. an IntelliJ IDEA module
 * 2. a Maven project
 * 3. a Gradle source set (exception of 'test' accessing internal declarations of 'typeSystem.main'
 * 4. a set of files compiled with one invocation of <kotlinc> Ant task
 */