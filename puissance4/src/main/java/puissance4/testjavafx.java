package puissance4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.stage.Modality;
import javafx.stage.Stage;

public class testjavafx extends Application {

    private Stage mainWindow = null;
    private Stage confirmationWindow = null;
    public static void main(String[] args) 
    {
        launch(args);
    }

    private Scene test(){
        Label l = new Label("Bonsoir non.");
        Button game = new Button("Game ?");
        Button quit = new Button("Quit ?");
        HBox forButton = new HBox();
        forButton.getChildren().addAll(game, quit);
        VBox box1 = new VBox();
        box1.getChildren().addAll(l, forButton);
        box1.setAlignment(Pos.CENTER);
        return new Scene(box1, 200, 100);
    }


    @Override
    public void start(Stage mainWindow) throws Exception {
        this.mainWindow = mainWindow;
        Button welcome = new Button("Start ?");
        Label l1 = new Label("Hey ! Welcome on this game !");
        Scene confirmationScene = test();
        this.confirmationWindow = new Stage();
        confirmationWindow.setTitle("test");
        confirmationWindow.setScene(confirmationScene);
        confirmationWindow.initModality(Modality.APPLICATION_MODAL);
        
    }
}
