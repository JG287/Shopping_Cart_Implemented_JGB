/**
 * An interface that describes the operations of a shopping cart that is filled
 * with items.
 */
public interface ShoppingCartInterface<T> {
	/** Gets the current number of entries in the shopping cart. */
	public int getCartSize();

	/** Sees whether the shopping cart is empty or not. */
	public boolean isCartEmpty();

	/** Adds a new item to this shopping cart. */
	public boolean addCartItem(T newCartItem);

	/**
	 * Removes one occurrence of a given item from this shopping cart, if possible.
	 */
	public boolean removeCartItem(T cartItem);

	/** Removes all entries from this shopping cart. */
	public void clearCart();

	/** Counts the number of times a given item appears in this shopping cart. */
	public int getFrequencyOf(T cartItem);

	/** Tests whether this shopping cart contains a given item. */
	public boolean cartContains(T cartItem);

	/** Retrieves all items that are in this shopping cart. */
	public T[] toArray();
} // end ShoppingCartInterface