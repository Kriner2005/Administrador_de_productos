package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

// importe de la lista manual para el algoritmo de ordenamiento
import co.edu.uptc.model.Manager;

// importe de la lista con linked list para el algoritmo de ordenamiento
// import co.edu.uptc.modelV2.Manager;

import co.edu.uptc.view.ConsoleView;

public class Runner {
    PresenterInterface presenter;
    ModelInterface model;
    ViewInterface view;

    private void makeMVP() {
        presenter = new MainPresenter();

        // Conector para tener la lista enlanzada ya sea de forma manual o con linked list
        model = new Manager();


        view = new ConsoleView();
        
        presenter.setModel(model);
        presenter.setView(view);

        view.setPresenter(presenter);
    }

    public void run() {
        makeMVP();
        view.start();
    }
}
