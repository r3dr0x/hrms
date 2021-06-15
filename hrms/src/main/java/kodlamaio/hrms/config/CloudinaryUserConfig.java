package kodlamaio.hrms.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryUserConfig {
    @Bean(name = {"getCloudinaryUser", "Cloudinary"})
    public Cloudinary getCloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "di31ntvmx",
                "api_key", "114893189263926",
                "api_secret", "tytQRRil1oZ9dCDybXEPmYuGvls"));
    }
}
