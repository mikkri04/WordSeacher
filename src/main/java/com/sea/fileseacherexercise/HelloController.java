package com.sea.fileseacherexercise;

import BLL.BLLClass;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;

public class HelloController {
    BLLClass bll = new BLLClass();

    @FXML
    private Label welcomeText;

    @FXML
    private ListView wordsLW;

    @FXML
    private ListView historyLW;

    @FXML
    private TextField inputText;

    @FXML
    private void seach(){
        int encounters = bll.searchWord(inputText.getText());
        if(encounters != 0)
        {
            bll.historyWriter("Seach for '" + inputText.getText() + "' found " + encounters + " encounters");
        }
        else {
            bll.historyWriter("No counters were found");
        }
        updateHistory();
        wordsLW.scrollTo(inputText.getText());
        wordsLW.requestFocus();
    }

    @FXML
    public void updateHistory(){
        historyLW.getItems().clear();
        List<String> history = bll.getHistory();
        for (int i = 0; i < history.size(); i++){
            historyLW.getItems().add(history.get(i));
        }
    }

    @FXML
    public void loadWordsLW() {
        for (String s : bll.getWords()){
            wordsLW.getItems().add(s);
        }

    }
    public void initialize(){
        loadWordsLW();
        updateHistory();
    }

    @FXML
    public void clearHistory(){
        bll.clearHistory();
        updateHistory();
    }



}
