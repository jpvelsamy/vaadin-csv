package aj.csi.pim.lead;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountryCode
{

	private String code;
	private String name;
	@JsonProperty(value="dial_code")
	private String numberCode;
	private String latitude;
	private String longitude;

    public static CountryCode defaultCountryCode() {
		CountryCode countryCode = new CountryCode();
		countryCode.setCode("IN");
		countryCode.setNumberCode("+91");
		countryCode.setName("INDIA");
		return countryCode;
	}

    public String getCode()
	{
		return code;
	}

	public void setCode(String countryCode)
	{
		this.code = countryCode;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String countryName)
	{
		this.name = countryName;
	}

	public String getNumberCode()
	{
		return numberCode;
	}

	public void setNumberCode(String numberCode)
	{
		this.numberCode = numberCode;
	}

	public String getLatitude()
	{
		return latitude;
	}

	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}

	public String getLongitude()
	{
		return longitude;
	}

	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}

	public static List<CountryCode> load()
	{
		ObjectMapper objectMapper = new ObjectMapper();
		try
		{
			CollectionType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, CountryCode.class);
			List<CountryCode> countryCodeList = objectMapper.readValue(CountryCode.class.getClassLoader().getResourceAsStream("countrycode.json"), javaType);
			return countryCodeList;

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<CountryCode>();
	}

	public static void main(String args[])
	{
		CountryCode.load();
	}
}
