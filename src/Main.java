import model.Cart;
import model.Product;
import model.Varient;

public class Main {

    public static void main(String[] args) {

        Cart cart = new Cart();

        Product apple = new Product("Apple");
        Varient appleVarient1 = new Varient("1kg", 100);
        Varient appleVarient2 = new Varient("2kg", 200);
        apple.varientsList.add(appleVarient1);
        apple.varientsList.add(appleVarient2);


        Product banana = new Product("Banana", 30, 1);

        Product kiwi = new Product("Kiwi", 50, 2);

        Product orange = new Product("Orange");
        Varient orangeVarient1 = new Varient("4kg", 20);
        Varient orangeVarient2 = new Varient("5kg", 70);
        orange.varientsList.add(orangeVarient1);
        orange.varientsList.add(orangeVarient2);


        cart.addVarientBasedProductToCart(apple, appleVarient1);
        cart.addVarientBasedProductToCart(apple, appleVarient1);
        cart.addVarientBasedProductToCart(apple, appleVarient2);

        cart.removeVarientBasedProductFromCart(apple, appleVarient1);

        cart.updateWeightBasedProductInCart(banana, 5);

        cart.removeWeightBasedProductFromCart(banana);

        cart.printCart();

        cart.updateWeightBasedProductInCart(kiwi, 8);

        cart.addVarientBasedProductToCart(orange, orangeVarient1);
        cart.addVarientBasedProductToCart(orange, orangeVarient1);
        cart.addVarientBasedProductToCart(orange, orangeVarient2);
        cart.addVarientBasedProductToCart(orange, orangeVarient2);
        cart.addVarientBasedProductToCart(orange, orangeVarient2);

        cart.printCart();

        cart.removeAllVarientsProductFromCart(apple);

        cart.printCart();

    }

}
