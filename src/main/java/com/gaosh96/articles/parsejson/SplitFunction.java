package com.gaosh96.articles.parsejson;

import org.apache.flink.table.annotation.DataTypeHint;
import org.apache.flink.table.annotation.FunctionHint;
import org.apache.flink.table.functions.TableFunction;
import org.apache.flink.types.Row;

/**
 * @author gaosh
 * @version 1.0
 * @since 2024/3/25
 */
@FunctionHint(output = @DataTypeHint("ROW<data STRING>"))
public class SplitFunction extends TableFunction<Row> {

    public void eval(String line, String splitSign) {
        if (line != null && splitSign != null) {
            for (String s : line.split(splitSign)) {
                collect(Row.of(s));
            }
        }
    }

}
