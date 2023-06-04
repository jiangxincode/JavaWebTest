package hibernate1;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HbmToTable {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		System.out.println("Creating tables...");
		SchemaExport schemaExport = new SchemaExport(config);
		schemaExport.create(true, true);

		System.out.println("successful");
	}
}