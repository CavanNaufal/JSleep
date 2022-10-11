package MuhammadCavanNaufalAziziJSleepDN;

import java.util.HashMap;

public class Serializable
{
    // instance variables - replace the example below with your own
    public final int id;
    private static HashMap<Class <?>, Integer> mapCounter = new HashMap<>();
    
    protected Serializable()
    {
        Integer tempId;
        if(mapCounter.containsKey(this.getClass()))
        {
            tempId = mapCounter.get(this.getClass());
            tempId += 1;
        }
        else
        {
            tempId = 0;
        }

        this.id = tempId;
        mapCounter.put(this.getClass(), id);
    }

    public boolean equals(Object temp)
    {
        return (temp instanceof Serializable && ((Serializable) temp).id == this.id);
    }

    public boolean equals(Serializable tempId)
    {
        return tempId.id == id;
    }

    public static <T> Integer getClosingId(Class<T> getId)
    {
        return mapCounter.get(getId);
    }

    public static <T> Integer setClosingId(Class<T> setId, int number)
    {
        return mapCounter.replace(setId, number);
    }
}
