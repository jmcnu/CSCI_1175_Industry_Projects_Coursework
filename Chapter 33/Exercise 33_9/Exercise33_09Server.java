import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.*;
import java.util.Date;

public class Exercise33_09Server extends Application {
    private DataOutputStream toServer = null;
    private DataInputStream fromServer = null;
    private TextArea taServer = new TextArea();
    private TextArea taClient = new TextArea();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        taServer.setWrapText(true);
        taClient.setWrapText(true);
        //taClient.setDisable(true);

        BorderPane pane1 = new BorderPane();
        pane1.setTop(new Label("History"));
        pane1.setCenter(new ScrollPane(taServer));
        BorderPane pane2 = new BorderPane();
        pane2.setTop(new Label("New Message"));
        pane2.setCenter(new ScrollPane(taClient));

        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(pane1, pane2);

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setTitle("Exercise31_09Server"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        new Thread (() -> {
            try {
                ServerSocket serversocket = new ServerSocket(8000);

                Platform.runLater(() -> {
                    taServer.appendText("Server started at:" + new Date() +"\n");
                });
                Socket socket = serversocket.accept();

                DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while(true) {
                    String text = inputFromServer.readUTF();
                    outputToClient.writeUTF(text);

                    Platform.runLater(() -> {
                        taServer.appendText(text + "\n");
                    });
                }
            } catch(Exception err) {
                err.printStackTrace();
            }
        }).start();

        taClient.setOnKeyPressed(e-> {
            if (e.getCode() == KeyCode.ENTER) {
                String Text = null;
                Text = taClient.getText().trim();
                if (toServer == null) {
                    try {
                        Socket socket = new Socket("localhost",8080);
                        fromServer = new DataInputStream(socket.getInputStream());
                        toServer = new DataOutputStream(socket.getOutputStream());

                        InetAddress inetAddress= socket.getInetAddress();
                    } catch (Exception er) {
                        er.printStackTrace();
                    }
                }
                try {
                    toServer.writeUTF(Text);
                    toServer.flush();
                } catch (Exception err) {
                    err.printStackTrace();
                }
                taClient.clear();
            }
        });

        // To complete later
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
