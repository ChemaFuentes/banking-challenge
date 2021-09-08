/**
 * 
 */
package com.mycompany.cfuentes.banking.challenge;
import static org.apache.spark.sql.functions.*;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * @author chema
 *
 */
public class QueriesETL {

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
		
		// ¿Cual es el rango de edad, qué contrata más prestamos?
		df.where("loan == 'yes'").groupBy("age").count().orderBy(desc("count")).show(1);
		
		// ¿Cuál es el rango edad y estado civil que tiene más dinero en las cuentas?
		df.groupBy("age", "marital").sum("balance").orderBy(desc("sum(balance)")).show(1);
		
		// ¿Cuál es la forma más común de contactar a los clientes, entre 25-35 años?
		df.where("age >= 25 AND age <= 35").groupBy("contact").count().orderBy(desc("count")).show(1);
	
		// ¿Cuál es el balance medio, máximo y minimo por cada tipo de campaña, teniendo en
		// cuenta su estado civil y profesión?
		df.groupBy("campaign", "marital","job").agg(mean("balance"), max("balance"), min("balance")).orderBy("campaign", "marital","job").show();
		
		// ¿Cuál es el tipo de trabajo más común, entre los casados (job=married), que tienen
		// casa propia (housing=yes), y que tienen en la cuenta más de 1.200€ y qué son de la
		// campaña 3?
		df.where("marital == 'married' AND campaign == 3 AND balance > 1200 AND housing == 'yes'").groupBy("job").count().orderBy(desc("count")).show(1);
	}

}
