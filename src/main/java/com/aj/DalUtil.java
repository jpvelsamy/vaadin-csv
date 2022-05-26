package com.aj;

import java.util.Random;
import java.util.UUID;

public class DalUtil
{
	public static String createLongId()
	{
		UUID uuid = UUID.randomUUID();
		String nonHypenatedValue = Long.toString(uuid.getMostSignificantBits() & Long.MAX_VALUE);
		return nonHypenatedValue;
	}

	public static String plainUUID() {
		UUID uid = UUID.randomUUID();
		String leadId = uid.toString();
		return leadId;
	}

	public static int generateRandomNo(int min, int max)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}
