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

	private enum ShapeToDraw {
		Line, Rectangle, Ellipse
	};
	
	// JAVAFX - Variables	
	
    @FXML private Pane paneBoard;

    @FXML private ToggleGroup shapeSelection;
    @FXML private ToggleGroup colorSelection;
    @FXML private ToggleGroup fillSelection;

    // Shapes Buttons
    @FXML private RadioButton ellipseRadioBtn;
    @FXML private RadioButton lineRadioBtn;
    @FXML private RadioButton rectangleRadioBtn;
    
    // Colors Buttons
    @FXML private RadioButton greenColBtn;
    @FXML private RadioButton redColorBtn;
    @FXML private RadioButton yellowColBtn;
    @FXML private RadioButton blackColorBtn;
    @FXML private RadioButton blueColBtn;

    // Filing buttons
    @FXML private RadioButton setFillBtn;
    @FXML private RadioButton setNotFillBtn;

    // Undo and clear
    @FXML private Button clearBtn;
    @FXML private Button undoBtn;

    
    
    // Private variables
    private List<Shape> allShapes;
    private ShapeToDraw theShapeToDraw;	// the selected shape that the user chose to draw
    private boolean fillShape;	// True - with filling, False - without
    private Color shapeColor;	// the new shapes color
    
    // The Points to start draw from and the end
    private double coordStartX;
    private double coordStartY;
    private double coordEndX;
    private double coordEndY;
    
    // Set all the User default values to each Button as needed
    public void initialize() {
		
    	allShapes = new ArrayList<Shape>();
    	
    	// Color initializations
    	greenColBtn.setUserData(Color.GREEN);
    	redColorBtn.setUserData(Color.RED);
    	yellowColBtn.setUserData(Color.YELLOW);
    	blackColorBtn.setUserData(Color.BLACK);
    	blueColBtn.setUserData(Color.BLUE);
    	
    	//shapes initialization
    	ellipseRadioBtn.setUserData(ShapeToDraw.Ellipse);
    	lineRadioBtn.setUserData(ShapeToDraw.Line);
    	rectangleRadioBtn.setUserData(ShapeToDraw.Rectangle);	
    }

    
    // Get the start coordinates to create the shape
    @FXML
    void startPaintFromHere(MouseEvent event) {

    	coordStartX = event.getX();
    	coordStartY = event.getY();
    }
    
    // The method will get the coordinates at the end of the shape + paint it 
    @FXML
    void finishPaintHere(MouseEvent event) {

     	coordEndX = event.getX();
    	coordEndY = event.getY();
    	
    	// Done with all properties for drawing - method to create the shape
    	paintShape();
    }

    // The method will set the current color of the shape, according to the user's choice
    @FXML
    void selectColor(ActionEvent event) {
    	shapeColor = (Color) colorSelection.getSelectedToggle().getUserData();
    }

    // The method will set the current shape to draw of the class, according to the user's choice
    @FXML
    void selectShape(ActionEvent event) {
    	theShapeToDraw = (ShapeToDraw) shapeSelection.getSelectedToggle().getUserData();
    }
 
    // Set the filling flag to false - to filing
    @FXML
    void selectNoFill(ActionEvent event) {
    	fillShape = false;
    }

    // Set the filling flag to true - for the creation
    @FXML
    void selectWithFill(ActionEvent event) {
    	fillShape = true;
    }

    // The method will clear all the Pane and list from the shapes
    @FXML
    void selectClearBtn(ActionEvent event) {
    	
    	paneBoard.getChildren().clear();
    	allShapes.clear();
    }
    
    // The method will remove the last shape entered from the Container
    @FXML void undoShape(ActionEvent event) {

    	int countOfShapes = paneBoard.getChildren().size();
    	
    	// removing from the pane and the list itself
    	paneBoard.getChildren().remove(countOfShapes - 1);
    	allShapes.remove(countOfShapes - 1);
    }
    
    
    // Method that will create the shape object, color it + fill it if needed and return it
    private Shape createShapeToDraw() {
    	
    	Shape newShape = null;
    
    	switch(theShapeToDraw) {
    	
    	case Line:
    		newShape = new Line(coordStartX, coordStartY, coordEndX, coordEndY);
    		newShape.setStroke(shapeColor);
    		break;
    	case Rectangle:
    		newShape = new Rectangle(Math.min(coordStartX, coordEndX), Math.min(coordStartY, coordEndY),
    				calcWidth(), calcHeight() );
    		break;
    	case Ellipse:
    		newShape = new Ellipse(coordStartX, coordStartY, calcWidth(), calcHeight() );
    		break;
		default:
			break;
    	}
    	
    	
    	if (newShape != null) {
	    	// Add the Stroke(Border) + the filling of the Shape as needed
	    	if(theShapeToDraw != ShapeToDraw.Line)	{
		    	if (fillShape)
		    		newShape.setFill(shapeColor);
		    	else	{
		    		newShape.setStroke(shapeColor);
		    		newShape.setFill(Color.TRANSPARENT);
		    	}
	    	}
    	}
    	
    	return newShape;
    }
    	
    // Method that will calculate the width or radius x of the Shape
    private double calcWidth() {
    
    	return Math.abs( coordEndX - coordStartX );
    }
    
 // Method that will calculate the height or radius Y of the Shape
    private double calcHeight() {
    	
    	return Math.abs( coordEndY - coordStartY );
    }

    // Method to finally create the shape and add it to the Pane  + List
    private void paintShape() {
    	// Create the new shape
    	Shape newShapeToInsert = createShapeToDraw();
    	
    	// Add the new shape
    	paneBoard.getChildren().add(newShapeToInsert);
    	allShapes.add(newShapeToInsert);
    }
}
