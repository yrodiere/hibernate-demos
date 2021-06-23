/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.demos.wikipedia.data.config;

import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;

import org.apache.lucene.analysis.charfilter.HTMLStripCharFilterFactory;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.core.WhitespaceTokenizerFactory;
import org.apache.lucene.analysis.en.PorterStemFilterFactory;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import org.springframework.stereotype.Component;

@Component("luceneAnalysisConfigurerSpringBean")
public class HsearchLuceneWikipediaAnalysisConfigurer implements LuceneAnalysisConfigurer {
	@Override
	public void configure(LuceneAnalysisConfigurationContext context) {
		context.analyzer( "cleaned_text" ).custom()
				.tokenizer( WhitespaceTokenizerFactory.class )
				.charFilter( HTMLStripCharFilterFactory.class )
				.tokenFilter( ASCIIFoldingFilterFactory.class )
				.tokenFilter( LowerCaseFilterFactory.class )
				.tokenFilter( StopFilterFactory.class )
				.tokenFilter( PorterStemFilterFactory.class );

		context.normalizer( "cleaned_keyword" ).custom()
				.tokenFilter( ASCIIFoldingFilterFactory.class )
				.tokenFilter( LowerCaseFilterFactory.class );
	}
}
