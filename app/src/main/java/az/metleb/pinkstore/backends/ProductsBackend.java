package az.metleb.pinkstore.backends;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import az.metleb.pinkstore.R;
import az.metleb.pinkstore.models.ProductModel;

public class ProductsBackend {
    private static ProductsBackend _instance;
    private List<ProductModel> itemsList = new ArrayList<>();
    private ProductsBackend(){
        itemsList.add(new ProductModel(new int[]{R.drawable.rose1,R.drawable.rose2,R.drawable.rose3,R.drawable.rose4}, "Rose 1", 0));
        itemsList.add(new ProductModel(new int[]{R.drawable.rose2,R.drawable.rose3,R.drawable.rose4, R.drawable.rose5}, "Rose 2", 1));
        itemsList.add(new ProductModel(new int[]{R.drawable.rose3,R.drawable.rose4,R.drawable.rose10,R.drawable.rose11}, "Rose 3", 2));
        itemsList.add(new ProductModel(new int[]{R.drawable.rose4, R.drawable.rose5,R.drawable.rose10,R.drawable.rose11}, "Rose 4",3));
        itemsList.add(new ProductModel(new int[]{R.drawable.rose5, R.drawable.rose6,R.drawable.rose3,R.drawable.rose7}, "Rose 5",4));
        itemsList.add(new ProductModel(new int[]{R.drawable.rose6,R.drawable.rose7,R.drawable.rose3,R.drawable.rose4}, "Rose 6",5));
        itemsList.add(new ProductModel(new int[]{R.drawable.rose10,R.drawable.rose11,R.drawable.rose1,R.drawable.rose2}, "Rose 7",6));
        itemsList.add(new ProductModel(new int[]{R.drawable.rose2,R.drawable.rose5,R.drawable.rose3,R.drawable.rose4}, "Rose 8",7));
        itemsList.add(new ProductModel(new int[]{R.drawable.rose3,R.drawable.rose7,R.drawable.rose5,R.drawable.rose2}, "Rose 9",8));
        itemsList.add(new ProductModel(new int[]{R.drawable.rose10,R.drawable.rose11,R.drawable.rose4, R.drawable.rose5}, "Rose 10",9));
        itemsList.add(new ProductModel(new int[]{R.drawable.rose5,R.drawable.rose2,R.drawable.rose3,R.drawable.rose7}, "Rose 11",10));
        itemsList.add(new ProductModel(new int[]{R.drawable.rose6,R.drawable.rose3,R.drawable.rose4, R.drawable.rose5}, "Rose 12",11));
    }
    public  static ProductsBackend getInstance(){
        if(ProductsBackend._instance == null){
            ProductsBackend._instance = new ProductsBackend();
        }
        return  _instance;
    }

    public List<ProductModel> getItemsList() {
        return itemsList;
    }
    public List<ProductModel> getLikeThis(int id){
        List<ProductModel> cp = new ArrayList<>(this.itemsList);
        cp.remove(id);
        Collections.shuffle(cp);

        int randomSeriesLength = 3;

        return  cp.subList(0, 4);
    }
}