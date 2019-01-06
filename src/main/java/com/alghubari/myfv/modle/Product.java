package com.alghubari.myfv.modle;

public class Product {

    private String productName1;

    private String  productUnite1;

    private int productPrice1;

  //  private int photoUrl1;

    public Product(String productName1, String productUnite1, int productPrice1) {
        this.productName1 = productName1;
        this.productUnite1 = productUnite1;
        this.productPrice1 = productPrice1;
    }

    public Product() {
    }

    public Product(String productName1) {
        this.productName1 = productName1;
    }

    public String getProductName1() {
        return productName1;
    }

    public void setProductName1(String productName1) {
        this.productName1 = productName1;
    }

    public String getProductUnite1() {
        return productUnite1;
    }

    public void setProductUnite1(String productUnite1) {
        this.productUnite1 = productUnite1;
    }

    public int getProductPrice1() {
        return productPrice1;
    }

    public void setProductPrice1(int productPrice1) {
        this.productPrice1 = productPrice1;
    }
}
