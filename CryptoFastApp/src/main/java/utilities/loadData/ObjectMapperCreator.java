package utilities.loadData;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperCreator
{

    private static ObjectMapper objectMapper = null;
    public static ObjectMapper getInstance()
    {
        if (objectMapper == null)
            objectMapper = new ObjectMapper();

        return objectMapper;
    }
}
