package co.edu.uptc.view;

import java.util.List;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.pojo.Product;

public class ConsoleView implements ViewInterface {

    private final ConsoleReader reader = new ConsoleReader();
    private ConsoleMenu menu;
    private boolean isRunning = true;

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.menu = new ConsoleMenu(presenter, reader);
    }

    @Override
    public void start() {
        do {
            menu.display();
            selectOption(reader.readInt());
        } while (isRunning);
    }

    private void selectOption(Integer option) {
        if (option == null) {
            showError("Opción inválida, ingrese un número.");
            return;
        }
        if (option == 0) {
            isRunning = false;
            return;
        }
        Runnable action = menu.getAction(option);
        if (action != null) action.run();
        else showError("Opción no válida, ingrese otro número.");
    }

    @Override
    public void showProducts(List<Product> products) {
        StringBuilder sb = new StringBuilder("------Lista de productos-------\n");
        for (Product p : products) {
            sb.append("Nombre: ").append(p.getName()).append("\n")
              .append("Precio: ").append(p.getPrice()).append("\n")
              .append("Unidad: ").append(p.getUnit()).append("\n\n");
        }
        showMessage(sb.append("------------------------------").toString());
    }

    @Override public void showMessage(String msg) { System.out.println(msg); }
    @Override public void showError(String msg)   { System.out.println("Error: " + msg); }
    @Override public void showAlert(String msg)   { System.out.println("Alerta: " + msg); }
}