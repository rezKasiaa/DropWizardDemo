package resources;


import DAO.BrandDAO;
import api.Brand;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/brands")
@Produces(MediaType.APPLICATION_JSON)
public class BrandResource {
    private BrandDAO brandDao;

    public BrandResource(BrandDAO brandDao) {
        this.brandDao = brandDao;
    }

    @GET
    @Path("/getAll")
    public List<Brand> getBrands() {
        return this.brandDao.getAll();
    }

    @GET
    @Path("/{id}")
    public Brand getById(@PathParam("id") Long id) {
        return brandDao.getById(id);
    }

    @POST
    public Brand addBrand(@Valid Brand brand) {
        Long brandID = this.brandDao.addBrand(brand);
        brand.setId(brandID);
        return brand;
    }

    @DELETE
    @Path("/remove/{id}")
    public Integer removeEmployee(@PathParam("id") Integer id) {
        this.brandDao.removeBrandById(id);
        return id;
    }

    public void createTable() {
        this.brandDao.createBrandTable();
    }
}