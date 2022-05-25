package zoo.turquoise.zooappturquoise;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import zoo.turquoise.zooappturquoise.Zoo;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

public class ZooLoader
{
    private static ArrayList<Zoo> zoos;

    private ZooLoader(){}

    public static ArrayList<Zoo> getZoos() { return zoos; }

    public static void load(String jsonPath)
    {
        //Read JSON file
        zoos = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(jsonPath))
        {

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

    public static void save(String jsonPath) throws JSONException {
        //Overwrite JSON file
        JSONArray jsonArray = new JSONArray();

        for(Zoo z : zoos)
            jsonArray.add(z.toJSONObject());


        try (FileWriter file = new FileWriter(jsonPath))
        {
            file.write(jsonArray.toJSONString());
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws JSONException {
        ZooLoader.load("./zoos.json");
        ArrayList<Zoo> zoos = ZooLoader.getZoos();
        for(Zoo zoo : zoos)
        {
            zoo.setReview("Ce zoo était formidable");
            zoo.setVisited(true);
        }
        ZooLoader.save("./zoos.json");

    }
}