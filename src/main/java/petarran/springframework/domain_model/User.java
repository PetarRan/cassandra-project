package petarran.springframework.domain_model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("users")
public class User {
    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    private String userId;
}
