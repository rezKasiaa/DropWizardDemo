package DAO;

import api.Brand;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface BrandDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS Brands (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, primary key(id))")
    void createBrandTable();

    @SqlUpdate("INSERT INTO Brands (NAME) VALUES(:name)")
    @GetGeneratedKeys
    Long addBrand(@BindBean Brand brand);

    @SqlQuery("SELECT * FROM Brands")
    List<Brand> getAll();

    @SqlQuery("SELECT * FROM Brands WHERE id = :id")
    Brand getById(@Bind("id") Long id);

    @SqlUpdate("DELETE FROM Brands WHERE id = :id")
    Long removeBrandById(@Bind("id") Long id);
}

