package co.edu.uptc.view;

import java.util.Scanner;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

public class ConsoleView implements ViewInterface {

    private PresenterInterface presenter;
    private Scanner scanner;
    private boolean isRunning;

    String menu =   "Bienvenido al sistema de administración de productos\n"+
                    "Seleccione una opción:\n"+
                     "1) Añadir producto\n"+
                     "2) Eliminar producto\n"+
                     "3) Mostrar productos\n"+
                     "0) Salir";

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
        do {
            
            System.out.println(menu);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    showProducts();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    break;
            }
        } while (isRunning);

    }

    private void addProduct() {
        System.out.println("Ingrese nombre del producto: ");
        String name = scanner.nextLine();

        System.out.println("Ingrese precio: ");
        String price = scanner.nextLine();
        System.out.println("Ingrese unidad: ");
        String unit = scanner.nextLine();
        presenter.onAddProduct(name, price, unit);
    }

    private void deleteProduct() {
        System.out.println("Nombre del producto: ");
        String name = scanner.nextLine();
        presenter.onADeleteProduct(name);
    }

    private void showProducts() {
        presenter.onAListProducts();
    }

    @Override
    public void showMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public void showError(String msg) {
        System.out.println("Error: " + msg);
    }

}