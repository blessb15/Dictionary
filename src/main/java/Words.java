import java.util.ArrayList;

public class Words {
private String mWord;
private static ArrayList<Words> wordList = new ArrayList<Words>();

  public Words(String word){
    mWord = word;
    wordList.add(this);
  }

  public String returnWord(){
    return mWord;
  }

  public static ArrayList<Words> returnWordList(){
    return wordList;
  }

  public static void clear(){
    wordList.clear();
  }
}
