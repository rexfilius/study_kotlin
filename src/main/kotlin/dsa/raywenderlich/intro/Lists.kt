package raywenderlich.intro

/**
 * ORDER
 * Elements in a list are explicitly ordered and have a corresponding zero-based, integer
 * index. The order should not be taken for granted. Some data structures, such as Map,
 * have a weaker concept of the order or no order at all. You can end up with a different
 * order when you try to access elements out of different collections
 */

/**
 * RANDOM-ACCESS
 * a trait that data structures can claim if they can handle element retrieval in a
 * constant amount of time. e.g. getting an item from a list takes constant time.
 * i.e. there’s no performance difference in accessing the 1st element, 3rd element or any
 * other element of the list. This performance should not be taken for granted. Other data
 * structures such as Linked Lists and Trees do not have constant time access -
 * the further the element is, the longer it takes to access it.
 */