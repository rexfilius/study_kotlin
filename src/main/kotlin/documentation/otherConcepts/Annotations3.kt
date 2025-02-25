package documentation.otherConcepts

/**
 * When you're annotating a property or a primary constructor parameter, there are
 * multiple Java elements which are generated from the corresponding Kotlin element, and
 * therefore multiple possible locations for the annotation in the generated Java bytecode.
 */

/*class Example3(@field:Ann val foo,    // annotate Java field
               @get:Ann val bar,      // annotate Java getter
               @param:Ann val quux)   // annotate Java constructor parameter*/

/**
 * The full list of supported use-site targets is:
 * file; property (annotations with this target are not visible to Java); field;
 * get (property getter); set (property setter);
 * receiver (receiver parameter of an extension function or property);
 * param (constructor parameter); setparam (property setter parameter);
 * delegate (the field storing the delegate instance for a delegated property)
 * ...
 * If you don't specify a use-site target, the target is chosen according to the
 * @Target annotation of the annotation being used. If there are multiple applicable
 * targets, the first applicable target from the following is used:
 * param; property; field
 */
