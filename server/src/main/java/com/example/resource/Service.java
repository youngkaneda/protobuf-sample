package com.example.resource;

import com.example.protobuff.source.AddressBookProto;

import javax.ws.rs.*;

@Path("/person")
public class Service {

    @GET
    @Produces("application/x-protobuf")
    public AddressBookProto.Person find() {
        return AddressBookProto.Person.newBuilder()
                .setId(1)
                .setName("Juan")
                .setEmail("juanpablolvl99@icloud.com")
                .addPhone(AddressBookProto.Person.PhoneNumber
                        .newBuilder().setNumber("83991071919")
                        .setType(AddressBookProto.Person.PhoneType.MOBILE)
                        .build())
                .build();
    }

    @POST
    @Consumes("application/x-protobuf")
    public AddressBookProto.Person create(AddressBookProto.Person person) {
        // add to any storage
        return person;
    }
}
