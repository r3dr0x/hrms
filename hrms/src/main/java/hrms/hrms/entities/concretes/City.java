package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="cities")

public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
		private int cityId;
		
	@Column(name = "city_name")
		private String cityName;
		
	@OneToMany(mappedBy = "city")
	private List<JobAdvert> jobAdvertisement;
		
}
