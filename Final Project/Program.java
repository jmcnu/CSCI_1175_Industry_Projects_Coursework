import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos; 
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class Program extends Application {
	protected Text text = new Text (50,50, "Is this chapter high school or College?");
	@Override
	public void start(Stage primaryStage) {

		HBox paneForButtons = new HBox(20);
		Button bthighschool = new Button("High School");
		Button btcollege= new Button("College");
		paneForButtons.getChildren().addAll(bthighschool, btcollege);
		paneForButtons.setAlignment(Pos.CENTER);
		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);

		Pane paneForText = new Pane();
		paneForText.setStyle("-fx-border-color: black");
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);

		bthighschool.setOnAction( e -> {
			highSchool();
		});

		btcollege.setOnAction(e -> {
			college();
		});

		Scene scene = new Scene(pane, 450, 150);
		primaryStage.setTitle("Student Orangization");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void highSchool() {
		Scanner input = new Scanner(System.in);

		Highschool Highschool = new Highschool();
		Highschool[] array = new Highschool [100];

		System.out.println("Enter number of members:");
		int number = input.nextInt();
		input.nextLine();
		System.out.println("Enter the name of the High School:");
		Highschool.setSchool(input.nextLine());
		for(int i = 0; i<100; i++) {
			array[i] = new Highschool();
		}

		
			for (int i = 0; i < number; i++) {
				System.out.println("Enter in First Name, Last Name, and Year");
				array[i].setfirstname(input.next());
				array[i].setlastname(input.next());
				array[i].setyear(input.next());
		}

		System.out.println("Name of school:" + Highschool.getSchool());


		System.out.println("Members:");
		for (int i = 0; i < number; i++) {
			System.out.println(array[i].toString());

		}
	}

	public static void college() {
		Scanner input = new Scanner(System.in);

		College College = new College();
		College[] array = new College [100];

		System.out.println("Enter number of members:");
		int number = input.nextInt();
		input.nextLine();
		System.out.println("Enter the name of the College or University:");
		College.setSchool(input.nextLine());
		
		for(int i = 0; i<100; i++) {
			array[i] = new College();
		}

		for (int i = 0; i < number; i++) {
			System.out.println("Enter in First Name, Last Name, and Year");
			array[i].setfirstname(input.next());
			array[i].setlastname(input.next());
			array[i].setyear(input.next());
		}


		System.out.print("Name of College or University" + College.getSchool());

		System.out.println("Members:");
		for (int i = 0; i < number; i++) {
			System.out.print(array[i].toString());

		}
	}

}


