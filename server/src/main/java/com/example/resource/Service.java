package com.example.resource;

import com.example.protobuff.source.AddressBookProto;
import com.example.repository.Repository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/persons")
public class Service {

    @Inject @SessionScoped
    private Repository repo;

    @GET
    @Produces("application/x-protobuf")
    public AddressBookProto.AddressBook findAll() {
        return AddressBookProto.AddressBook.newBuilder()
                .addAllPerson(repo.getPersons())
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/x-protobuf")
    public AddressBookProto.Person findOne(@PathParam("id") int id) {
        return repo.findOne(id).orElse(AddressBookProto.Person.newBuilder().build());
    }

    @POST
    @Consumes("application/x-protobuf")
    @Produces("application/x-protobuf")
    public AddressBookProto.Person create(AddressBookProto.Person person) {
        repo.save(person);
        return person;
    }

    @PUT
    @Consumes("application/x-protobuf")
    @Produces("application/x-protobuf")
    public AddressBookProto.Person update(AddressBookProto.Person person) {
        repo.update(person);
        return person;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        repo.delete(id);
    }
}
