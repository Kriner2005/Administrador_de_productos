package co.edu.uptc.interfaces;

public interface PresenterInterface {
    public void setView(ViewInterface view);

    public void setModel(ModelInterface model);

    void onAddProduct(String name, String price);

    void onADeleteProduct(String name);

    void onAListProducts(String name);
}
