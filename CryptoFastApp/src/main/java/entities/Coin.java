package entities;

public class Coin
{
    public String name;
    public String symbol;
    public double price;
    public String circulatingSupply;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(String circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public void getProfile()
    {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Coin Profile: " + '\n'+
                "Name='" + name + '\n' +
                "Symbol='" + symbol + '\n' +
                "Price=" + price +'\n'+
                "Circulating Supply=" + circulatingSupply+'\n'
                ;
    }
}
