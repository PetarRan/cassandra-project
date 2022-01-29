package petarran.springframework.domain_model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table("cart")
public class Cart {
    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    private List<Product> productListCart;
    private LocalDateTime localDateTime;


}
