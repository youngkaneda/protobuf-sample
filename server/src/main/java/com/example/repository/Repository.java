package com.example.repository;

import com.example.protobuff.source.AddressBookProto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repository {

    private List<AddressBookProto.Person> persons;

    public Repository() {
        this.persons = new ArrayList<>();
    }

    public boolean save(AddressBookProto.Person person) {
        return this.persons.add(person);
    }

    public Optional<AddressBookProto.Person> findOne(int id) {
        return persons.stream().filter((p) -> p.getId() == id).findFirst();
    }

    public List<AddressBookProto.Person> getPersons() {
        return persons;
    }

    public boolean update(AddressBookProto.Person person) {
        Optional<Integer> index = persons.stream().filter((p) -> p.getId() == person.getId()).map(AddressBookProto.Person::getId).findFirst();
        index.ifPresent((i) -> persons.set(i, person));
        return index.isPresent();
    }

    public void delete(int id) {
        this.findOne(id).ifPresent((p) -> persons.remove(p));
    }
}
