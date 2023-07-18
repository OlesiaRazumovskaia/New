package ShoppingList;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        final int TOP_PRODUCTS_AMOUNT = 3;

        int countRepeat = 0;
        String usersList = getUserProductsList();
        int productsAmount = usersList.split("/").length;

        String[] masOfProducts = new String[productsAmount];
        Integer[] masOfCosts = new Integer[productsAmount];
        Integer[] masOfCounts = new Integer[productsAmount];

        for (int i = 0; i < productsAmount; i++) {
            String[] elementsUsersList = usersList.split("/");
            String[] parts = elementsUsersList[i].split(" ");
            String productName = parts[0];
            Integer productCost = Integer.parseInt(parts[1]);
            Integer productCount = Integer.parseInt(parts[2]);

            boolean productAlreadyExists = false;
            for (int j = 0; j < i; j++) {
                if (productName.equals(masOfProducts[j])) {
                    masOfCosts[j] = productCost;
                    masOfCounts[j] += productCount;
                    productAlreadyExists = true;
                    countRepeat++;
                }
            }

            if (!productAlreadyExists) {
                masOfProducts[i-countRepeat] = productName;
                masOfCosts[i-countRepeat] = productCost;
                masOfCounts[i-countRepeat] = productCount;
            }
        }

        String[] sortedProducts = Sort.sortArray(masOfProducts, productsAmount);
        System.out.println(Arrays.toString(sortedProducts));

        Statistics statistics = new Statistics();
        System.out.println(statistics.getSum(masOfCosts, masOfCounts));

        if (productsAmount < TOP_PRODUCTS_AMOUNT) {
            statistics.printTopProducts(masOfProducts, masOfCosts, masOfCounts, productsAmount);
        } else {
            statistics.printTopProducts(masOfProducts, masOfCosts, masOfCounts, TOP_PRODUCTS_AMOUNT);
        }
    }

    private static String getUserProductsList() {
        Scanner sc = new Scanner(System.in);
        String usersList = null;
        int count = 0;

        while (sc.hasNext()) {
            String s = sc.nextLine();

            if ("exit".equals(s)) {
                break;
            }

            String[] parts = s.split(" ");

            if (parts.length != 3) {
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }

            Integer productCost;
            Integer productCount;

            try {
                productCost = Integer.parseInt(parts[1]);
                productCount = Integer.parseInt(parts[2]);
                usersList += "/" + s;
                count++;
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }
        }

        usersList = usersList.replace("null/", "");
        return usersList;
    }
}