package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;;

public class MainPresenter implements PresenterInterface {
    private ViewInterface view;
    private ModelInterface model;

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
    }

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }

    @Override
    public void onAddProduct(String name, String price) {
        model.addProduct(new Product(name, Double.parseDouble(price)));
    }

    @Override
    public void onADeleteProduct(String name) {
        model.removeProductByName(name);
    }

    @Override
    public void onAListProducts(String name) {
        model.productsSortedByName();
        view.showMessage(model.getAllProducts());
    }
}
