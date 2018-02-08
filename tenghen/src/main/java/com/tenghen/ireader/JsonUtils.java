package com.tenghen.ireader;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.tenghen.ireader.module.ParentComment;

import java.lang.reflect.Type;

public class JsonUtils {

    public static class ParentCommentDeserializer implements JsonDeserializer<ParentComment> {
        @Override
        public ParentComment deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            ParentComment size = null;
            if (json.isJsonObject()) {
                //类型正确
                JsonObject jsonObject = json.getAsJsonObject();
                Gson gson = new Gson();
                size = gson.fromJson(json,ParentComment.class);

            }
            return size;
        }
    }
}