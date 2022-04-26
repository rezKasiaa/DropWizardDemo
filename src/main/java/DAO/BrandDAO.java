package DAO;

import api.Brand;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface BrandDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS brand (\n" +
            "                                        id SERIAL PRIMARY KEY,\n" +
            "                                        name varchar(45) NOT NULL\n" +
            "                            );")
    void createBrandTable();

    @SqlUpdate("INSERT INTO brand (id, \"name\") VALUES (:id, :name)")
    @GetGeneratedKeys
    Long addBrand(@BindBean Brand brand);

    @SqlQuery("SELECT * FROM brand")
    List<Brand> getAll();

    @SqlQuery("SELECT * FROM brand WHERE id = :id")
    Brand getById(@Bind("id") Long id);

    @SqlUpdate("DELETE FROM brand WHERE id = :id")
    Long removeBrandById(@Bind("id") Long id);
}

