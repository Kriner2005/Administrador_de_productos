package co.edu.uptc.view;

import java.util.List;
import java.util.Scanner;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.pojo.Product;

public class ConsoleView implements ViewInterface {

    private PresenterInterface presenter;
    private Scanner scanner;
    private boolean isRunning;

    

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
        this.isRunning = true;
    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    @Override
    public void showMessage(String msg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showMessage'");
    }

    @Override
    public void showError(String msg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showError'");
    }

    @Override
    public void showProducts(List<Product> products) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showProducts'");
    }

}