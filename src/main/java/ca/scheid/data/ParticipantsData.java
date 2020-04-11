/**
 * 
 */
package ca.scheid.data;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import ca.scheid.enums.DriverNames;
import ca.scheid.enums.Race;
import ca.scheid.enums.Teams;
import ca.scheid.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 8, 2020
 */

@ToString(includeFieldNames=true)
public class ParticipantsData {
		/**
		 * Whether the vehicle is AI (1) or Human (0) controlled
		 */
		@Getter @Setter
		private boolean aiControlled;
		
		/**
		 * See DriverNames.enum
		 */
		@Getter @Setter
		private String driverName;
		
		/**
		 * See Teams.enum
		 */
		@Getter @Setter
		private String teamId;
		
		/**
		 * See race.enum
		 */
		@Getter @Setter
		private String raceNumber;
		
		/**
		 * nationality; enum not implemented yet
		 */
		@Getter @Setter
		private short nationality;
		
		/**
		 * Name of participant in UTF-8 format – null terminated
		 * Will be truncated with … (U+2026) if too long
		 */
		@Getter @Setter
		private String name;
		
		/**
		 * The player's UDP setting, 0 = restricted, 1 = public
		 */
		@Getter @Setter
		private String yourTelemetry;
		
		public ParticipantsData(ByteBuffer byteBuffer) {
			this.aiControlled = getTheAiControlled(Utils.convert_uint8(byteBuffer.get()));
			this.driverName = getTheDriverName(Utils.convert_uint8(byteBuffer.get()));
			this.teamId = getTheTeamName(Utils.convert_uint8(byteBuffer.get()));
			this.raceNumber = getTheRaceName(Utils.convert_uint8(byteBuffer.get()));
			this.nationality = Utils.convert_uint8(byteBuffer.get());
			byte[] aux = new byte[48];
			for(int i=0;i<48;i++) aux[i] = byteBuffer.get();
			this.name = (new String(aux, Charset.forName("UTF-8"))).trim();
			this.yourTelemetry = getYourTelemetry(Utils.convert_uint8(byteBuffer.get()));
		}
		
		private boolean getTheAiControlled(short code) {
			if(code == 0) return false;
			return true;
		}
		
		private String getYourTelemetry(short code) {
			if(code == 0) return "Restricted";
			return "Public";
		}
		
		private String getTheDriverName(short code) {
			for(DriverNames dn : DriverNames.values())
				if(dn.getCode() == code)
					return dn.getDriverName();
			return "ParticipantsData:getTheDriverName=Invalid Code! id=" + code;
		}
		
		private String getTheTeamName(short code) {
			for(Teams t : Teams.values())
				if(t.getCode() == code)
					return t.getTeamName();
			return "ParticipantsData:getTheTeamName=Not Specified";
		}
		
		private String getTheRaceName(short code) {
			for(Race r : Race.values())
				if(r.getCode() == code)
					return r.getRaceName();
			return "ParticipantsData:getTheRaceName=Invalid race code! id=" + code;
		}
}
