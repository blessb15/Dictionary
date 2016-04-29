import java.util.ArrayList;

public class Definitions {
  private String mDescription;
  private static ArrayList<Definitions> instances = new ArrayList<Definitions>();
  private int mId;

  public Definitions(String description){
    mDescription = description;
  }

    public String getDescription(){
      return mDescription;
    }

    public int getId() {
    return mId;
  }
}
