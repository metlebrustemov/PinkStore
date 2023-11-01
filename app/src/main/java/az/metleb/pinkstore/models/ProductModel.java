package az.metleb.pinkstore.models;

public class ProductModel {
    public int getImageId() {
        return imageId[0];
    }

    public  int getId(){
        return  this.id;
    }

    public int[] getAllImages() {
        return imageId;
    }

    public String getText() {
        return text;
    }

    private int imageId[];
    private String text;
    private int id;

    public ProductModel(int imageId[], String text, int id) {
        this.imageId = imageId;
        this.text = text;
        this.id = id;
    }
}
