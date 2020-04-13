/**
 * 
 */
package ca.scheid.data;

import java.nio.ByteBuffer;

import ca.scheid.enums.DriverStatus;
import ca.scheid.enums.PitStatus;
import ca.scheid.enums.ResultStatus;
import ca.scheid.enums.Sector;
import ca.scheid.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com Apr 8, 2020
 */

@ToString(includeFieldNames = true)
public class LapData {
	
	/**
	 * Last lap time in seconds 
	 */
	@Getter
	@Setter
	private float lastLapTime;

	/**
	 * Current time around the lap in seconds
	 */
	@Getter
	@Setter
	private float currentLapTime;

	/**
	 * Best lap time of the session in seconds
	 */
	@Getter
	@Setter
	private float bestLapTime;

	/**
	 * Sector 1 time in seconds
	 */
	@Getter
	@Setter
	private float sector1Time;

	/**
	 * Sector 2 time in seconds
	 */
	@Getter
	@Setter
	private float sector2Time;

	/**
	 * Distance vehicle is around current lap in meters – can
	 * be negative if line hasn’t been crossed yet
	 */
	@Getter
	@Setter
	private float lapDistance;

	
	/**
	 * Total distance traveled in session in meters – could
	 * be negative if line hasn’t been crossed yet
	 */
	@Getter
	@Setter
	private float totalDistance;

	/**
	 * Delta in seconds for safety car
	 */
	@Getter
	@Setter
	private float safetyCarDelta;

	/**
	 * Car race position
	 */
	@Getter
	@Setter
	private short carPosition;

	/**
	 * Current lap number
	 */
	@Getter
	@Setter
	private short currentLapNum;

	/**
	 * See PitStatus.enum
	 */
	@Getter
	@Setter
	private String pitStatus;

	/**
	 * See Sector.enum
	 */
	@Getter
	@Setter
	private String sector;

	/**
	 * Current lap invalid - 0 = valid, 1 = invalid
	 */
	@Getter
	@Setter
	private boolean currentLapInvalid;

	/**
	 * Accumulated time penalties in seconds to be added
	 */
	@Getter
	@Setter
	private short penalties;

	/**
	 * Grid position the vehicle started the race in
	 */
	@Getter
	@Setter
	private short griPosition;

	
	/**
	 * See DriverStatus.enum
	 */
	@Getter
	@Setter
	private String driverStatus;

	/**
	 * See ResultStatus.enum
	 */
	@Getter
	@Setter
	private String resultStatus;

	public LapData(ByteBuffer byteBuffer) {
		this.lastLapTime = byteBuffer.getFloat();
		this.currentLapTime = byteBuffer.getFloat();
		this.bestLapTime = byteBuffer.getFloat();
		this.sector1Time = byteBuffer.getFloat();
		this.sector2Time = byteBuffer.getFloat();
		this.lapDistance = byteBuffer.getFloat();
		this.totalDistance = byteBuffer.getFloat();
		this.safetyCarDelta = byteBuffer.getFloat();
		this.carPosition = Utils.convert_uint8(byteBuffer.get());
		this.currentLapNum = Utils.convert_uint8(byteBuffer.get());
		this.pitStatus = getThePitStatus(Utils.convert_uint8(byteBuffer.get()));
		this.sector = getTheSector(Utils.convert_uint8(byteBuffer.get()));
		this.currentLapInvalid = getTheCurrentLapValidStatus(Utils.convert_uint8(byteBuffer.get()));
		this.penalties = Utils.convert_uint8(byteBuffer.get());
		this.griPosition = Utils.convert_uint8(byteBuffer.get());
		this.driverStatus = getTheDriverStatus(Utils.convert_uint8(byteBuffer.get()));
		this.resultStatus = getTheResultStatus(Utils.convert_uint8(byteBuffer.get()));
	}
	
	public String getThePitStatus(short code) {
		for(PitStatus ps : PitStatus.values())
			if(ps.getCode() == code)
				return ps.getStatus();
		return "LapData:getThePitStatus=Pit status invalid!";
	}
	
	public boolean getTheCurrentLapValidStatus(short code) {
		if(code == 0) return false;
		return true;
	}
	
	public String getTheSector(short code) {
		for(Sector s : Sector.values())
			if(s.getCode() == code)
				return s.getSector();
		return "LapData:getTheSector=Invalid sector code!";
	}
	
	public String getTheDriverStatus(short code) {
		for(DriverStatus ds : DriverStatus.values())
			if(ds.getCode() == code)
				return ds.getDriverStatus();
		return "LapData:getTheDriverStatus=Invalid driver status!";
	}
	
	public String getTheResultStatus(short code) {
		for(ResultStatus rs : ResultStatus.values())
			if(rs.getCode() == code)
				return rs.getResultStatus();
		return "LapData:getTheResultStatus=Invalid result status!";
	}
}
