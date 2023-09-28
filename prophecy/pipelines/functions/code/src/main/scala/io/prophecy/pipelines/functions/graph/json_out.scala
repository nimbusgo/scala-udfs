package io.prophecy.pipelines.functions.graph

import io.prophecy.libs._
import io.prophecy.pipelines.functions.config.Context
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object json_out {

  def apply(context: Context, in: DataFrame): Unit = {
    var writer = in.write.format("json")
    writer = writer
    writer.save("/tmp/json_out")
  }

}
