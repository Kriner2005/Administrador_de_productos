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
        model.addProduct(new Product(name, Double.parseDouble(price), unit));
        view.showMessage("Producto agregado exitosamente");
    }

    @Override
    public void onADeleteProduct(String name) {
        boolean removed = model.removeProductByName(name);
        if (removed) {
            view.showMessage("Producto eliminado correctamente.");
        } else {
            view.showError("No se encontró ningún producto con ese nombre.");
        }
    }

    @Override
    public void onAListProducts() {
        if (model.isEmpty()) {
            view.showAlert("No hay productos registrados.");
            return;
        }
        view.showProducts(model.getAllProducts());
    }

    @Override
    public void onASortedProducts() {
        if (model.isEmpty()) {
            view.showAlert("No hay productos registrados.");
            return;
        }
        view.showProducts(model.productsSortedByName());
    }

    @Override
    public boolean onIsEmpty() {
        return model.isEmpty();
    }
}
