import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DrawLinesController {

	@FXML
	private Canvas can;

	@FXML
	private TextField xText;

	@FXML
	private TextField yText;

	@FXML
	private Button addButton;

	@FXML
	private Button clearButton;

	private GraphicsContext gc;
	private double x = -1, y = -1;

	public void initialize() {
		gc = can.getGraphicsContext2D();
	}

	@FXML
	void addPressed(ActionEvent event) {
		if (x != -1 && y != -1) {
			int tempX = Integer.parseInt(xText.getText());
			int tempY  = Integer.parseInt(yText.getText());
			gc.strokeLine(x, y, tempX, tempY);
		}

		x = Integer.parseInt(xText.getText());
		y = Integer.parseInt(yText.getText());
		xText.setText("");
		yText.setText("");
	}

	@FXML
	void clearPressed(ActionEvent event) {
		gc.clearRect(0, 0, can.getWidth(), can.getHeight());
		x = -1;
		y = -1;
	}
}
