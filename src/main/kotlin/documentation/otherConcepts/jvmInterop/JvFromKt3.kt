package otherConcepts.jvmInterop

/**
 * Kotlin treats some Java types specifically. Such types are not loaded from Java "as is",
 * but are mapped to corresponding Kotlin types. The mapping only matters at compile time,
 * the runtime representation remains unchanged. Java's primitive types are mapped to
 * corresponding Kotlin types
 * ...
 * byte -> kotlin.Byte
 * short -> kotlin.Short
 * int -> kotlin.Int
 * long -> kotlin.Long
 * char -> kotlin.Char
 * float -> kotlin.Float
 * double -> kotlin.Double
 * boolean -> kotlin.Boolean
 * ...
 * java.lang.Object -> kotlin.Any!
 * java.lang.Cloneable -> kotlin.Cloneable!
 * java.lang.Comparable -> kotlin.Comparable!
 * java.lang.Enum -> kotlin.Enum!
 * java.lang.Annotation -> kotlin.Annotation!
 * java.lang.CharSequence -> kotlin.CharSequence!
 * java.lang.String -> kotlin.String!
 * java.lang.Number -> kotlin.Number!
 * java.lang.Throwable -> kotlin.Throwable!
 * ...
 * java.lang.Byte -> kotlin.Byte?
 * java.lang.Short -> kotlin.Short?
 * java.lang.Integer -> kotlin.Int?
 * java.lang.Long -> kotlin.Long?
 * java.lang.Character -> kotlin.Char?
 * java.lang.Float -> kotlin.Float?
 * java.lang.Double -> kotlin.Double?
 * java.lang.Boolean -> kotlin.Boolean?
 * ...
 * NOTE: a boxed primitive type used as a type parameter is mapped to a platform type:
 * e.g., List<java.lang.Integer> becomes a List<Int!> in Kotlin.
 * Collection types may be read-only or mutable in Kotlin, so Java's collections are
 * mapped as follows (all Kotlin types below reside in the package kotlin.collections
 * ...
 * Java Type -> Kotlin read-only type -> kotlin mutable type -> Loaded Platform type
 * Iterator<T> -> Iterator<T> -> MutableIterator<T> -> (Mutable)Iterator<T>!
 * Iterable<T> -> Iterable<T> -> MutableIterable<T> -> (Mutable)Iterable<T>!
 * Collection<T> -> Collection<T> -> MutableCollection<T> -> (Mutable)Collection<T>!
 * Set<T> -> Set<T> -> MutableSet<T> -> (Mutable)Set<T>!
 * List<T> -> List<T> -> MutableList<T> -> (Mutable)List<T>!
 * ListIterator<T> -> ListIterator<T> -> MutableListIterator<T> -> (Mutable)ListIterator<T>!
 * Map<K, V> -> Map<K, V> -> MutableMap<K, V> -> (Mutable)Map<K, V>!
 * Map.Entry<K, V> -> Map.Entry<K, V> -> MutableMap.MutableEntry<K,V> -> (Mutable)Map.(Mutable)Entry<K, V>!
 * ...
 * Java's arrays are mapped as mentioned below:
 * int[] -> kotlin.IntArray!
 * String[] -> kotlin.Array<(out) String>!
 * ...
 * NOTE: The static members of these Java types are not directly accessible on the
 * companion objects of the Kotlin types. To call them, use the full qualified names
 * of the Java types, e.g. java.lang.Integer.toHexString(foo)
 */