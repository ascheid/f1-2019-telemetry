/**
 * 
 */
package ca.scheid.utils;

import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com Apr 8, 2020
 */
public abstract class Utils {
	
	public static short[] getArrayOfuint16(ByteBuffer byteBuffer) {
		short[] aux = new short[4];
		for(int i=0; i<4; i++) aux[i] = convert_uint16(byteBuffer.getShort());
		return aux;
	}
	
	public static short[] getArrayOfuint8(ByteBuffer byteBuffer) {
		short[] aux = new short[4];
		for(int i=0; i<4; i++) aux[i] = convert_uint8(byteBuffer.get());
		return aux;
	}
	
	public static float[] getArrayOfFloats(ByteBuffer byteBuffer) {
		float[] aux = new float[4];
		for(int i=0; i<4; i++) aux[i] = byteBuffer.getFloat();
		return aux;
	}
	
	public static short convert_uint16(short s) {
		return (short) (s & 0xffff);
	}

	public static short convert_uint8(byte b) {
		return b;
	}

	public static BigInteger convert_uint64(long l) {
		BigInteger b = BigInteger.valueOf(l);
		return b;
	}

	public static float convert_float(float f) {
		return f;
	}

	public static float convert_float_normalised_vector(short f) {
		return f / 32767.0f;
	}

	public static long convert_uint32(int i) {
		return i;
	}

	public static String getFormattedDelta(float delta) {
		if (delta > 5000f && delta < 5100f) {
			return "+ " + (int) (delta - 5000f) + " LAPS";
		} else {
			if (Float.isInfinite(delta)) {
				return "";
			}
			if (delta == 0) {
				return "+/-";
			}
			int decimals = (int) Math.abs(delta * 1000) % 1000;
			String pad = "";
			if (decimals == 0) {
				return (int) delta + ".000";
			}
			if (decimals < 10) {
				pad = "00";
			} else if (decimals < 100) {
				pad = "0";
			}

			return (int) (delta) + "." + pad + "" + decimals;
		}
	}

	public static String getFormattedDeltaQualifying(float delta) {
		if (Float.isNaN(delta)) {
			return "";
		}
		if (delta == 0) {
			return "+/-";
		}
		int decimals = (int) (delta * 1000) % 1000;
		String pad = "";
		if (decimals < 10) {
			pad = "00";
		} else if (decimals < 100) {
			pad = "0";
		}

		return (int) (delta) + "." + pad + "" + decimals;
	}

	public static String printFormattedFloat(float f) {
		char sign = ' ';
		if (f < 0f) {
			sign = '-';
		}
		int uds = Math.abs((int) f);
		int decimals = (int) Math.abs((f * 1000) % 1000);
		if (decimals == 0) {
			return sign + "" + uds + ".00";
		}
		if (decimals < 10) {
			return sign + "" + uds + ".0" + decimals;
		}
		return sign + "" + uds + "." + decimals;
	}
}
