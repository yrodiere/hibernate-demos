package org.hibernate.search.demos.quarkuskotlin.search

import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurationContext
import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurer

class TShirtAnalysisConfigurer : ElasticsearchAnalysisConfigurer {
    override fun configure(context: ElasticsearchAnalysisConfigurationContext) {
        context.analyzer("english").custom()
                .tokenizer("standard")
                .tokenFilters("stemmer-english", "lowercase", "asciifolding")
        context.tokenFilter("stemmer-english")
                .type("stemmer")
                .param("language", "english")
    }
}