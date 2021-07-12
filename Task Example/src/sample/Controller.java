package sample;

import com.sun.org.apache.regexp.internal.RE;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {
    @FXML
    private ListView listView;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressLabel;

    private Service<ObservableList<String>> service;

    public void initialize(){
//        task = new Task<ObservableList<String>>() {
//            @Override
//            protected ObservableList<String> call() throws Exception {
//                String[] names ={"bobby", "marty", "july", "a", "b", "c"};
//
//                ObservableList<String> employees = FXCollections.observableArrayList();
//                for (int i = 0; i < 6; i++) {
//                    employees.add(names[i]);
//                    updateMessage("added \" " + names[i] + "\" to the list");
//                    updateProgress(i + 1, 6);
//                    Thread.sleep(200);
//                }
//                return employees;
//            }
//        };
        service = new EmployeeService();
//        service.setOnRunning(new EventHandler<WorkerStateEvent>() {
////            @Override
////            public void handle(WorkerStateEvent event) {
////                progressBar.setVisible(true);
////                progressLabel.setVisible(true);
////            }
////        });
////
////        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
////            @Override
////            public void handle(WorkerStateEvent event) {
////                progressBar.setVisible(false);
////                progressLabel.setVisible(false);
////            }
////        });
////        progressBar.setVisible(false);
////        progressLabel.setVisible(false);

        progressBar.visibleProperty().bind(service.runningProperty());
        progressLabel.visibleProperty().bind(service.runningProperty());

        progressBar.progressProperty().bind(service.progressProperty());
        progressLabel.textProperty().bind(service.messageProperty());
        listView.itemsProperty().bind(service.valueProperty());

    }

    @FXML
    public void buttonPressed() {
        if(service.getState() == Service.State.SUCCEEDED){
            service.reset();
            service.start();
        }else if(service.getState() == Service.State.READY) {
            service.start();
        }
    }
}
