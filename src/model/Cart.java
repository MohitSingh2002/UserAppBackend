package model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    public Map<String, CartItem> map = new HashMap<>();
    public Map<String, Integer> totalItemMap = new HashMap<>();
    public int noOfItems, totalPrice;

    public int addVarientBasedProductToCart(Product product, Varient varient) {
        String key = product.name + " " + varient.name;
        if (map.containsKey(key)) {
            map.get(key).quantity++;
            noOfItems++;
            totalPrice += varient.price;
        } else {
            map.put(key, new CartItem(key, varient.price));
            noOfItems++;
            totalPrice += varient.price;
        }

        if (totalItemMap.containsKey(product.name)) {
            int quantity = totalItemMap.get(product.name) + 1;
            totalItemMap.put(product.name, quantity);
        } else {
            totalItemMap.put(product.name, 1);
        }

        return (int) map.get(key).quantity;
    }
    
    public int removeVarientBasedProductFromCart(Product product, Varient varient) {
        
        String key = product.name + " " + varient.name;
        if (map.containsKey(key)) {
            noOfItems--;
            totalPrice -= map.get(key).price;
            map.get(key).quantity--;
            if (map.get(key).quantity == 0) {
                map.remove(key);
            }

            int quantity = totalItemMap.get(product.name) - 1;
            totalItemMap.put(product.name, quantity);
            if (totalItemMap.get(product.name) == 0) {
                totalItemMap.remove(product.name);
            }
        }

        return map.containsKey(key) ? (int) map.get(key).quantity : 0;
    }

    public void updateWeightBasedProductInCart(Product product, float quantity) {
        int newPrice = (int) (product.pricePerKg * quantity);
        if (map.containsKey(product.name)) {
            totalPrice -= map.get(product.name).price;
            map.put(product.name, new CartItem(product.name, quantity, newPrice));
            totalPrice += newPrice;
        } else {
            noOfItems++;
            map.put(product.name, new CartItem(product.name, quantity, newPrice));
            totalPrice += newPrice;
        }
    }

    public void removeWeightBasedProductFromCart(Product product) {
        if (map.containsKey(product.name)) {
            noOfItems--;
            totalPrice -= map.get(product.name).price;
            map.remove(product.name);
        }
    }

    public void removeAllVarientsProductFromCart(Product product) {
        for(Varient varient : product.varientsList) {
            String key = product.name + " " + varient.name;
            if (map.containsKey(key)) {
                noOfItems -= map.get(key).quantity;
                totalPrice -= map.get(key).price;
                map.remove(key);
            }
        }
        if (totalItemMap.containsKey(product.name)) {
            totalItemMap.remove(product.name);
        }
    }

    public void printCart() {
        System.out.println("noOfItems : " + noOfItems);
        System.out.println();

        System.out.println("totalPrice : " + totalPrice);
        System.out.println();

        System.out.println(map);
        System.out.println();

        System.out.println(totalItemMap);
        System.out.println();

    }

}
