package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;


public class Controller {
    @FXML
    private Label label;
    @FXML
    private Button button4;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;

    public void initialize() {
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter(){
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit(){
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Application File");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text","*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("All", "*.*"));
        //DirectoryChooser chooser = new DirectoryChooser();
        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if (file != null){
            for (File f: file) {
                System.out.println(f.getPath());
            }

        }else{
            System.out.println("Chooser was canceled");
        }
    }

    @FXML
    public void handleLinkClick() {
//        try{
//            Desktop.getDesktop().browse(new URI("https://www.javafx.com"));
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (URISyntaxException e){
//            e.printStackTrace();
//        }
        WebEngine engine = webView.getEngine();
        engine.load("http://www.javafx.com");
    }
}
