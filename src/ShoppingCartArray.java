/**
 * A class of carts whose entries are stored in a fixed-size array.
 */
public final class ShoppingCartArray<T> implements ShoppingCartInterface<T> {
	private T[] cart;
	private int numberOfEntries;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	/** Creates an empty cart whose initial capacity is 25. */
	public ShoppingCartArray() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/**
	 * Creates an empty cart that has a given capacity.
	 * 
	 * @param desiredCapacity The integer capacity desired.
	 */
	public ShoppingCartArray(int desiredCapacity) {
		if (desiredCapacity <= MAX_CAPACITY) {
			// The cast is safe because the new array contains null entries
			@SuppressWarnings("unchecked")
			T[] tempCart = (T[]) new Object[desiredCapacity]; // Unchecked cast
			cart = tempCart;
			numberOfEntries = 0;
			integrityOK = true;
			// Test that contents are nulls - OK
			// for (int index = 0; index < desiredCapacity; index++)
			// System.out.print(bag[index] + " ");
			// System.out.println();
		} else
			throw new IllegalStateException(
					"Attempt to create a cart " + "whose capacity exceeds " + "allowed maximum.");
	} // end constructor

	/**
	 * Adds a new item to this bag.
	 * 
	 * @param newCartItem - adds a new item.
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean addCartItem(T newCartItem) {
		checkIntegrity();
		boolean result = true;
		if (isArrayFull()) {
			result = false;
		} else { // Assertion: result is true here
			cart[numberOfEntries] = newCartItem;
			numberOfEntries++;
		} // end if

		return result;
	} // end add

	/**
	 * Retrieves all items that are in this cart.
	 * 
	 * @return A newly allocated array of all the items in this cart.
	 */
	public T[] toArray() {
		checkIntegrity();

		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast

		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = cart[index];
		} // end for
		return result;
		// Note: The body of this method could consist of one return statement,
		// if you call Arrays.copyOf
	} // end toArray

	/**
	 * Sees whether the cart is empty or not.
	 * 
	 * @return True if the cart is empty, or false if not.
	 */
	public boolean isCartEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	/**
	 * Gets the current number of entries in the cart.
	 * 
	 * @return The integer number of entries currently in the cart.
	 */
	public int getCartSize() {
		return numberOfEntries;
	} // end getCartSize

	/**
	 * Counts the number of times a given entry appears in this cart.
	 * 
	 * @param cartItem The item to be counted.
	 * @return The number of times anEntry appears in this cart.
	 */
	public int getFrequencyOf(T cartItem) {
		checkIntegrity();
		int counter = 0;

		for (int index = 0; index < numberOfEntries; index++) {
			if (cartItem.equals(cart[index])) {
				counter++;
			} // end if
		} // end for

		return counter;
	} // end getFrequencyOf

	/**
	 * Tests whether the cart contains a given item.
	 * 
	 * @param cartItem The entry to locate.
	 * @return True if this cart contains item, or false otherwise.
	 */
	public boolean cartContains(T cartItem) {
		checkIntegrity();
		return getIndexOf(cartItem) >= 0;
	} // end contains

	/** Removes all entries from this cart. */
	public void clearCart() {
		while (!isCartEmpty())
			remove();
	} // end clear

	/**
	 * Removes one unspecified entry from the cart, if possible.
	 * 
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	public T remove() {
		checkIntegrity();
		T result = removeEntry(numberOfEntries - 1);
		return result;
	} // end remove

	/**
	 * Removes one occurrence of a given item from this cart.
	 * 
	 * @param cartItem The item to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	public boolean removeCartItem(T cartItem) {
		checkIntegrity();
		int index = getIndexOf(cartItem);
		T result = removeEntry(index);
		return cartItem.equals(result);
	} // end remove

	// Returns true if the cart array is full, or false if not.
	private boolean isArrayFull() {
		return numberOfEntries >= cart.length;
	} // end isArrayFull

	// Locates a given item within the cart array.
	// Returns the index of the item, if located,
	// or -1 otherwise.
	// Precondition: checkInitialization has been called.
	private int getIndexOf(T cartItem) {
		int where = -1;
		boolean found = false;
		int index = 0;

		while (!found && (index < numberOfEntries)) {
			if (cartItem.equals(cart[index])) {
				found = true;
				where = index;
			} // end if
			index++;
		} // end while

		// Assertion: If where > -1, anEntry is in the cart array, and it
		// equals cart[where]; otherwise, anEntry is not in the cart array.

		return where;
	} // end getIndexOf

	// Removes and returns the item at a given index within the array.
	// If no such entry exists, returns null.
	// Precondition: 0 <= givenIndex < numberOfEntries.
	// Precondition: checkInitialization has been called.
	private T removeEntry(int givenIndex) {
		T result = null;

		if (!isCartEmpty() && (givenIndex >= 0)) {
			result = cart[givenIndex]; // Entry to remove
			int lastIndex = numberOfEntries - 1;
			cart[givenIndex] = cart[lastIndex]; // Replace entry to remove with last entry
			cart[lastIndex] = null; // Remove reference to last entry
			numberOfEntries--;
		} // end if

		return result;
	} // end removeEntry

	// Throws an exception if this object is not initialized.
	private void checkIntegrity() {
		if (!integrityOK)
			throw new SecurityException("ArrayBag object is corrupt.");
	} // end checkIntegrity
} // end ArrayBag