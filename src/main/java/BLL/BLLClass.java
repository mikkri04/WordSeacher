package BLL;

import DAL.FileSeacherDAL;
import DAL.FileWriterDAL;

import java.util.ArrayList;
import java.util.List;

public class BLLClass {
    FileSeacherDAL fileSeacherDAL = new FileSeacherDAL();
    FileWriterDAL fileWriterDAL = new FileWriterDAL();
    List<String> loadedWordsWord = new ArrayList<>();
    List<String> loadedWordsHistory = new ArrayList<>();


    public List<String> getWords(){
        loadedWordsWord = fileSeacherDAL.loadWords();
        return loadedWordsWord;
    }

    public int searchWord(String seachW){
        int encoutners = 0;
        for (int i = 0; i < loadedWordsWord.size(); i++){
            if (loadedWordsWord.get(i).equalsIgnoreCase(seachW)){
                encoutners++;
            }
        }
        return encoutners;
    }

    public void historyWriter(String input){
        loadedWordsHistory = fileWriterDAL.loadWords();
        if (loadedWordsHistory.size() == 0) {fileWriterDAL.write(input, true);
        }
        else {
         fileWriterDAL.write(input, false); }
    }

    public List<String> getHistory() {
        loadedWordsHistory = fileWriterDAL.loadWords();
        if (loadedWordsHistory.size() != 0) {
            if (loadedWordsHistory.get(0) == "")
                loadedWordsHistory.remove(0);
        }
        return loadedWordsHistory;
    }

    public void clearHistory() {
        fileWriterDAL.clearHistory();
    }

}
