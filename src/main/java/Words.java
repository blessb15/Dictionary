import java.util.ArrayList;

public class Words {
private String mWord;
private static ArrayList<Words> wordList = new ArrayList<Words>();
private int mId;
private ArrayList<Definitions> mDefinitions;


  public Words(String word){
    mWord = word;
    wordList.add(this);
    mId = wordList.size();
    mDefinitions = new ArrayList<Definitions>();
  }

  public String returnWord(){
    return mWord;
  }

  public static ArrayList<Words> all() {
    return wordList;
  }

  public static void clear(){
    wordList.clear();
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

  public ArrayList<Definitions> getDefinition(){
    return mDefinitions;
  }

  public void addDefinition(Definitions definition){
    mDefinitions.add(definition);
  }
}
