package co.edu.uptc.interfaces;

import java.util.List;
import co.edu.uptc.pojo.Product;

public interface ViewInterface {

    void setPresenter(PresenterInterface presenter);

    void start();

    void showMessage(String msg);

    void showError(String msg);

    void showProducts(List<Product> products);
}
