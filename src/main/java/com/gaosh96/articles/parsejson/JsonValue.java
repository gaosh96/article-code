package com.gaosh96.articles.parsejson;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.apache.flink.table.functions.ScalarFunction;

/**
 * @author gaosh
 * @version 1.0
 * @since 2024/3/25
 */
public class JsonValue extends ScalarFunction {

    public String eval(String json, String path) {
        if (json != null && path != null) {
            Configuration conf = Configuration.builder()
                    .options(Option.DEFAULT_PATH_LEAF_TO_NULL)
                    .build();
            return JsonPath.using(conf).parse(json).read(path);
        }

        return null;
    }

}
