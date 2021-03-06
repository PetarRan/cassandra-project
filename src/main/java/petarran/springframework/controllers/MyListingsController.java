package petarran.springframework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petarran.springframework.domain_model.MyListings;
import petarran.springframework.domain_model.Product;
import petarran.springframework.services.MyListingsService;
import petarran.springframework.services.ProductService;

import java.util.Collection;
import java.util.UUID;

/**
 *
 */
@RestController
@RequestMapping("/admin-api/listings-api")
public class MyListingsController {
    private final ProductService productService;
    private final MyListingsService myListingsService;

    public MyListingsController(ProductService productService, MyListingsService myListingsService){
        this.productService = productService;
        this.myListingsService = myListingsService;
    }

    @GetMapping(
            value = "/getAll"
            )
    public Collection<MyListings> getAll(){
        return myListingsService.listAll();
    }

    @GetMapping(
            value = "/getMyAll/{userid}"
    )
    public Collection<MyListings> getMyAll(@PathVariable("userid")String userid){
        return myListingsService.myListAll(userid) ;//TODO
    }

    @GetMapping(
            value = "/getByContinent/{userid}/{continent}"
    )
    public Collection<MyListings> getByContinent(@PathVariable("userid")String userid,
                                                 @PathVariable("continent") String continent){
        return myListingsService.getByContinent(userid, continent);
    }

    @GetMapping(
            value = "/getByContinent/{userid}/{continent}/{country}"
    )
    public Collection<MyListings> getByCountry(@PathVariable("userid")String userid,
                                               @PathVariable("continent") String continent,
                                            @PathVariable("country") String country){
        return myListingsService.getByCountry(userid, continent, country);
    }

    @GetMapping(
            value = "/getByCode/{userid}/{continent}/{country}/{city}/{id}"
    )
    public MyListings getByCode(@PathVariable("userid")String userid,
                                            @PathVariable("continent") String continent,
                                            @PathVariable("country") String country,
                                            @PathVariable("city") String city,
                                            @PathVariable("id")String id){
        return myListingsService.findByCode(userid, continent, country, city, id);
    }

    @GetMapping(
            value = "/getByCity/{userid}/{continent}/{country}/{city}"
    )
    public Collection<MyListings> getByCity(@PathVariable("userid")String userid,
                                                 @PathVariable("continent") String continent,
                                              @PathVariable("country") String country,
                                              @PathVariable("city") String city){
        return myListingsService.getByCity(userid, continent, country, city);
    }

    @DeleteMapping(
            value = "/deleteListing",
            produces = {"application/json"}
    )
    public HttpStatus deleteListing(@RequestBody(required = true) MyListings myListing) {
        try {
            myListingsService.deleteListing(myListing);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(
            value = "/updateListing",
            produces = {"application/json"}
    )
    public HttpStatus updateListing(@RequestBody(required = true) MyListings myListing) {
        try {
            myListingsService.update(myListing);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

}
