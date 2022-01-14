import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class program1
{
    public static void main(String args[])
    {
        List<Product> productList = new ArrayList<Product>();
        int numberOfProducts;
        String productName;
        float productPrice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of products:");
        numberOfProducts = sc.nextInt();
        for(int i = 0;i<numberOfProducts;i++)
        {
            System.out.println("Enter product name:");
            productName=sc.next();
            System.out.println("Enter product price:");
            productPrice=sc.nextFloat();
            productList.add(new Product(productName,productPrice));
        }
        Product maxPriceProduct = productList.stream().max((p1,p2)->p1.compareTo(p2)).get();
        System.out.println("Most expensive product:"+maxPriceProduct.productName+" "+maxPriceProduct.productPrice);
        Product minPriceProduct = productList.stream().min((p1,p2)->p1.compareTo(p2)).get();
        System.out.println("Least expensive product:"+minPriceProduct.productName+" "+minPriceProduct.productPrice);
        String sortedlistToString = productList.stream().sorted((p1,p2)->p1.compareTo(p2)).map(Product::getProductName)
                .collect(java.util.stream.Collectors.joining("-", "[", "]"));
        System.out.println("Reduced to string('-' separated): " + sortedlistToString);
        double averagePrice = productList.stream()
                .collect(java.util.stream.Collectors.averagingDouble(Product::getProductPrice));
        System.out.println("Average Price : "+averagePrice);
        productList.stream().forEach(p->p.incrementPrice(25.0));
        double sumIncrementedPrice = productList.stream().collect(Collectors.summingDouble(Product::getProductPrice));
        System.out.println("Sum of prices after incrementing by 25%:"+sumIncrementedPrice);
        List <Product> productsOver100 = productList.stream().filter(p->p.getProductPrice()>100).collect(Collectors.toList());
        System.out.println("Products with prices > Rs.100:");
        productsOver100.stream().forEach(p->p.printProduct());
        boolean oneLessThan100 = productList.stream().anyMatch(p -> p.getProductPrice()<100);
        System.out.println("Is there a product worth less than Rs. 100?"+oneLessThan100);
        boolean manyLessThan100 = productList.stream().anyMatch(p -> p.getProductPrice()<100);
        System.out.println("Are there products worth less than Rs. 100?"+manyLessThan100);

        Map<Double, List<Product>> groupProductByPrice = productList.stream().collect(Collectors.groupingBy(e -> new Double(e.getProductPrice())));
        for (Map.Entry<Double,List<Product>> entry : groupProductByPrice.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue().toString());
    }
}
