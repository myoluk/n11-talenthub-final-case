package com.myoluk.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.UUID;

@SolrDocument(solrCoreName = "restaurants")
@Getter
@Setter
@AllArgsConstructor
public class Restaurant {

    @Id
    @Indexed(name = "id", type = "string")
    private String id;

    @Indexed(name = "name", type = "string")
    private String name;

    @Indexed(name = "latitude", type = "pdouble")
    private double latitude;

    @Indexed(name = "longitude", type = "pdouble")
    private double longitude;

    @Indexed(name = "score", type = "pint")
    private int score;

    public Restaurant() {
        this.id = UUID.randomUUID().toString();
    }
}
