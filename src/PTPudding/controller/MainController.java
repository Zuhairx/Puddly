package PTPudding.controller;

import PTPudding.view.InsertView;
import PTPudding.view.MainMenuView;
import PTPudding.view.ViewDataView;
import PTPudding.view.UpdateView;
import PTPudding.view.DeleteView;
import PTPudding.model.KoneksiDatabase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class MainController implements ActionListener {
    private MainMenuView view;
    private InsertController insertController;
    private ViewController viewController;
    private UpdateController updateController;
    private DeleteController deleteController;

    public MainController(MainMenuView view) {
        this.view = view;

        InsertView insertView = new InsertView();
        insertController = new InsertController(insertView);

        ViewDataView viewDataView = new ViewDataView();
        viewController = new ViewController(viewDataView);

        UpdateView updateView = new UpdateView();
        updateController = new UpdateController(updateView);

        DeleteView deleteView = new DeleteView();
        deleteController = new DeleteController(deleteView);

        view.getInsertButton().addActionListener(this);
        view.getViewButton().addActionListener(this);
        view.getUpdateButton().addActionListener(this);
        view.getDeleteButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getInsertButton()) {
            insertController.showView();
        } else if (e.getSource() == view.getViewButton()) {
            viewController.showView();
        } else if (e.getSource() == view.getUpdateButton()) {
            updateController.showView();
        } else if (e.getSource() == view.getDeleteButton()) {
            deleteController.showView();
        }
    }

    public void showMainMenu() {

        KoneksiDatabase kd = new KoneksiDatabase();
        try {
            kd.connect();
            JOptionPane.showMessageDialog(null, "Database Connected", "Message", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("Image/success.png"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database Failed Connected ", "Message", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        view.show();
    }
}