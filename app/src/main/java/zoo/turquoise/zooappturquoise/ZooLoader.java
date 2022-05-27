package zoo.turquoise.zooappturquoise;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import zoo.turquoise.zooappturquoise.Zoo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ZooLoader
{
    private static ArrayList<Zoo> zoos;
    private static Context context;
    private static int selectedZooRank;
    
    private ZooLoader(){}

    public static void setSelectedZoo(int select){selectedZooRank = select;}
    public static int getSelectedZooRank(){return selectedZooRank;}

    public static ArrayList<Zoo> getZoos() { return zoos; }

    public static void load(String jsonPath) {
        //Read JSON file
        zoos = new ArrayList<>();
        JSONParser parser = new JSONParser();

        // TODO : attempt reading previously saved data instead of reading static asset file

        try (Reader reader =  new BufferedReader(new InputStreamReader(fiopen)))
        {
            // asset management
            AssetManager assetManager = context.getAssets();
            InputStream fiopen = assetManager.open(jsonPath);

            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while(iterator.hasNext())
                zoos.add(Zoo.createFromJSONObject(iterator.next()));
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
        catch (ParseException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static void save(String jsonPath) {
        //Overwrite JSON file
        try
        {
            JSONArray jsonArray = new JSONArray();

            for(Zoo z : zoos)
                jsonArray.add(z.toJSONObject());
        }
        catch(JSONException e)
        {
            System.err.println(e.getMessage());
        }

        // TODO : implement saving to local storage
        try (FileWriter file = new FileWriter(jsonPath))
        {
            file.write(jsonArray.toJSONString());
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static void setContext(Context applicationContext) {
        context = applicationContext;
    }
}