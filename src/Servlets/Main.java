package Servlets;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		/*java.util.Date date = new java.util.Date();
		Date laDate = new Date(date.getTime());
		String laDateString = laDate.toString();
		String laDateStringCorrige = "\"" + laDateString + "\"";
		System.out.println(laDate);*/
		
		String matrice = "dd/MM/yyyy";
		Instant laDate = Instant.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern(matrice);
		ZoneId fuseau = ZoneId.systemDefault();
		ZonedDateTime dateSurFuseau = laDate.atZone(fuseau);
		String date = format.format(dateSurFuseau);
		System.out.println("Date : " + date);
	}
}
