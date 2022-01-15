package petarran.springframework.domain_model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


import javax.annotation.Generated;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

/**
 * Entity Model
 */
@Table("products")
public class Product implements Serializable{

    //TODO id sequence resenje Lukiano pls
    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private Integer id;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private String city;
    private String country;
    private String continent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Product() {
        this.id = new Random().nextInt();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
