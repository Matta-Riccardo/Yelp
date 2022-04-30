package it.polito.tdp.Yelp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class DBConnect {
	
	//Sostiuisco la precedente classe DBConnect con un membro statico e un controllo sul fatto che il membro statico abbia ancora 
	//il valore iniziale o sia già stato sostituito da un oggetto vero e proprio. Questo pattern di programmazione si chiama SINGLETON
	 
	
	static private HikariDataSource ds = null; //questa proprietà la devo memorizzare in modo statico in questa classe (DBConnect)
	                                           //in modo tale che ogni volta che io chiamo il metodo getConnection() mi venga data
											   //una nuova connessione, ma della stessa DataSource che aveva già prima. Non devo 
	                                           //chiamare questa istruzione (crea un nuovo DataSource) ogni volta che chiamo la 
	                                           //getConnection, ma deve essere fatta una volta sola all'avvio del programma.
	static private String  url ="jdbc:mysql://localhost:3306/Yelp";
	
	public static Connection getConnection() {
		//Come prima cosa verifico se l'ho già creata/aperta dal DataSource
		
		if(ds==null) {
			//Allora creo un nuovo DataSource (do alla classe DataSource le informazioni che le servono per aprire una nuova connessione)
			//A noi non interessa se questa connessione venga aperta subito oppure se venga aperta la prima volta che le servirà davvero.
			ds = new HikariDataSource();
			ds.setJdbcUrl(url);
			ds.setUsername("root");
			ds.setPassword("!toor@");	
		}
		
		try {
			return ds.getConnection(); //Restuisco una nuova connessione dal DataSource che ho appena creato o che avevo già creato prima
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} 
		
	}
	
}
