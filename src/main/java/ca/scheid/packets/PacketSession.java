/**
 * 
 */
package ca.scheid.packets;

import java.nio.ByteBuffer;

import ca.scheid.data.MarshalZone;
import ca.scheid.enums.FormulaType;
import ca.scheid.enums.Race;
import ca.scheid.enums.Weather;
import ca.scheid.utils.Utils;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 9, 2020
 */

@ToString(includeFieldNames=true)
public class PacketSession {
	/**
	 * See Weather.enum
	 */
	@Getter
	private String weather;
	
	/**
	 * Track temp. in degrees celsius
	 */
	@Getter
	private byte trackTemperature;
	
	/**
	 * Air temp. in degrees celsius
	 */
	@Getter
	private byte airTemperature;
	
	/**
	 * Total number of laps in this race
	 */
	@Getter
	private short totalLaps;
	
	/**
	 * Track length in metres
	 */
	@Getter
	private short trackLength;
	
	/**
	 * 0 = unknown, 1 = P1, 2 = P2, 3 = P3, 4 = Short P
	 * 5 = Q1, 6 = Q2, 7 = Q3, 8 = Short Q, 9 = OSQ
	 * 10 = R, 11 = R2, 12 = Time Trial
	 */
	@Getter
	private short sessionType;
	
	/**
	 * See Race.enum
	 */
	@Getter
	private String track;
	
	/**
	 * See FormulaType.enum
	 */
	@Getter
	private String formula;
	
	/**
	 * Time left in session in seconds
	 */
	@Getter
	private short sessionTimeLeft;
	
	/**
	 * Session duration in seconds
	 */
	@Getter
	private short sessionDuration;
	
	/**
	 * Pit speed limit in kilometres per hour
	 */
	@Getter
	private short pitSpeedLimit;
	
	/**
	 * Whether the game is paused
	 */
	@Getter
	private short gamePaused;
	
	/**
	 * Whether the player is spectating
	 */
	@Getter
	private short isSpectating;
	
	/**
	 * Index of the car being spectated
	 */
	@Getter
	private short spectatorCarIndex;
	
	/**
	 * SLI Pro support, 0 = inactive, 1 = active
	 */
	@Getter
	private short sliProNative;
	
	/**
	 * Number of marshal zones to follow
	 */
	@Getter
	private short numMarshalZones;
	
	/**
	 * List of marshal zones – max 21
	 */
	@Getter
	private MarshalZone[] marshalZone;
	
	/**
	 * 0 = no safety car, 1 = full safety car
	 * 2 = virtual safety car
	 */
	@Getter
	private short safetyCarStatus;
	
	/**
	 * 0 = offline, 1 = online
	 */
	@Getter
	private short networkGame;
	
	public PacketSession(ByteBuffer byteBuffer) {
		this.weather = initializeWeather(Utils.convert_uint8(byteBuffer.get()));
		this.trackTemperature = byteBuffer.get();
		this.airTemperature = byteBuffer.get();
		this.totalLaps = Utils.convert_uint8(byteBuffer.get());
		this.trackLength = Utils.convert_uint16(byteBuffer.getShort());
		this.sessionType = Utils.convert_uint8(byteBuffer.get());
		this.track = getTrackName(byteBuffer.get());
		this.formula = getFormula(Utils.convert_uint8(byteBuffer.get()));
		this.sessionTimeLeft = Utils.convert_uint16(byteBuffer.getShort());
		this.sessionDuration = Utils.convert_uint16(byteBuffer.getShort());
		this.pitSpeedLimit = Utils.convert_uint8(byteBuffer.get());
		this.gamePaused = Utils.convert_uint8(byteBuffer.get());
		this.isSpectating = Utils.convert_uint8(byteBuffer.get());
		this.spectatorCarIndex = Utils.convert_uint8(byteBuffer.get());
		this.sliProNative = Utils.convert_uint8(byteBuffer.get());
		this.numMarshalZones = Utils.convert_uint8(byteBuffer.get());
		this.marshalZone = getMarshalZones(byteBuffer);
		this.safetyCarStatus = Utils.convert_uint8(byteBuffer.get());
		this.networkGame = Utils.convert_uint8(byteBuffer.get());
	}
	
	private MarshalZone[] getMarshalZones(ByteBuffer byteBuffer) {
		MarshalZone[] aux = new MarshalZone[21];
		for(int i=0;i<21;i++) aux[i] = new MarshalZone(byteBuffer);
		return aux;
	}
	
	private String getFormula(short code) {
		for(FormulaType ft : FormulaType.values())
			if(ft.getCode() == code)
				return ft.getFormulaType();
		return "PacketSession:getFormula=Invalid formula code!";
	}
	
	private String getTrackName(byte code) {
		for(Race r : Race.values())
			if(r.getCode() == code)
				return r.getRaceName();
		return "PacketSession:getTrackName=Invalid track code!";
	}
	
	private String initializeWeather(short code) {
		for(Weather w : Weather.values())
			if(w.getCode() == code)
				return w.getWeather();
		return "PacketSession:initializeWeather=Invalid Code!";
	}
}
