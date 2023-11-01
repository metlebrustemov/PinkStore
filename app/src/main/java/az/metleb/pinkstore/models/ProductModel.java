package az.metleb.pinkstore.models;

public class ProductModel {
    public int getImageId() {
        return imageId[0];
    }

    public int[] getAllImages() {
        return imageId;
    }

    public String getText() {
        return text;
    }

    private int imageId[];
    private String text;

    public ProductModel(int imageId[], String text) {
        this.imageId = imageId;
        this.text = text;
    }
}
