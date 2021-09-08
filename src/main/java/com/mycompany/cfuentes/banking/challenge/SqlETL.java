/**
 * 
 */
package com.mycompany.cfuentes.banking.challenge;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * @author chema
 *
 */
public class SqlETL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SparkSession spark = SparkSession
				  .builder()
				  .appName("ETL for SQL loading")
				  .master("local")
				  //.config("spark.some.config.option", "some-value")
				  .getOrCreate();
		
		Dataset<Row> df = spark.read().format("csv")
				  .option("inferSchema", "true")
				  .option("header", "true")
				  .option("mode", "DROPMALFORMED")
				  .load("src/main/resources/bank.csv");
		
		
		df.write()
		  .format("jdbc")
		  .option("url", "jdbc:postgresql:banking_db")
		  .option("dbtable", "bank_csv")
		  .option("user", "puser")
		  .option("password", "very_secret_password_1")
		  .save();
	}

}
