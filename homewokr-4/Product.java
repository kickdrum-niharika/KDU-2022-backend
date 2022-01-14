public class Product implements Comparable<Product>
{
    String productName;
    float productPrice;
    Product(String name,float price)
    {
        productName = name;
        productPrice = price;
    }

    public int compareTo(Product p2)
    {
        return (this.productPrice==p2.productPrice)?0:((this.productPrice>p2.productPrice)?1:-1);
    }

    public void printProduct()
    {
        System.out.println(this.productName+": Rs."+this.productPrice);
    }

    public String getProductName()
    {
        return this.productName;
    }
    public float getProductPrice()
    {
        return this.productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    public void incrementPrice(double incrementPercentage)
    {
        this.productPrice += (this.productPrice*incrementPercentage)/100;
    }
}
