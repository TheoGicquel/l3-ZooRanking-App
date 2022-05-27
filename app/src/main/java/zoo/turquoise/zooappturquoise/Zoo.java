package zoo.turquoise.zooappturquoise;
import org.json.JSONException;

import org.json.simple.JSONObject;
public class Zoo
{
    private String name, description, imageURL, userReview;
    private int countReviews, rank, scoreAccess, scoreDiversity, scorePrice, scoreTreatment;
    private float scoreCustomers;
    private float distance;
    private boolean visited;

    public Zoo()
    {
        this.name = "Zoo Inconnu";
        this.description = "description";
        this.imageURL = "https://www.cjoint.com/doc/20_12/JLFrj6Sanqu_image-not-found.png";
        this.rank = 0;
    }
    
    /*
    public static Zoo createFromJSONObject(org.json.simple.JSONObject next) {
        Zoo newZoo = new Zoo();
        next.get()
        return newZoo;
    }

     */


    public  String getName()			{ return name; }
    public void setName(String foo){this.name=foo;}
    public String getDescription() 	{ return description; }
    public String getImageURL() 	{ return imageURL; }
    public String getUserReview()	{ return userReview; }
    public int getCountReviews() 	{ return countReviews; }
    public int getRank()			{ return rank; }
    public int getScoreAccess()		{ return scoreAccess; }
    public int getScoreDiversity()	{ return scoreDiversity; }
    public int getScorePrice()		{ return scorePrice; }
    public int getScoreTreatment()	{ return scoreTreatment; }
    public float getScoreCustomers(){ return scoreCustomers; }
    public double getDistance()		{ return distance; }
    public boolean isVisited()		{ return visited; }

    public void setReview(String m)
    {
        userReview = m;
    }

    public void setVisited(boolean b)
    {
        visited = b;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public JSONObject toJSONObject() 
    {
        try
        {
            JSONObject j = new JSONObject();
            j.put("name", name);
            j.put("description", description);
            j.put("imageURL", imageURL);
            j.put("userReview", userReview);
            j.put("countReviews", countReviews);
            j.put("rank", rank);
            j.put("access", scoreAccess);
            j.put("diversity", scoreDiversity);
            j.put("price", scorePrice);
            j.put("treatment", scoreTreatment);
            j.put("score", scoreCustomers);
            j.put("distance", distance);
            j.put("visited", visited);
        }
        catch(JSONException e)
        {
            System.err.println(e.getMessage());
        }
        return j;
    }

    private static Object errorOnNull(Object o) throws NullPointerException
    {
        if(o == null)
            throw new NullPointerException();
        return o;
    }

    public static Zoo createFromJSONObject(JSONObject j)
    {
        Zoo z = new Zoo();
        try
        {
            z.name = 		     (String)errorOnNull(j.get("name"));
            z.description = 	 (String)errorOnNull(j.get("description"));
            z.imageURL = 		 (String)errorOnNull(j.get("imageURL"));
            z.userReview = 		 (String)j.get("userReview");
            z.countReviews = 	 ((Long)errorOnNull(j.get("countReviews"))).intValue();
            z.rank = 			 ((Long)errorOnNull(j.get("rank"))).intValue();
            z.scoreAccess = 	 ((Long)errorOnNull(j.get("access"))).intValue();
            z.scoreDiversity = 	 ((Long)errorOnNull(j.get("diversity"))).intValue();
            z.scorePrice = 		 ((Long)errorOnNull(j.get("price"))).intValue();
            z.scoreTreatment = 	 ((Long)errorOnNull(j.get("treatment"))).intValue();
            z.scoreCustomers = 	 ((Double)errorOnNull(j.get("score"))).floatValue();
            z.distance = 		 ((Long)errorOnNull(j.get("distance"))).floatValue();
            z.visited = 		 (Boolean)errorOnNull(j.get("visited"));
        }
        catch(NullPointerException e)
        {
            System.err.println(e.getMessage());
            return null;
        }

        return z;
    }
}