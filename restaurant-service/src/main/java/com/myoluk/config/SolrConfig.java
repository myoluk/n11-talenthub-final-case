package com.myoluk.config;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = "com.myoluk")
public class SolrConfig {

    private static final String SOLR_URL = "http://localhost:8983/solr";

    @Bean
    public SolrTemplate solrTemplate() {
        return new SolrTemplate(solrClient());
    }

    @Bean
    public HttpSolrClient solrClient() {
        return new HttpSolrClient.Builder(SOLR_URL).build();
    }
}
