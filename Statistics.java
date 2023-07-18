package ShoppingList;

public class Statistics {
    public long getSum (Integer[] costsList, Integer[] countsList) {
        long sum = 0;
        for (int i = 0; i < costsList.length; i++) {
            sum += (long) costsList[i] * countsList[i];
        }
        return sum;
    }

    public void printTopProducts(String[] ProductsList, Integer[] costsList, Integer[] countsList, int topProductsAmount) {
        for (int j = 0; j < topProductsAmount; j++) {
            int indexOfMostPopularProduct = 0;
            for (int i = 0; i < ProductsList.length; i++) {
                if(countsList[i] > countsList[indexOfMostPopularProduct]){
                    indexOfMostPopularProduct = i;
                }
            }
            System.out.println("Most popular product is " + ProductsList[indexOfMostPopularProduct]);
            ProductsList[indexOfMostPopularProduct] = null;
            countsList[indexOfMostPopularProduct] = 0;
            costsList[indexOfMostPopularProduct] = 0;
        }
    }
}
