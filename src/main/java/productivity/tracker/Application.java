package productivity.tracker;

import javax.swing.SwingUtilities;

import productivity.tracker.models.Model;
import productivity.tracker.presenters.Presenter;
import productivity.tracker.views.View;

public class Application {
    public Application() {
        final View view = new View();
        final Model model = new Model();
        new Presenter(view, model);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Application();
            }
        });
    }
}