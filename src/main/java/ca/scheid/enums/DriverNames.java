/**
 * 
 */
package ca.scheid.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com Apr 8, 2020
 */

@AllArgsConstructor
public enum DriverNames {
	CARLOS_SAINZ((byte) 0, "Carlos Sainz"), DANIIL_KVYAT((byte) 1, "Daniil Kvyat"),
	DANIEL_RICCIARDO((byte) 2, "Daniel Ricciardo"), KIMI_RAIKKONEN((byte) 6, "Kimi Räikkönen"),
	LEWIS_HAMILTON((byte) 7, "Lewis Hamilton"), MAX_VESTAPPEN((byte) 9, "Max Verstappen"),
	NICO_HULKENBERG((byte) 10, "Nico Hulkenberg"), KEVIN_MAGNUSSEN((byte) 11, "Kevin Magnussen"),
	ROMAIN_GROSJEAN((byte) 12, "Romain Grosjean"), SEBASTIAN_VETTEL((byte) 13, "Sebastian Vettel"),
	SERGIO_PEREZ((byte) 14, "Sergio Perez"), VALTEERY_BOTTAS((byte) 15, "Valtteri Bottas"),
	LANCE_STROLL((byte) 19, "Lance Stroll"), ARRON_BARNES((byte) 20, "Arron Barnes"),
	MARTIN_GILES((byte) 21, "Martin Giles"), ALEX_MURRAY((byte) 22, "Alex Murray"), LUCAS_ROTH((byte) 23, "Lucas Roth"),
	IGOR_CORREIA((byte) 24, "Igor Correia"), SOPHIE_LEVASSEUR((byte) 25, "Sophie Levasseur"),
	JONAS_SCHIFFER((byte) 26, "Jonas Schiffer"), ALAIN_FOREST((byte) 27, "Alain Forest"),
	JAY_LETOURNEAU((byte) 28, "Jay Letourneau"), ESTO_SAARI((byte) 29, "Esto Saari"),
	YASAR_ATIYEH((byte) 30, "Yasar Atiyeh"), CALLISTO_CALABRESI((byte) 31, "Callisto Calabresi"),
	NAOTA_IZUM((byte) 32, "Naota Izum"), HOWARD_CLARKE((byte) 33, "Howard Clarke"),
	WILHELM_KAUFMANN((byte) 34, "Wilhelm Kaufmann"), MARIE_LAURSEN((byte) 35, "Marie Laursen"),
	FLAVIO_NIEVES((byte) 36, "Flavio Nieves"), PETER_BELOUSOV((byte) 37, "Peter Belousov"),
	KLIMEK_MICHALSKI((byte) 38, "Klimek Michalski"), SANTIAGO_MORENO((byte) 39, "Santiago Moreno"),
	BENJAMIN_COPPENS((byte) 40, "Benjamin Coppens"), NOAH_VISSER((byte) 41, "Noah Visser"),
	GERT_WALDMULLER((byte) 42, "Gert Waldmuller"), JULIAN_QUESADA((byte) 43, "Julian Quesada"),
	DANIEL_JONES((byte) 44, "Daniel Jones"), ARTEM_MARKELOV((byte) 45, "Artem Markelov"),
	TADASUKE_MAKINO((byte) 46, "Tadasuke Makino"), SEAN_GELAEL((byte) 47, "Sean Gelael"),
	NYCK_DE_VRIES((byte) 48, "Nyck De Vries"), JACK_AITKEN((byte) 49, "Jack Aitken"),
	GEORGE_RUSSEL((byte) 50, "George Russell"), MAXIMILLIAN_GUNTHER((byte) 51, "Maximilian Günther"),
	NIREI_FUKUMUZI((byte) 52, "Nirei Fukuzumi"), LUCA_GHIOTTO((byte) 53, "Luca Ghiotto"),
	LANDO_NORRIS((byte) 54, "Lando Norris"), SERGIO_CAMARA((byte) 55, "Sérgio Sette Câmara"),
	LOUIS_DELETRAZ((byte) 56, "Louis Delétraz"), ANTONIO_FUOCO((byte) 57, "Antonio Fuoco"),
	CHARLES_LECLERC((byte) 58, "Charles Leclerc"), PIERRE_GASLY((byte) 59, "Pierre Gasly"),
	ALEXANDER_ALBON((byte) 62, "Alexander Albon"), NICHOLAS_LATIFI((byte) 63, "Nicholas Latifi"),
	DORIAN_BOCCOLACCI((byte) 64, "Dorian Boccolacci"), NIKO_KARI((byte) 65, "Niko Kari"),
	ROBERTO_MERHI((byte) 66, "Roberto Merhi"), ARJUN_MAINI((byte) 67, "Arjun Maini"),
	ALESSIO_LORANDI((byte) 68, "Alessio Lorandi"), RUBEN_MEIJER((byte) 69, "Ruben Meijer"),
	RAHISH_NAIR((byte) 70, "Rashid Nair"), JACK_TREMBLAY((byte) 71, "Jack Tremblay"),
	ANTONIO_GIOVINAZZI((byte) 74, "Antonio Giovinazzi"), ROBERT_KUBICA((byte) 75, "Robert Kubica");

	@Getter
	private final byte code;

	@Getter
	private final String driverName;

}
