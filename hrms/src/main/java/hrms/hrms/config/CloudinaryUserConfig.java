package hrms.hrms.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryUserConfig {
    @Bean(name = {"getCloudinaryUser", "Cloudinary"})
    public Cloudinary getCloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dudumbfos",
                "api_key", "685191128276314",
                "api_secret", "ZGhW8KbMkSf6Dq-u82teEkaznMM"));
    }
}
