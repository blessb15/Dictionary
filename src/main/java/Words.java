import java.util.ArrayList;

public class Words {
private String mWord;
private static ArrayList<Words> wordList = new ArrayList<Words>();
private ArrayList<Definitions> mDefinitions;
private int mId;

  public Words(String word){
    mWord = word;
    wordList.add(this);
    mDefinitions = new ArrayList<Definitions>();
    mId = wordList.size();
  }

  public String returnWord(){
    return mWord;
  }

  public static ArrayList<Words> returnWordList(){
    return wordList;
  }

  public int getId(){
    return mId;
  }

  public static Words find(int id){
    try{
      return wordList.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear(){
    wordList.clear();
  }

  public void addDefinition(Definitions definition){
    mDefinitions.add(definition);
  }

  public ArrayList<Definitions> getDefinition(){
    return mDefinitions;
  }
}
