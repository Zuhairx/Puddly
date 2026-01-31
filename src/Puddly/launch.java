package Puddly;

import java.awt.EventQueue;

import Puddly.controller.MainController;
import Puddly.view.MainMenuView;

public class launch {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuView view = new MainMenuView();
					MainController controller = new MainController(view);
					controller.showMainMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
