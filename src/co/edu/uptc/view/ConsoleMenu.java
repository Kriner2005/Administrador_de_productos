package co.edu.uptc.view;

import java.util.HashMap;
import java.util.Map;

import co.edu.uptc.interfaces.PresenterInterface;

public class ConsoleMenu {

    private final PresenterInterface presenter;
    private final ConsoleReader reader;
    private final Map<Integer, Runnable> actions;

    private static final String MENU_TEXT = " - - - - Bienvenido al sistema de administración de productos - - - - \n" +
            "Seleccione una opción:\n" +
            "1) Añadir producto\n" +
            "2) Eliminar producto\n" +
            "3) Mostrar todos los productos\n" +
            "4) Mostrar productos ordenados por nombre\n" +
            "0) Salir";

    public ConsoleMenu(PresenterInterface presenter, ConsoleReader reader) {
        this.presenter = presenter;
        this.reader = reader;
        this.actions = new HashMap<>();
        initActions();
    }

    private void initActions() {
        actions.put(1, this::addProduct);
        actions.put(2, this::deleteProduct);
        actions.put(3, () -> presenter.onAListProducts());
        actions.put(4, () -> presenter.onASortedProducts());
    }

    public void display() {
        System.out.println(MENU_TEXT);
    }

    public Runnable getAction(Integer option) {
        return actions.get(option);
    }

    private void addProduct() {
        String name = reader.readLine("Nombre del producto: ");
        double price = reader.readPositiveDouble("Precio del producto: ");
        String unit = reader.readLine("Unidad del producto: ");
        presenter.onAddProduct(name, String.valueOf(price), unit);
    }

    private void deleteProduct() {
        if (presenter.onIsEmpty()) {
            System.out.println("Error: No hay productos para eliminar.");
            return;
        }
        presenter.onADeleteProduct(reader.readLine("Nombre del producto a eliminar: "));
    }
}