package io.prophecy.pipelines.functions.graph

import io.prophecy.libs._
import io.prophecy.pipelines.functions.udfs.PipelineInitCode._
import io.prophecy.pipelines.functions.udfs.UDFs._
import io.prophecy.pipelines.functions.config.Context
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object SQLStatement_0 {
  def apply(context: Context): DataFrame = context.spark.sql("select 1")
}
