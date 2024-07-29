package net.media.training.designpattern.builder;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: path
 * Date: Jul 19, 2011
 * Time: 10:04:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class PeopleDataSource {
    public static String getPeopleXml(List<Person> persons) {
        XMLElementBuilder builder = new XMLElementBuilder();
        String declarationTag = builder
            .setIsSpecialTag(true)
            .setAttribute("version", "1.0")
            .setAttribute("encoding", "UTF-8")
            .build();
        builder.reset();
        builder.setRoot("People").setAttribute("number", String.valueOf(persons.size()));
        persons.forEach(person -> builder.setChild(getPersonXML(person)));
        return declarationTag + builder.build();
    }

    public static String getPersonXML(Person person) {
        XMLElementBuilder builder = new XMLElementBuilder();
        builder.setRoot("Person")
            .setAttribute("id", String.valueOf(person.getId()))
            .setAttribute("name", person.getName())
            .setChild(new XMLElementBuilder().setRoot("Address")
                .setChild(new XMLElementBuilder()
                    .setRoot("City")
                    .setChild(person.getCity()).build())
                .setChild(new XMLElementBuilder()
                    .setRoot("Country")
                    .setChild(person.getCountry()).build())
                .build()
            );
        return builder.build();
    }
}