package org.hibernate.search.demos.quarkuskotlin.dto

import org.hibernate.search.engine.search.query.SearchResult

data class SearchResultDto<T>(val total: Long, val hits: List<T>) {
    companion object {
        fun <H, T> from(result: SearchResult<H>, toDto: (H) -> T) =
                SearchResultDto(result.totalHitCount(), result.hits().map(toDto))
    }
}