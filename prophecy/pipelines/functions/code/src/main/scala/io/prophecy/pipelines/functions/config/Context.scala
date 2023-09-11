package io.prophecy.pipelines.functions.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
