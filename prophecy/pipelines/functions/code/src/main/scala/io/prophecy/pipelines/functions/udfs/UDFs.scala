package io.prophecy.pipelines.functions.udfs

import _root_.io.prophecy.abinitio.ScalaFunctions._
import _root_.io.prophecy.libs._
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql._

object UDFs extends Serializable {

  def registerUDFs(spark: SparkSession) = {
    spark.udf.register("mult_self", mult_self)
    registerAllUDFs(spark)
  }

  def mult_self =
    udf((value: Int) => value * value)

}

object PipelineInitCode extends Serializable
