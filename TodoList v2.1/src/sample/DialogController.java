package sample;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.datamodel.TodoData;
import sample.datamodel.TodoItem;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;


        public TodoItem processResults(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription,details, deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);

        return newItem;
    }

    public TodoItem processResultsWithNoAdd(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription,details, deadlineValue);

        return newItem;
    }

    public void setShortDescriptionField(TextField shortDescriptionField) {
        this.shortDescriptionField = shortDescriptionField;
    }

    public void setDetailsArea(TextArea detailsArea) {
        this.detailsArea = detailsArea;
    }

    public void setDeadlinePicker(DatePicker deadlinePicker) {
        this.deadlinePicker = deadlinePicker;
    }

    public TextField getShortDescriptionField() {
        return shortDescriptionField;
    }

    public TextArea getDetailsArea() {
        return detailsArea;
    }

    public DatePicker getDeadlinePicker() {
        return deadlinePicker;
    }
}
