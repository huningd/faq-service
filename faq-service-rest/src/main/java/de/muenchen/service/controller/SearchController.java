package de.muenchen.service.controller;

import de.muenchen.service.domain.FaqEntity;
import de.muenchen.service.search.FaqSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dennis_huning on 05.01.16.
 */
@BasePathAwareController
@ExposesResourceFor(FaqEntity.class)
@Controller
public class SearchController {

    @Autowired
    private FaqSearch faqSearch;

    /**
     * Show search results for the given query.
     *
     * @param q The search query.
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> search(PersistentEntityResourceAssembler assembler, @Param("q") String q) {
        Stream<FaqEntity> searchResults = null;
        try {
            searchResults = faqSearch.search(q).stream();
        } catch (Exception ex) {
            throw ex;
        }
        final List<PersistentEntityResource> collect = searchResults.map(assembler::toResource).collect(Collectors.toList());
        return new ResponseEntity<Object>(new Resources(collect), HttpStatus.OK);
    }

}
