
/** Application class that tests a variety of methods that are apart of the shopping cart
 *
 * @author Jose Garcia Balboa
 *
 */
import java.util.Arrays;

public class ShoppingCartApplication {

	public static void main(String args[]) {

		ShoppingCartArray<String> cartString = new ShoppingCartArray<>();

		cartString.addCartItem("One Gallon of Whole Milk");

		cartString.addCartItem("Two 12 oz Cans of Tomato Sauce");

		cartString.addCartItem("Three Pizza Rolls");

		cartString.addCartItem("Four Big Pizzas");

		cartString.addCartItem("Five Boxes of Cereal");

		cartString.addCartItem("Six 12 Pack of Coca-Cola");

		System.out.println(Arrays.toString(cartString.toArray()));

		cartString.removeCartItem("One Gallon of Whole Milk");

		cartString.removeCartItem("Two 12 oz Cans of Tomato Sauce");

		cartString.removeCartItem("Three Pizza Rolls");

		cartString.removeCartItem("Four Big Pizzas");

		cartString.removeCartItem("Five Boxes of Cereal");

		System.out.println(Arrays.toString(cartString.toArray()));

	}
}
