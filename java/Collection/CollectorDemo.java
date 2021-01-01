import java.util.stream.Collector;
import java.util.stream.Collectors;  
import java.util.List;  
import java.util.ArrayList;

class Product{  
    int id;  
    String name;  
    float price;  
      
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  

class CollectorDemo {
    public static void main(String[] args){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"HP Laptop",25000f));  
        productList.add(new Product(2,"Dell Laptop",30000f));  
        productList.add(new Product(3,"Lenevo Laptop",28000f));  
        productList.add(new Product(4,"Sony Laptop",28000f));  
        productList.add(new Product(5,"Apple Laptop",90000f));  

        List<Float> priceList = productList.stream().map(x->x.price).collect(Collectors.toList());
        System.out.println(priceList);
    }
}
