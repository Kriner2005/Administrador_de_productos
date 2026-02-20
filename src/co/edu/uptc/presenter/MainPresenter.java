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
    public void onAddProduct(String name, String price, String unit) {
        try {
            double value = Double.parseDouble(price);
            model.addProduct(new Product(name, value, unit));
            view.showMessage("Producto agregado exitosamente");
        } catch (NumberFormatException e) {
            view.showError("Precio inválido: " + price);
        }
    }

    @Override
    public void onADeleteProduct(String name) {
            model.removeProductByName(name);
            view.showMessage("Producto eliminado correctamente.");
    }

    @Override
    public void onAListProducts() {
        model.productsSortedByName();
        view.showMessage(model.getAllProducts());
    }
}
