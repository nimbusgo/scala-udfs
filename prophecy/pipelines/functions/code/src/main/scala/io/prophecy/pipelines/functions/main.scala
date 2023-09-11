package io.prophecy.pipelines.functions

import io.prophecy.libs._
import io.prophecy.pipelines.functions.config.Context
import io.prophecy.pipelines.functions.config._
import io.prophecy.pipelines.functions.udfs.UDFs._
import io.prophecy.pipelines.functions.udfs._
import io.prophecy.pipelines.functions.udfs.PipelineInitCode._
import io.prophecy.pipelines.functions.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_SQLStatement_0 = SQLStatement_0(context)
    val df_Reformat_1     = Reformat_1(context, df_SQLStatement_0)
    val df_Reformat_2     = Reformat_2(context, df_Reformat_1)
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Prophecy Pipeline")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
      .newSession()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/functions")
    registerUDFs(spark)
    try MetricsCollector.start(spark, "pipelines/functions", context.config)
    catch {
      case _: Throwable =>
        MetricsCollector.start(spark, "pipelines/functions")
    }
    apply(context)
    MetricsCollector.end(spark)
  }

}
