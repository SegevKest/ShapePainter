import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


public class ShapePainterController {

	
	// JAVAFX - Variables	
	
    @FXML private Pane paneBoard;

    @FXML
    private ToggleGroup shapeSelection;
    @FXML
    private ToggleGroup colorSelection;
    @FXML
    private ToggleGroup fillSelection;

    // Shapes Buttons
    @FXML
    private RadioButton ellipseRadioBtn;
    @FXML
    private RadioButton lineRadioBtn;
    @FXML
    private RadioButton rectangleRadioBtn;
    
    // Colors Buttons
    @FXML
    private RadioButton greenColBtn;
    @FXML
    private RadioButton redColorBtn;
    @FXML
    private RadioButton yellowColBtn;
    @FXML
    private RadioButton blackColorBtn;
    @FXML
    private RadioButton blueColBtn;

    // Filing buttons
    @FXML
    private RadioButton setFillBtn;
    @FXML
    private RadioButton setNotFillBtn;

    // Undo and clear
    @FXML
    private Button clearBtn;
    @FXML
    private Button undoBtn;

    
    
    // Private variables
    private List<Shape> allShapes;
    private Shape shapeToDraw;	// the selected shape that the user chose to draw
    private boolean fillShape;	// True - with filling, False - without
    private Color shapeColor;	// the new shapes color
    
    // The Points to start draw from
    
    
    public void initialize() {
		
    	allShapes = new ArrayList<Shape>();
    	
    	// Color initializations
    	greenColBtn.setUserData(Color.GREEN);
    	redColorBtn.setUserData(Color.RED);
    	yellowColBtn.setUserData(Color.YELLOW);
    	blackColorBtn.setUserData(Color.BLACK);
    	blueColBtn.setUserData(Color.BLUE);

    }
    
    
    // --------------
    // Painting Methods
    @FXML
    void startPaintFromHere(MouseEvent event) {

    }
    
    @FXML
    void finishPaintHere(MouseEvent event) {

    }

    // --------------
    // Colors Methods
    @FXML
    void selectBlackColor(ActionEvent event) {

    }

    @FXML
    void selectBlueColor(ActionEvent event) {

    }
    
    @FXML
    void selectGreenColor(ActionEvent event) {

    }
    
    @FXML
    void selectYellowColor(ActionEvent event) {

    }
    
    @FXML
    void selectRedColor(ActionEvent event) {

    }



    // --------------
    // Shapes methods
    @FXML
    void selectElipseShape(ActionEvent event) {

    }

    @FXML
    void selectEllipseShape(ActionEvent event) {

    }

    @FXML
    void selectRectangleShape(ActionEvent event) {

    }
 
    // --------------
    // Filling methods
    @FXML
    void selectNoFill(ActionEvent event) {

    }

    @FXML
    void selectWithFill(ActionEvent event) {

    }


    // --------------
    // Undo + clear methods
    @FXML
    void selectClearBtn(ActionEvent event) {
    	
    	paneBoard.getChildren().clear();
    	allShapes.clear();
    }
    
    @FXML
    void undoShape(ActionEvent event) {

    	int countOfShapes = paneBoard.getChildren().size();
    	
    	// removing from the pane and the list itself
    	paneBoard.getChildren().remove(countOfShapes - 1);
    	allShapes.remove(countOfShapes-1);
    }

}
