package aj.csi.pim.lead;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CountryMaster {
	
	private String id;
	
	private String countryCode;
	
	private String countryName;
	
	private String numberCode;
	private String continent;
	private String timeZone;
	private String language;
	
	
	private String junoBusinessAlias;
	
	
	
	private String junoBusinessId;
	
	
	
	private String junoAccountId;
	
	
	
	private String junoAccountAlias;
	
	
	
	private String tenantId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getNumberCode() {
		return numberCode;
	}

	public void setNumberCode(String numberCode) {
		this.numberCode = numberCode;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getJunoBusinessAlias() {
		return junoBusinessAlias;
	}

	public void setJunoBusinessAlias(String junoBusinessAlias) {
		this.junoBusinessAlias = junoBusinessAlias;
	}

	public String getJunoBusinessId() {
		return junoBusinessId;
	}

	public void setJunoBusinessId(String junoBusinessId) {
		this.junoBusinessId = junoBusinessId;
	}

	public String getJunoAccountId() {
		return junoAccountId;
	}

	public void setJunoAccountId(String junoAccountId) {
		this.junoAccountId = junoAccountId;
	}

	public String getJunoAccountAlias() {
		return junoAccountAlias;
	}

	public void setJunoAccountAlias(String junoAccountAlias) {
		this.junoAccountAlias = junoAccountAlias;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	 public static CountryMaster defaultCountryCode() {
		 CountryMaster countryCode = new CountryMaster();
			countryCode.setCountryCode("IN");
			countryCode.setNumberCode("+91");
			countryCode.setCountryName("INDIA");
			return countryCode;
		}
	
	 public static List<CountryMaster> load()
		{
			ObjectMapper objectMapper = new ObjectMapper();
			try
			{
				CollectionType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, CountryMaster.class);
				List<CountryMaster> countryCodeList = objectMapper.readValue(CountryMaster.class.getClassLoader().getResourceAsStream("countrycode.json"), javaType);
				return countryCodeList;

			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ArrayList<CountryMaster>();
		}

		public static void main(String args[])
		{
			CountryMaster.load();
		}
}
